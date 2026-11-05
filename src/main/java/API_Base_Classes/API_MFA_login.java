package API_Base_Classes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class API_MFA_login {

    private static final String BASE_URI    = "https://api.qa-wci-auction.org";
    private static final String FINGERPRINT = "52bfc03bd64bb19c57cb6313f82d333bd34693b7d143fbeba91f5c83bc679c8d";
    private static final String ORIGIN      = "https://www.qa-wci-auction.org";

    // Can be overridden with -Daes.key=... ; otherwise uses the default below
    private static final String AES_KEY = System.getProperty("aes.key", "f1b82fa36f5a28c67aded60c86073d20");

    public static String jurisdictionCode = "CA";
    public static String captchaResponse  = System.getProperty("captcha", "<captcha-token-or-bypass>");

    // Filled by login_MFA (used by verify_MFA)
    private static String mfaSessionId;
    private static String cognitoSession;

    // Filled by verify_MFA (use in further APIs)
    public static String idToken;
    public static String accessToken;
    public static String refreshToken;

    // =====================================================
    // PUBLIC METHODS
    // =====================================================

    /** Step 1: login. Returns nothing; stores session data for verify_MFA. */
    public static void login_MFA(String username, String password) {
        String loginSession = newSessionId();

        Map<String, Object> body = new HashMap<>();
        body.put("username", username);
        body.put("password", encryptAES(password, loginSession));
        body.put("captchaResponse", captchaResponse);
        body.put("isExistingUser", encryptAES("false", loginSession));

        Response res = RestAssured.given()
                .baseUri(BASE_URI)
                .headers(headers(loginSession))
                .contentType(ContentType.JSON)
                .body(body)
                .post("/qa-user/api/login");

        if (res.statusCode() != 200) {
            throw new RuntimeException("login_MFA failed: " + res.statusCode() + " " + res.asString());
        }

        // ADJUST these JSON paths after printing res.asPrettyString() once
        cognitoSession = res.jsonPath().getString("data.cognitoSession");
        mfaSessionId   = res.jsonPath().getString("data.sessionId");
    }

    /**
     * Step 2: verify MFA. Returns nothing; stores idToken, accessToken, refreshToken.
     * totpSecret = user's Base32 secret key (a plain 6-digit code is also accepted).
     */
    public static void verify_MFA(String username, String password, String totpSecret) {
        // If login was not done yet, do it now
        if (mfaSessionId == null || cognitoSession == null) {
            login_MFA(username, password);
        }

        // 6 digits -> already a code; otherwise treat as secret and generate the code
        String totp = totpSecret.trim().matches("\\d{6}") ? totpSecret.trim() : generateTOTP(totpSecret);

        Map<String, Object> body = new HashMap<>();
        body.put("username", username);
        body.put("cognitoSession", cognitoSession);
        body.put("totpCode", encryptAES(totp, mfaSessionId));
        body.put("sessionId", mfaSessionId);

        Response res = RestAssured.given()
                .baseUri(BASE_URI)
                .headers(headers(mfaSessionId))
                .contentType(ContentType.JSON)
                .body(body)
                .post("/qa-user/api/mfa-login-verify");

        if (res.statusCode() != 200) {
            throw new RuntimeException("verify_MFA failed: " + res.statusCode() + " " + res.asString());
        }

        idToken      = res.jsonPath().getString("data.idToken.jwtToken");
        accessToken  = res.jsonPath().getString("data.accessToken.jwtToken");
        refreshToken = res.jsonPath().getString("data.refreshToken.token");
    }

    // =====================================================
    // HELPERS
    // =====================================================

    private static Map<String, String> headers(String sessionId) {
        Map<String, String> h = new HashMap<>();
        h.put("accept", "application/json, text/plain, */*");
        h.put("accept-language", "en-GB,en-US;q=0.9,en;q=0.8");
        h.put("fingerprint-hash", FINGERPRINT);
        h.put("jurisdiction-code", jurisdictionCode);
        h.put("language-code", "en");
        h.put("origin", ORIGIN);
        h.put("session-id", sessionId);
        h.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
                + "(KHTML, like Gecko) Chrome/154.0.0.0 Safari/537.36");
        return h;
    }

    private static String newSessionId() {
        byte[] r = new byte[16];
        new SecureRandom().nextBytes(r);
        return toHex(r);
    }

    private static String encryptAES(String value, String sessionIdHex) {
        try {
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE,
                    new SecretKeySpec(AES_KEY.getBytes(StandardCharsets.UTF_8), "AES"),
                    new IvParameterSpec(fromHex(sessionIdHex)));
            return toHex(c.doFinal(value.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("AES encryption failed", e);
        }
    }

    private static String generateTOTP(String secret) {
        try {
            byte[] key = base32Decode(secret);
            long counter = System.currentTimeMillis() / 1000 / 30;
            byte[] msg = ByteBuffer.allocate(8).putLong(counter).array();
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(key, "HmacSHA1"));
            byte[] h = mac.doFinal(msg);
            int off = h[h.length - 1] & 0x0f;
            int bin = ((h[off] & 0x7f) << 24) | ((h[off + 1] & 0xff) << 16)
                    | ((h[off + 2] & 0xff) << 8) | (h[off + 3] & 0xff);
            return String.format("%06d", bin % 1_000_000);
        } catch (Exception e) {
            throw new RuntimeException("TOTP generation failed", e);
        }
    }

    private static byte[] base32Decode(String input) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
        String s = input.replaceAll("=+$", "").replaceAll("\\s", "").toUpperCase();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int buffer = 0, bitsLeft = 0;
        for (char ch : s.toCharArray()) {
            int val = alphabet.indexOf(ch);
            if (val < 0) throw new IllegalArgumentException("Invalid Base32 char: " + ch);
            buffer = (buffer << 5) | val;
            bitsLeft += 5;
            if (bitsLeft >= 8) {
                out.write((buffer >> (bitsLeft - 8)) & 0xFF);
                bitsLeft -= 8;
                buffer &= (1 << bitsLeft) - 1;
            }
        }
        return out.toByteArray();
    }

    private static String toHex(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (byte x : b) sb.append(String.format("%02x", x));
        return sb.toString();
    }

    private static byte[] fromHex(String s) {
        byte[] out = new byte[s.length() / 2];
        for (int i = 0; i < out.length; i++)
            out[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
        return out;
    }
}