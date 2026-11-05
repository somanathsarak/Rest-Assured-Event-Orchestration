package Utilities;

import java.util.Random;

public class common_utilities {

	 public static String generateRandomString(int length) {
	        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        StringBuilder result = new StringBuilder(length);
	        
	        Random random = new Random();
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length());
	            result.append(characters.charAt(index));
	        }
	        return result.toString();
	    }
}