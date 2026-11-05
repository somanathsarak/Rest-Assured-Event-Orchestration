package userCreation;

import static API_Base_Classes.user_LogIn.accessToken;
import static API_Base_Classes.user_LogIn.idToken;
import static API_Base_Classes.user_LogIn.languageCode;
import static API_Base_Classes.user_LogIn.refreshToken;
import static API_Base_Classes.user_LogIn.sessionId;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import api_Common_Utilities.RestClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class userCreation {
	public static String BaseUrl = "https://api.qa-wci-auction.org/qa-";

	public static String sponsorRoleId;
	public static void getAllROles() {
		String url = BaseUrl+"auth/api/get-all-roles";
		
		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));
		
		JsonPath jsonPath = res.jsonPath();

        List<Map<String, Object>> roles = jsonPath.getList("data");

        sponsorRoleId = null;
        for (Map<String, Object> role : roles) {
            if ("Sponsor".equals(role.get("Role_Name"))) {
                sponsorRoleId = String.valueOf(role.get("Role_ID"));
                break;
            }
        }
	}
	
	 public static String generateRandomString(int length) {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder result = new StringBuilder();
	        Random random = new Random();
	        for (int i = 0; i < length; i++) {
	            result.append(characters.charAt(random.nextInt(characters.length())));
	        }
	        return result.toString();
	    }
	 
	 public static String EmailId;
	public static void checkEmailIsExist() {
		EmailId = "API_" + generateRandomString(4) + "@yopmail.com";
		
		String url = BaseUrl+ "user/api/get-user-details/"+ EmailId;
		
		RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));
	}
	
	public static String firstName;
	public static String lastName;
	public static void addUser() {
		String url = BaseUrl+"user/api/user/add-user";
		
		firstName = "API_User"+ generateRandomString(4);
		lastName = "API_User"+ generateRandomString(4);
		
		Map<String, Object> user = new HashMap<>();
		user.put("firstname", firstName);
		user.put("lastname", lastName);
		user.put("email", EmailId);
		user.put("role", sponsorRoleId);
		
		RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), user);
	}
	
	
	public static void userList() {
		
		String url = BaseUrl+"user/api/user-list";
				
				Response res = given().queryParam("filterString", "")
					    .queryParam("filterSection", "").queryParam("filterSectionValue", "")
					    .queryParam("filterByStatus", "all").queryParam("sortBy", "").queryParam("sortOrder", "")
					    .queryParam("numberOfRows", 2000).queryParam("pageNumber", 1).queryParam("filterByJurisdiction", 0)
					    .queryParam("filterByRole", 0)
				.header("content-type", "application/json").header("access-token", accessToken)
				.header("authorization", idToken).header("language-code", languageCode)
				.header("refresh-token", refreshToken).header("session-id", sessionId)
				.header("Entity-Id", System.getProperty("entityId")).when().get(url).then().assertThat().statusCode(200)
				.extract().response();
				
				JsonPath jsonPath = res.jsonPath();

		        List<Map<String, Object>> users = jsonPath.getList("data.userList");

		        String userId = null;
		        String userEntityGroupAssnId = null;

//		        String email = "TEST_USER@yopmail.com";
		        
		        for (Map<String, Object> user : users) {
		            if (EmailId.equals(user.get("Email_Address"))) {
		                userId = String.valueOf(user.get("User_ID"));
		                userEntityGroupAssnId = String.valueOf(user.get("userEntityGroupAssnId"));
		                break;
		            }
		        }
		        System.setProperty("User_ID", userId);
		        System.setProperty("userEntityGroupAssnId", userEntityGroupAssnId);
		        System.out.println("User_ID: "+ userId);
		    }
	
	public static void resendActivationLink() {
		String url = BaseUrl+"user/api/resend-activation-link";
		
		Map<String, Object> resend = new HashMap<>();
		resend.put("userId", System.getProperty("User_ID"));
		
		RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), resend);
		
	}
	
	public static void getSecurityQuestions() {
		String url = BaseUrl+"user/api/get-security-questions/en";
		
		Response res = given().header("session-id", "8d78e4daa47fd12b2413c0afa94ceb44").when().get(url).then()
				.assertThat().statusCode(200).extract().response();
		
		JsonPath jsonPath = res.jsonPath();
        List<Map<String, Object>> questions = jsonPath.getList("data");
        Map<String, String> questionVariables = new HashMap<>();
		int counter = 1;
        for (Map<String, Object> question : questions) {
            if (counter > 10) break; // limit to 10

            String questionId = String.valueOf(question.get("Security_Question_ID"));
            questionVariables.put("Security_Question_" + counter, questionId);
            counter++;
        }

        questionVariables.forEach((key, value) -> {
            System.out.println(key + " = " + value);
            System.setProperty(key, value);
        });
    }
	
	public static void languageId() {
		String url = BaseUrl+"user/api/jurisdiction-list-filter";
		
		Response res = given().header("session-id", "8d78e4daa47fd12b2413c0afa94ceb44").when().get(url).then()
				.assertThat().statusCode(200).extract().response();
		
		JsonPath jsonPath = res.jsonPath();
        String languageId = jsonPath.getString("data.find { it.Entity_Legal_Name == 'California' }.Entity_ID");
        System.out.println("languageId: " + languageId);
        System.setProperty("languageId", languageId);
	}
	
	public static void setUpCredential() {
		String url = BaseUrl+"user/api/set-up-credentials";
		
		 List<Map<String, String>> securityQuestions = new ArrayList<>();

	        securityQuestions.add(Map.of(
	            "quesId", System.getProperty("Security_Question_1"),
	            "answer", "Answer_1"
	        ));

	        securityQuestions.add(Map.of(
	            "quesId", System.getProperty("Security_Question_2"),
	            "answer", "Answer_2"
	        ));

	        securityQuestions.add(Map.of(
	            "quesId", System.getProperty("Security_Question_3"),
	            "answer", "Answer_3"
	        ));

	        Map<String, Object> requestBody = new HashMap<>();
	        requestBody.put("passphrase", "VGVzdEAxMjM0");
	        requestBody.put("confirmPassphrase", "VGVzdEAxMjM0");
	        requestBody.put("securityQuestions", securityQuestions);
	        requestBody.put("registrationUrl", "");
	        requestBody.put("languageId", System.getProperty("languageId"));
	        requestBody.put("isAgree", true);
	        requestBody.put("captchaResponse", null);
	        Response res = given().header("session-id", "8d78e4daa47fd12b2413c0afa94ceb44").when().body(requestBody).post(url).then().assertThat().statusCode(200)
					.extract().response();
	        res.prettyPrint();
	}
	
	public static void activateUser() {
		String url = BaseUrl+"user/api/user/update-activation-status";
		
		 Map<String, Object> userEntry = new HashMap<>();
	        userEntry.put("userId", System.getProperty("User_ID"));
	        userEntry.put("userStatus", "INACTIVE");
	        userEntry.put("userEntityGroupAssnId", System.getProperty("userEntityGroupAssnId"));

	        Map<String, Object> requestBody = new HashMap<>();
	        requestBody.put("userData", Collections.singletonList(userEntry));
	        requestBody.put("actionName", "ACTIVE");
	        
	        RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
					System.getProperty("entityId"), requestBody);
	        
	}
}