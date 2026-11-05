package API_Base_Classes;

import static io.restassured.config.EncoderConfig.encoderConfig;

import java.util.HashMap;
import java.util.Map;

import api_Common_Utilities.ConfigFileManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class existingUser_LogIn {

	public static String accessToken;
	public static String refreshToken;
	public static String idToken;
	public static String sessionId;
	public static String clientId;
	public static String languageCode;	
	
	private static Map<String, String> buildLoginRequestBody (String username, String password){
		
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("username", username);
		requestBody.put("password", password);
		requestBody.put("captchaResponse", null);
		requestBody.put("isExistingUser", "d76b7c97a1d448873388800a3da3f32a");
		
		return requestBody;
	}
	
	private static Map<String, String> launch_log_in(String username, String password) {
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("application/x-amz-json-1.1", io.restassured.http.ContentType.JSON));
        
        Map<String, String> requestBody = buildLoginRequestBody(username, password);
        
        Response res = RestAssured.given()
                .body(requestBody)
                .header("fingerprint-hash", "7da0beca2ed821dd9ca4758bf1f53a1073cf39efa3c2da209bf8ec80412d86e8")
                .when()
                .post("https://api.qa-wci-auction.org/qa-user/api/login")
                .then().assertThat().statusCode(200).extract().response();
 
        JsonPath jsonbody = res.jsonPath();
        
        String refreshToken = jsonbody.getString("data.refreshToken.token");
        String accessToken = jsonbody.getString("data.accessToken.jwtToken");
        String idToken = jsonbody.getString("data.idToken.jwtToken");
        String sessionId = jsonbody.getString("data.sessionId");
        String clientId = jsonbody.getString("data.clientId");
        String languageCode = jsonbody.getString("data.languageCode");
 
        Map<String, String> tokenData = new HashMap<>();
        tokenData.put("refreshToken", refreshToken);
        tokenData.put("accessToken", accessToken);
        tokenData.put("idToken", idToken);
        tokenData.put("sessionId", sessionId);
        tokenData.put("clientId", clientId);
        tokenData.put("languageCode", languageCode);
 
        return tokenData;
    }
	
	public static void logInUser(String username, String password) {
		Map<String, String> tokens = launch_log_in(username, password);
		
		 accessToken = tokens.get("accessToken");
		 refreshToken = tokens.get("refreshToken");
		 idToken = tokens.get("idToken");
		 sessionId = tokens.get("sessionId");
		 clientId = tokens.get("clientId");
		 languageCode = tokens.get("languageCode");
		
        System.out.println("access Token: " + accessToken);
        System.out.println("refresh Token: " + refreshToken);
        System.out.println("Id Token: " + idToken);
        System.out.println("session Id: " + sessionId);
        System.out.println("client Id: " + clientId);
        System.out.println("language Code: " + languageCode);
	}
}