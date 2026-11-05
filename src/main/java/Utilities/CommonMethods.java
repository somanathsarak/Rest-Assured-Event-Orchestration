package Utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CommonMethods {

	public static RequestSpecification createBaseRequest(String pageName, String componentName, String token) {
		RequestSpecification request = given().contentType(ContentType.JSON).header("Authorization", "Bearer " + token);

		if (pageName != null && !pageName.isEmpty()) {
			request.header("Page-Name", pageName);
		}
		if (componentName != null && !componentName.isEmpty()) {
			request.header("Component-Name", componentName);
		}
		return request;
	}

	public static Response get(String endpoint, String pageName, String componentName, String token) {
		return createBaseRequest(pageName, componentName, token)
				.when().get(endpoint).then().statusCode(200).extract().response();
	}

	public static Response post(String endpoint, Object body, String pageName, String componentName, String token) {
		return createBaseRequest(pageName, componentName, token)
				.body(body).when().post(endpoint).then().statusCode(200).extract().response();
	}

	public static Response put(String endpoint, Object body, String pageName, String componentName, String token) {
		return createBaseRequest(pageName, componentName, token)
				.body(body).when().put(endpoint).then().statusCode(200).extract().response();
	}

	public static Response delete(String endpoint, String pageName, String componentName, String token) {
		return createBaseRequest(pageName, componentName, token)
				.when().delete(endpoint).then().statusCode(204).extract().response();
	}

	public static RequestSpecification withBasicAuth(String username, String password) {
		return given().auth().basic(username, password);
	}

	public static RequestSpecification withBearerAuth(String token) {
		return given().header("Authorization", "Bearer " + token);
	}

	public static String extractJsonValue(Response response, String jsonPath) {
		return response.jsonPath().getString(jsonPath);
	}

	public static RequestSpecification logRequestAndResponse() {
		return given().log().all();
	}

	public static void assertStatusCode(Response response, int expectedStatusCode) {
		response.then().statusCode(expectedStatusCode);
	}

	public static String extractHeader(Response response, String headerName) {
		return response.getHeader(headerName);
	}

	public static void validateJsonResponse(Response response, String jsonPath, Object expectedValue) {
		response.then().body(jsonPath, equalTo(expectedValue));
	}

	public static Response getWithParams(String endpoint, String paramKey, String paramValue) {
		return given().param(paramKey, paramValue).when().get(endpoint).then().statusCode(200).extract().response();
	}

	public static RequestSpecification withCustomLogging() {
		return given().filter((requestSpec, responseSpec, ctx) -> {
			System.out.println("Request: " + requestSpec);
			System.out.println("Response: " + responseSpec);
			return ctx.next(requestSpec, responseSpec);
		});
	}

	public static void validateResponseTime(Response response, long maxTimeInMillis) {
		response.then().time(lessThan(maxTimeInMillis));
	}

//    // Method to create a base request with query parameters, for cases like pagination
//    public static RequestSpecification createBaseRequestWithQueryParams(String pageName, String componentName, String token, int page, int size) {
//        return given()
//                .header("Page-Name", pageName)             
//                .header("Component-Name", componentName)    
//                .contentType(ContentType.JSON)               
//                .header("Authorization", "Bearer " + token)  
//                .queryParam("page", page)                    
//                .queryParam("size", size);                   
//    }
//
//    // Overload for requests with additional headers like custom user-agent or other fields
//    public static RequestSpecification createBaseRequestWithCustomHeaders(String pageName, String componentName, String token, String customHeaderName, String customHeaderValue) {
//        return given()
//                .header("Page-Name", pageName)              
//                .header("Component-Name", componentName)    
//                .contentType(ContentType.JSON)             
//                .header("Authorization", "Bearer " + token) 
//                .header(customHeaderName, customHeaderValue);
//    }
}