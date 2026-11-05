package userCreation;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import api_Common_Utilities.RestClient;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static API_Base_Classes.user_LogIn.accessToken;
import static API_Base_Classes.user_LogIn.idToken;
import static API_Base_Classes.user_LogIn.languageCode;
import static API_Base_Classes.user_LogIn.refreshToken;
import static API_Base_Classes.user_LogIn.sessionId;

public class CryptoUtil {
    
    private static final String CRYPTO_ENCRYPT_KEY = "f1b82fa36f5a28c67aded60c86073d20"; // OBFUSCATE_KEY from env file
    private static final String IV_HEX = sessionId; // session ID
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    
    public static String encrypt(String data) throws Exception {
        byte[] keyBytes = CRYPTO_ENCRYPT_KEY.getBytes(StandardCharsets.UTF_8);
        byte[] ivBytes = hexToBytes(IV_HEX);
        
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
        
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        
        byte[] encrypted = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        
        return bytesToHex(encrypted);
    }
    

    public static String decrypt(String encryptedHex) throws Exception {
        byte[] keyBytes = CRYPTO_ENCRYPT_KEY.getBytes(StandardCharsets.UTF_8);
        byte[] ivBytes = hexToBytes(IV_HEX);
        byte[] encryptedBytes = hexToBytes(encryptedHex);
        
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
        
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        
        byte[] decrypted = cipher.doFinal(encryptedBytes);
        
        String decryptedString = new String(decrypted, StandardCharsets.UTF_8);
        return decryptedString.split("\\|")[0];
    }
    

    private static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
    
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    public static String encryptAndPrint(String data) {
        try {
            String encrypted = encrypt(data);
            System.out.println("Input: " + data + " -> Encrypted: " + encrypted);
            System.setProperty("encryptedId", encrypted);
            return encrypted;
        } catch (Exception e) {
            System.err.println("Encryption failed for: " + data + " - " + e.getMessage());
            return null;
        }
    }
    
    public static String decryptAndPrint(String encryptedHex) {
        try {
            String decrypted = decrypt(encryptedHex);
            System.out.println("Encrypted: " + encryptedHex + " -> Decrypted: " + decrypted);
            return decrypted;
        } catch (Exception e) {
            System.err.println("Decryption failed for: " + encryptedHex + " - " + e.getMessage());
            return null;
        }
    }

    public static boolean testEncryptionCycle(String data) {
        try {
            String encrypted = encrypt(data);
            String decrypted = decrypt(encrypted);
            boolean success = data.equals(decrypted);
            
            System.out.println("=== Encryption Cycle Test ===");
            System.out.println("Original: " + data);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
            System.out.println("Success: " + success);
            System.out.println("=============================");
            
            return success;
        } catch (Exception e) {
            System.err.println("Encryption cycle failed: " + e.getMessage());
            return false;
        }
    }
    public static void addFlag() {
    	
    	String url = "https://api.qa-wci-auction.org/qa-auction/api/sale-bids-flag-action";
    	
    	Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("saleBidIds", Collections.singletonList(System.getProperty("encryptedId")));
        requestBody.put("saleBidFlagType", "Add Flag");
        requestBody.put("comment", "Add");
        
        RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), requestBody);
    }
}