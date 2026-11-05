package api_Common_Utilities;

import static API_Base_Classes.user_LogIn.accessToken;
import static API_Base_Classes.user_LogIn.idToken;
import static API_Base_Classes.user_LogIn.languageCode;
import static API_Base_Classes.user_LogIn.refreshToken;
import static API_Base_Classes.user_LogIn.sessionId;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class API_Common_Endpoints {

	public static String BaseUrl = "https://api.qa-wci-auction.org/qa-";
	public static String eventID;

	public static void getUserByToken() {
		String url = BaseUrl + "user/api/get-user-by-token";
		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId, "");

		String entityId = RestClient.extractJsonValue(res, "data.EntityRole[0].entityid");
		String languageID = RestClient.extractJsonValue(res, "data.Language_ID");

		System.setProperty("entityId", entityId);
		System.out.println("entityId: " + entityId);
		System.setProperty("languageID", languageID);
	}

	public static void fetchEventTypeData() {

		String url = BaseUrl + "auction/api/fetch-event-type-data";
		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));

		String auctionSaleTypeId = RestClient.extractJsonValue(res,
				"data.find { it.Sale_Type_Name == 'Auction' }.Sale_Type_ID");
		String allowanceSaleTypeId = RestClient.extractJsonValue(res,
				"data.find { it.Sale_Type_Name == 'Allowance Sale' }.Sale_Type_ID");

		System.out.println("auction sale type Id: " + auctionSaleTypeId);
		System.out.println("Allowance sale type Id: " + allowanceSaleTypeId);

		System.setProperty("AUCTION_SALE_TYPE_ID", auctionSaleTypeId);
		System.setProperty("ALLOWANCE_SALE_TYPE_ID", allowanceSaleTypeId);
	}

	public static void fetchTiresData() {

		String url = BaseUrl + "auction/api/fetch-tiers-data";

		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));

		String tierOneId = RestClient.extractJsonValue(res,
				"data.find { it.Tier_Name == 'Tier One' }.Allowance_Tier_ID");
		String tierTwoId = RestClient.extractJsonValue(res,
				"data.find { it.Tier_Name == 'Tier Two' }.Allowance_Tier_ID");
		String tierThreeId = RestClient.extractJsonValue(res,
				"data.find { it.Tier_Name == 'Tier Three' }.Allowance_Tier_ID");

		System.out.println("Tire One Id: " + tierOneId);
		System.out.println("Tire Two Id: " + tierTwoId);
		System.out.println("Tire Three Id: " + tierThreeId);

		System.setProperty("ALLOWANCE_TIER_ID_TIER_ONE", tierOneId);
		System.setProperty("ALLOWANCE_TIER_ID_TIER_TWO", tierTwoId);
		System.setProperty("ALLOWANCE_TIER_ID_TIER_THREE", tierThreeId);
	}

	public static void getVintageYear() {
		String url = BaseUrl + "auction/api/fetch-vintage-year";

		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));

		String vintage2023 = RestClient.extractJsonValue(res, "data.find { it.Year == '2023' }.Vintage_Year_ID");
		String vintage2025 = RestClient.extractJsonValue(res, "data.find { it.Year == '2025' }.Vintage_Year_ID");

		System.out.println("VINTAGE_YEAR_ID_2023: " + vintage2023);
		System.out.println("VINTAGE_YEAR_ID_2025: " + vintage2025);

		System.setProperty("VINTAGE_YEAR_ID_2023", vintage2023);
		System.setProperty("VINTAGE_YEAR_ID_2025", vintage2025);
	}

	public static void getVintageData() {
		String url = BaseUrl + "auction/api/fetch-vintage-data";

		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));

		String Current = RestClient.extractJsonValue(res, "data.find { it.Vintage_Name == 'Current' }.Vintage_Type_ID");
		String Advance = RestClient.extractJsonValue(res, "data.find { it.Vintage_Name == 'Advance' }.Vintage_Type_ID");

		System.out.println("CURRENT_VINTAGE_TYPE_ID: " + Current);
		System.out.println("ADVANCE_VINTAGE_TYPE_ID: " + Advance);

		System.setProperty("CURRENT_VINTAGE_TYPE_ID", Current);
		System.setProperty("ADVANCE_VINTAGE_TYPE_ID", Advance);
	}

	public static void getAlgorithmData() {
		String url = BaseUrl + "auction/api/" + System.getProperty("entityId") + "/fetch-algorithms-data";

		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));

		String algorithmId = res.jsonPath().getString("data[0].Algorithm_ID");

		System.out.println("ALGORITHM_ID: " + algorithmId);
		System.setProperty("ALGORITHM_ID", algorithmId);
	}
	
	public static void getLinkedJurisdiction() {

		String url = BaseUrl + "user/api/get-linked-jurisdictions";

		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));

		String californiaJurisdictionId = RestClient.extractJsonValue(res,
				"data.find { it.jurisdictionName == 'California' }.jurisdictionId");
		String quebecJurisdictionId = RestClient.extractJsonValue(res,
				"data.find { it.jurisdictionName == 'Quebec' }.jurisdictionId");

		System.out.println("JURISDICTION_ID_CALIFORNIA: " + californiaJurisdictionId);
		System.out.println("JURISDICTION_ID_QUEBEC: " + quebecJurisdictionId);

		System.setProperty("JURISDICTION_ID_CALIFORNIA", californiaJurisdictionId);
		System.setProperty("JURISDICTION_ID_QUEBEC", quebecJurisdictionId);
	}
	
	public static void getJurisdiction() {

		String url = BaseUrl + "user/api/get-linked-jurisdictions";

		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));

		String washingtonJurisdictionId = RestClient.extractJsonValue(res,
				"data.find { it.jurisdictionName == 'Washington' }.jurisdictionId");

		System.out.println("JURISDICTION_ID_WASHINGTON: " + washingtonJurisdictionId);

		System.setProperty("JURISDICTION_ID_WASHINGTON", washingtonJurisdictionId);
	}

	public static String getEventId(String name) {
//		getUserByToken();
		RestAssured.baseURI = BaseUrl + "auction/api/event/all-events";

		Response res = given().queryParam("page", "1").queryParam("pageSize", "100").queryParam("sortBy", "")
				.queryParam("sortOrder", "").queryParam("jurisdictionIds", System.getProperty("entityId"))
				.header("content-type", "application/json").header("access-token", accessToken)
				.header("authorization", idToken).header("language-code", languageCode)
				.header("refresh-token", refreshToken).header("session-id", sessionId)
				.header("Entity-Id", System.getProperty("entityId")).when().get().then().assertThat().statusCode(200)
				.extract().response();

		List<Map<String, Object>> events = res.jsonPath().getList("data.eventResp");

		String EventName = name;

		for (Map<String, Object> event : events) {
			if (EventName.equals(event.get("eventName"))) {
				eventID = (String) event.get("saleEventId");
				System.out.println("allowanceSaleEventId2: " + eventID);
				break;
			}
		}
		return eventID;
	}

	public static void approveEventBySponsor() {
//		getUserByToken();
		String url = BaseUrl + "auction/api/set-event-status";

		Map<String, Object> event = new HashMap<>();
		event.put("eventStatusId", "");
		event.put("eventId", eventID);
		event.put("status", "Approve");

		RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), event);
	}

	public static void getAPIList() {
//		getUserByToken();
		String url = BaseUrl + "user/api/get-registry-api-list";

		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));

		String GetQualifiedBidderId = RestClient.extractJsonValue(res,
				"data.find { it.apiName == 'GetQualifiedBidder' }.id");
		String GetBidLimitationsId = RestClient.extractJsonValue(res,
				"data.find { it.apiName == 'GetBidLimitations' }.id");

		System.out.println("GetQualifiedBidder: " + GetQualifiedBidderId);
		System.out.println("GetBidLimitations: " + GetBidLimitationsId);

		System.setProperty("GetQualifiedBidder", GetQualifiedBidderId);
		System.setProperty("GetBidLimitations", GetBidLimitationsId);
	}

	public static void executeGetQualifiedBidderAPI() {
//		getUserByToken();
		String url = BaseUrl + "user/api/execute-registry-api";

		Map<String, Object> api = new HashMap<>();
		api.put("id", System.getProperty("GetQualifiedBidder"));

		RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), api);
	}

	public static void executeGetBidLimitationsAPI() {
//		getUserByToken();
		String url = BaseUrl + "user/api/execute-registry-api";

		Map<String, Object> api = new HashMap<>();
		api.put("id", System.getProperty("GetBidLimitations"));

		RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), api);
	}

	public static void setCertificationBySponsor() {
//		getUserByToken();
		String url = BaseUrl + "auction/api/set-certification-status";

		Map<String, Object> certification = new HashMap<>();
		certification.put("eventStatusId", "");
		certification.put("eventId", eventID);
		certification.put("status", "Approve");

		RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), certification);
	}

	public static void runAlgorithmBySponsor() {
		String url = BaseUrl + "auction/api/set-algorithm-status";

		Map<String, Object> algorithm = new HashMap<>();
		algorithm.put("eventStatusId", "");
		algorithm.put("eventId", eventID);
		algorithm.put("status", "Approve");

		RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), algorithm);
	}

	public static void calculateAuctionAlgorithm() {
		String url = BaseUrl + "auction/api/calculateAuctionAlgorithm/" + eventID;

		RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));
	}

	public static void calculateReserveSaleAlgorithm() {
		String url = BaseUrl + "auction/api/calculateReserveSaleAlgorithm/" + eventID;

		RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));
	}

	public static void checkAlgorithmExecutionStatus() {
		String url = BaseUrl + "auction/api/checkAlgorithmExecutionStatus/" + eventID;

		RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));
	}

	public static void getARByToken() {
		String url = BaseUrl + "user/api/get-user-by-token";

		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId, "");

		String entityId = RestClient.extractJsonValue(res, "data.EntityRole[0].entityid");
		String arUserId = RestClient.extractJsonValue(res, "data.User_ID");

		System.setProperty("entityIdAR", entityId);
		System.setProperty("arUserId", arUserId);
	}

	public static void jurisdictionListFilter() {
		String url = BaseUrl + "user/api/jurisdiction-list-filter";

		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));

		String caEntityId = RestClient.extractJsonValue(res,
				"data.find { it.Entity_Legal_Name == 'California' }.Entity_ID");
		String qcEntityId = RestClient.extractJsonValue(res,
				"data.find { it.Entity_Legal_Name == 'Quebec' }.Entity_ID");
		String WAEntityId = RestClient.extractJsonValue(res,
				"data.find { it.Entity_Legal_Name == 'Washington' }.Entity_ID");

		System.out.println("caEntityId: " + caEntityId);
		System.out.println("qcEntityId: " + qcEntityId);
		System.out.println("JURISDICTION_ID_WASHINGTON: " + WAEntityId);
		System.out.println("WAEntityId: " + WAEntityId);

		System.setProperty("caEntityId", caEntityId);
		System.setProperty("qcEntityId", qcEntityId);
		System.setProperty("JURISDICTION_ID_WASHINGTON", WAEntityId);
		System.setProperty("WAEntityId", WAEntityId);
	}

	public static void getAllEntities(String accountNumber_endsWith) {
		API_Common_Endpoints.getARByToken();

		String url = BaseUrl + "user/api/user/" + System.getProperty("arUserId") + "/entities";

		Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"));
		JsonPath jsonPath = res.jsonPath();
		List<Map<String, Object>> dataList = jsonPath.getList("data");

		for (String key : ConfigFileManager.prop.stringPropertyNames()) {
			if (key.endsWith(accountNumber_endsWith)) {
				String expectedAccountNumber = ConfigFileManager.getProperty(key).trim();

				for (Map<String, Object> entry : dataList) {
					String entityAccount = (String) entry.get("Entity_General_Account_Number");
					String entityId = (String) entry.get("Entity_ID");

					if (expectedAccountNumber.equals(entityAccount)) {
						String sysPropKey = expectedAccountNumber.replace("-", "_") + "_Entity_ID";
						System.setProperty(sysPropKey, entityId);
						System.out.println("Mapped: " + sysPropKey + " = " + entityId);
						System.getProperty(sysPropKey, entityId);
						System.setProperty("entityId", entityId);
						System.out.println("entityID :" + entityId);
						break;
					}
				}
			}
		}
	}
	
	public static String arEventId;

	public static void getLiveEvents(String name) {
		String url = BaseUrl + "auction/api/getLiveEvents";

		Response res = given().queryParam("entityId", System.getProperty("entityId"))
				.header("content-type", "application/json").header("access-token", accessToken)
				.header("authorization", idToken).header("language-code", languageCode)
				.header("refresh-token", refreshToken).header("session-id", sessionId)
				.header("Entity-Id", System.getProperty("entityId")).when().get(url).then().log().all().assertThat()
				.statusCode(200).extract().response();

		List<Map<String, Object>> events = res.jsonPath().getList("data");
		String EventName = name;
		for (Map<String, Object> event : events) {
			if (EventName.equals(event.get("EventName"))) {
				arEventId = (String) event.get("Sale_Event_ID");
				System.out.println("AR_Event_ID: " + arEventId);
				break;
			}
		}
	}

	public static void getVintages() {
		String url = BaseUrl + "auction/api/get-all-event-details";

		Response res = given().queryParam("entityId", System.getProperty("entityId")).queryParam("eventId", arEventId)
				.header("content-type", "application/json").header("access-token", accessToken)
				.header("authorization", idToken).header("language-code", languageCode)
				.header("refresh-token", refreshToken).header("session-id", sessionId)
				.header("Entity-Id", System.getProperty("entityId")).when().get(url).then().assertThat().statusCode(200)
				.extract().response();

		List<Map<String, Object>> vintageList = res.jsonPath().getList("data.saleEventVintage");

		if (vintageList != null && !vintageList.isEmpty()) {
			String currentVintageTypeId = (String) vintageList.get(0).get("saleEventVintageID");
			System.setProperty("currentvintageType", currentVintageTypeId);
			System.out.println("Current Vintage Type ID: " + currentVintageTypeId);

			if (vintageList.size() >= 2) {
				String advanceVintageTypeId = (String) vintageList.get(1).get("saleEventVintageID");
				System.setProperty("advanceVintageType", advanceVintageTypeId);
				System.out.println("Advance Vintage Type ID: " + advanceVintageTypeId);
			}
		}
	}

	public static void getTierId() {

		String url = BaseUrl + "auction/api/get-all-event-details";

		Response res = given().queryParam("entityId", System.getProperty("entityId"))
				.queryParam("eventId", arEventId).header("content-type", "application/json")
				.header("access-token", accessToken).header("authorization", idToken)
				.header("language-code", languageCode).header("refresh-token", refreshToken)
				.header("session-id", sessionId).header("Entity-Id", System.getProperty("entityId")).when().get(url)
				.then().log().all().assertThat().statusCode(200).extract().response();

		JsonPath jsonPath = res.jsonPath();
		List<Map<String, Object>> tiers = jsonPath.getList("data.saleEventTiers");

		for (Map<String, Object> tier : tiers) {
			String tierName = (String) tier.get("tierName");
			String tierID = tier.get("saleAllowanceTierID").toString();

			if ("Tier One".equals(tierName)) {
				System.setProperty("CA_allowanceTierOneID", tierID);
				System.out.println("CA_allowanceTierOneID: " + tierID);
			} else if ("Tier Two".equals(tierName)) {
				System.setProperty("CA_allowanceTierTwoID", tierID);
				System.out.println("CA_allowanceTierTwoID:" + tierID);
			} else if ("Tier Three".equals(tierName)) {
				System.setProperty("CA_allowanceTierThreeID", tierID);
				System.out.println("CA_allowanceTierThreeID: " + tierID);
			}
		}
	}
	
	public static void uploadFIle(String emissionFileName) {
		String url = BaseUrl + "auction/api/upload-emission-units";

		File file = new File(System.getProperty("user.dir")+"\\Upload_Emission_Files\\"+emissionFileName+".xlsx");

		Response res = given().header("access-token", accessToken).header("authorization", idToken)
				.header("language-code", languageCode).header("refresh-token", refreshToken)
				.header("session-id", sessionId).header("entity-id", System.getProperty("entityId"))
				.multiPart("emissionUnitTemplate", file,
						"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
				.multiPart("eventId", API_Common_Endpoints.eventID).when().post(url).then()
				.assertThat().statusCode(200).extract().response();
		res.prettyPrint();	
		}
}