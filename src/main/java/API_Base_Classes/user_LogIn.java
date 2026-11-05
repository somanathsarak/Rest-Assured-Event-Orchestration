package API_Base_Classes;

import static io.restassured.config.EncoderConfig.encoderConfig;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import TestData.UsersAndMFASecreteKey;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class user_LogIn {

	public static String accessToken;
	public static String refreshToken;
	public static String idToken;
	public static String sessionId;
	public static String clientId;
	public static String languageCode;
	public static String cognitoSession;

	public static String jurisdictionCode = "CA";
	public static String captchaResponse = null; // set a value only if QA needs it

	private static String loginSessionId; // 32-hex id used as IV and session-id header for login

	private static final String FINGERPRINT = "7da0beca2ed821dd9ca4758bf1f53a1073cf39efa3c2da209bf8ec80412d86e8";
	private static final String AES_KEY = System.getProperty("aes.key", "f1b82fa36f5a28c67aded60c86073d20");

	// ------------------------------------------------------------------
	// LOGIN (method names kept same as user_LogIn)
	// ------------------------------------------------------------------
	private static Map<String, String> buildLoginRequestBody(String username, String password) {

		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("username", username);
		requestBody.put("password", encryptAES(password, loginSessionId));
		requestBody.put("captchaResponse", captchaResponse);
		requestBody.put("isExistingUser", encryptAES("false", loginSessionId));

		return requestBody;
	}

	private static Map<String, String> launch_log_in(String username, String password) {
		RestAssured.config = RestAssured.config().encoderConfig(encoderConfig()
				.encodeContentTypeAs("application/x-amz-json-1.1", io.restassured.http.ContentType.JSON));

		loginSessionId = newSessionId();
		Map<String, String> requestBody = buildLoginRequestBody(username, password);

		Response res = RestAssured.given().body(requestBody).header("fingerprint-hash", FINGERPRINT)
				.header("session-id", loginSessionId).header("jurisdiction-code", jurisdictionCode)
				.header("language-code", "en").when().post("https://api.qa-wci-auction.org/qa-user/api/login").then()
				.assertThat().statusCode(200).extract().response();

		JsonPath jsonbody = res.jsonPath();

		Map<String, String> data = new HashMap<>();

		// Store only fields that are present and have non-null values
		addIfPresent(data, "refreshToken", jsonbody.getString("data.refreshToken.token"));
		addIfPresent(data, "accessToken", jsonbody.getString("data.accessToken.jwtToken"));
		addIfPresent(data, "idToken", jsonbody.getString("data.idToken.jwtToken"));
		addIfPresent(data, "cognitoSession", jsonbody.getString("data.cognitoSession"));
		addIfPresent(data, "sessionId", jsonbody.getString("data.sessionId"));
		addIfPresent(data, "clientId", jsonbody.getString("data.clientId"));
		addIfPresent(data, "languageCode", jsonbody.getString("data.languageCode"));

		return data;
	}

	private static void addIfPresent(Map<String, String> data, String key, String value) {

		if (value != null && !value.trim().isEmpty() && !"null".equalsIgnoreCase(value.trim())) {
			data.put(key, value);
		}
	}

	public static void logInUser(String username, String password, String secretKey) {
		Map<String, String> data = launch_log_in(username, password);

		// Execute MFA only when both fields are present
		if (data.containsKey("cognitoSession") && data.containsKey("sessionId")) {

			cognitoSession = data.get("cognitoSession");
			sessionId = data.get("sessionId");

			System.out.println("cognito Session: " + cognitoSession);
			System.out.println("session Id: " + sessionId);

			user_LogIn.verify_MFA(username, password, secretKey);

		} else {
			System.out.println("MFA verification skipped: cognitoSession and/or sessionId not present.");
		}

		if (data.containsKey("accessToken")) {
			accessToken = data.get("accessToken");
			System.out.println("access Token: " + accessToken);
		}

		if (data.containsKey("refreshToken")) {
			refreshToken = data.get("refreshToken");
			System.out.println("refresh Token: " + refreshToken);
		}

		if (data.containsKey("idToken")) {
			idToken = data.get("idToken");
			System.out.println("Id Token: " + idToken);
		}

		if (data.containsKey("clientId")) {
			clientId = data.get("clientId");
			System.out.println("client Id: " + clientId);
		}

		if (data.containsKey("languageCode")) {
			languageCode = data.get("languageCode");
			System.out.println("language Code: " + languageCode);
		}
		if (data.containsKey("sessionId")) {
	        sessionId = data.get("sessionId");
	        System.out.println("session Id: " + sessionId);
	    }
	}

	// ------------------------------------------------------------------
	// VERIFY MFA (new)
	// ------------------------------------------------------------------
	private static Map<String, String> buildVerifyRequestBody(String username, String totpCode) {

		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("username", username);
		requestBody.put("cognitoSession", cognitoSession);
		requestBody.put("totpCode", encryptAES(totpCode, sessionId));
		requestBody.put("sessionId", sessionId);

		return requestBody;
	}

	private static Map<String, String> launch_verify_MFA(String username, String totpSecret) {
		RestAssured.config = RestAssured.config().encoderConfig(encoderConfig()
				.encodeContentTypeAs("application/x-amz-json-1.1", io.restassured.http.ContentType.JSON));

		// 6 digits = ready code, otherwise treat as secret key and generate the code
		String totpCode = totpSecret.trim().matches("\\d{6}") ? totpSecret.trim() : generateTOTP(totpSecret);

		Map<String, String> requestBody = buildVerifyRequestBody(username, totpCode);

		Response res = RestAssured.given().body(requestBody).header("fingerprint-hash", FINGERPRINT)
				.header("session-id", sessionId).header("jurisdiction-code", jurisdictionCode)
				.header("language-code", "en").when()
				.post("https://api.qa-wci-auction.org/qa-user/api/mfa-login-verify").then().assertThat().statusCode(200)
				.extract().response();

		JsonPath jsonbody = res.jsonPath();

		Map<String, String> tokenData = new HashMap<>();
		tokenData.put("refreshToken", jsonbody.getString("data.refreshToken.token"));
		tokenData.put("accessToken", jsonbody.getString("data.accessToken.jwtToken"));
		tokenData.put("idToken", jsonbody.getString("data.idToken.jwtToken"));

		return tokenData;
	}

	public static void verify_MFA(String username, String password, String secretKey) {
		// If login was not done yet, do it now
		if (cognitoSession == null || sessionId == null) {
			logInUser(username, password, secretKey);
		}

		Map<String, String> tokens = launch_verify_MFA(username, secretKey);

		accessToken = tokens.get("accessToken");
		refreshToken = tokens.get("refreshToken");
		idToken = tokens.get("idToken");

		System.out.println("access Token: " + accessToken);
		System.out.println("refresh Token: " + refreshToken);
		System.out.println("Id Token: " + idToken);
		System.out.println("session Id: " + sessionId);
		System.out.println("client Id: " + clientId);
		System.out.println("language Code: " + languageCode);
	}

	// ------------------------------------------------------------------
	// HELPERS
	// ------------------------------------------------------------------
	private static String newSessionId() {
		byte[] r = new byte[16];
		new SecureRandom().nextBytes(r);
		return toHex(r);
	}

	private static String encryptAES(String value, String sessionIdHex) {
		try {
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(AES_KEY.getBytes(StandardCharsets.UTF_8), "AES"),
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
			int bin = ((h[off] & 0x7f) << 24) | ((h[off + 1] & 0xff) << 16) | ((h[off + 2] & 0xff) << 8)
					| (h[off + 3] & 0xff);
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
			if (val < 0)
				throw new IllegalArgumentException("Invalid Base32 char: " + ch);
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
		for (byte x : b)
			sb.append(String.format("%02x", x));
		return sb.toString();
	}

	private static byte[] fromHex(String s) {
		byte[] out = new byte[s.length() / 2];
		for (int i = 0; i < out.length; i++)
			out[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
		return out;
	}
}