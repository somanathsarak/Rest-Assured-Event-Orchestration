package api_Common_Utilities;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

	public static RequestSpecification createBaseRequest(String accessToken, String idToken, String languageCode,
			String refreshToken, String sessionId, String entityId) {
		RequestSpecification request = given().contentType(ContentType.JSON).header("content-type", "application/json")
				.header("access-token", accessToken).header("authorization", idToken)
				.header("language-code", languageCode).header("refresh-token", refreshToken)
				.header("session-id", sessionId).header("entity-Id", entityId)
				.header("fingerprint-hash", "7da0beca2ed821dd9ca4758bf1f53a1073cf39efa3c2da209bf8ec80412d86e8");
		return request;
	}

	public static Response get(String endpoint, String accessToken, String idToken, String languageCode,
			String refreshToken, String sessionId, String entityId) {
		return createBaseRequest(accessToken, idToken, languageCode, refreshToken, sessionId, entityId).log().all().when()
				.get(endpoint).then().log().all().statusCode(200).extract().response();
	}

	public static Response post(String endpoint, String accessToken, String idToken, String languageCode,
			String refreshToken, String sessionId, String entityId, Object body) {
		return createBaseRequest(accessToken, idToken, languageCode, refreshToken, sessionId, entityId).body(body)
				.log().all().when().post(endpoint).then().log().all().statusCode(200).extract().response();
	}
	
	public static Response post1(String endpoint, String accessToken, String idToken, String languageCode,
			String refreshToken, String sessionId, String entityId, Object body) {
		return createBaseRequest(accessToken, idToken, languageCode, refreshToken, sessionId, entityId).body(body).log().all()				.when().post(endpoint).then().log().all().statusCode(201).extract().response();
	}

	public static Response put(String endpoint, String accessToken, String idToken, String languageCode,
			String refreshToken, String sessionId, String entityId, Object body) {
		return createBaseRequest(accessToken, idToken, languageCode, refreshToken, sessionId, entityId).body(body).log().all()
				.when().put(endpoint).then().log().all().statusCode(200).extract().response();
	}

	public static Response patch(String endpoint, String accessToken, String idToken, String languageCode,
			String refreshToken, String sessionId, String entityId, Object body) {
		return createBaseRequest(accessToken, idToken, languageCode, refreshToken, sessionId, entityId).body(body).log().all()
				.when().patch(endpoint).then().log().all().statusCode(200).extract().response();
	}

	public static Response delete(String endpoint, String accessToken, String idToken, String languageCode,
			String refreshToken, String entityId, String sessionId) {
		return createBaseRequest(accessToken, idToken, languageCode, refreshToken, sessionId, entityId).when()
				.delete(endpoint).then().statusCode(204).extract().response();
	}

	public static String extractJsonValue(Response response, String jsonPath) {
		return response.jsonPath().getString(jsonPath);
	}
}