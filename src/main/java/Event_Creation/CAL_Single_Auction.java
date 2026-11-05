package Event_Creation;


import static API_Base_Classes.user_LogIn.accessToken;
import static API_Base_Classes.user_LogIn.idToken;
import static API_Base_Classes.user_LogIn.languageCode;
import static API_Base_Classes.user_LogIn.refreshToken;
import static API_Base_Classes.user_LogIn.sessionId;
import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import api_Common_Utilities.RestClient;
import api_Common_Utilities.API_Common_Endpoints;
import cal_SingleAuction_POJO.AdditionalSettings;
import cal_SingleAuction_POJO.BasicInfo;
import cal_SingleAuction_POJO.BiddersConference;
import cal_SingleAuction_POJO.CurrencyAccepted;
import cal_SingleAuction_POJO.DateTime;
import cal_SingleAuction_POJO.Detail;
import cal_SingleAuction_POJO.EventName;
import cal_SingleAuction_POJO.Jurisdiction;
import cal_SingleAuction_POJO.VintagesData;
import cal_SingleAuction_POJO.createSingleAuctionEvent;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CAL_Single_Auction {

	public static String BaseUrl = "https://api.qa-wci-auction.org/qa-";

	public static String formatDateWithoutTimeZone(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("Provided value is not a valid Date object");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return sdf.format(date);
	}

	public static Date convertISTtoET(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, -9);
		calendar.add(Calendar.MINUTE, -30);
		return calendar.getTime();
	}

	public static Date adjustDateTime(Date date, int minutesOffset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutesOffset);
		return calendar.getTime();
	}

	public static String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder result = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			result.append(characters.charAt(random.nextInt(characters.length())));
		}

		return result.toString();
	}

	public static String eventBiddingPeriodOpen;
	public static String eventBiddingPeriodClose;
	public static String eventApplicationOpen;
	public static String eventApplicationClose;
	public static String biddingGuaranteeSubmissionDeadline;
	public static String resultsAvailable;
	public static String eventClosure;
	public static String financialSettlement;
	public static String eventId;
	public static String randomEventName;         //= "API_Auction_RETT";
	public static String jointAuctionEventId;
	
	public static void createSingleAuctionEvent() {
		
		eventId = "API_" + generateRandomString(4);
		randomEventName = "API_Auction_" + generateRandomString(4);
		
		System.out.println("eventId: " + eventId);
		System.out.println("randomEventName: " + randomEventName);

		Date currentDate = new Date();

		Date estCurrentDate = convertISTtoET(currentDate);

		Date eventBiddingPeriodOpenDate = adjustDateTime(estCurrentDate, 2);
		Date eventBiddingPeriodCloseDate = adjustDateTime(estCurrentDate, 50);
		Date eventApplicationOpenDate = adjustDateTime(estCurrentDate, -60);
		Date eventApplicationCloseDate = adjustDateTime(estCurrentDate, -30);
		Date biddingGuaranteeSubmissionDeadlineDate = adjustDateTime(estCurrentDate, 1);

		Date resultsAvailableDate = adjustDateTime(eventBiddingPeriodCloseDate, 7 * 24 * 60);
		Date eventClosureDate = adjustDateTime(resultsAvailableDate, 7 * 24 * 60);
		Date financialSettlementDate = adjustDateTime(resultsAvailableDate, 6 * 24 * 60);

		eventBiddingPeriodOpen = formatDateWithoutTimeZone(eventBiddingPeriodOpenDate);
		eventBiddingPeriodClose = formatDateWithoutTimeZone(eventBiddingPeriodCloseDate);
		eventApplicationOpen = formatDateWithoutTimeZone(eventApplicationOpenDate);
		eventApplicationClose = formatDateWithoutTimeZone(eventApplicationCloseDate);
		biddingGuaranteeSubmissionDeadline = formatDateWithoutTimeZone(biddingGuaranteeSubmissionDeadlineDate);
		resultsAvailable = formatDateWithoutTimeZone(resultsAvailableDate);
		eventClosure = formatDateWithoutTimeZone(eventClosureDate);
		financialSettlement = formatDateWithoutTimeZone(financialSettlementDate);
		
		
		createSingleAuctionEvent request = new createSingleAuctionEvent();

		BasicInfo basicInfo = new BasicInfo();
		basicInfo.setEventId(eventId);
		basicInfo.setEventTypeId(System.getProperty("AUCTION_SALE_TYPE_ID"));
		basicInfo.setEventTypeName("Auction");
		basicInfo.setParticipatingJurisdictions(List.of(
		    System.getProperty("JURISDICTION_ID_CALIFORNIA")
		));
		basicInfo.setParticipatingJurisdictionsNames(List.of("California"));

		EventName eventNameEN = new EventName();
		eventNameEN.setLanguageId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		eventNameEN.setLanguageName("English");
		eventNameEN.setEventName(randomEventName);

		EventName eventNameFR = new EventName();
		eventNameFR.setLanguageId(System.getProperty("JURISDICTION_ID_QUEBEC"));
		eventNameFR.setLanguageName("French");
		eventNameFR.setEventName(randomEventName);

		basicInfo.setEventName(List.of(eventNameEN, eventNameFR));
		request.setBasicInfo(basicInfo);

		Detail detail = new Detail();

		Jurisdiction jurisdictionCA = new Jurisdiction();
		jurisdictionCA.setId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		jurisdictionCA.setName("California");

		CurrencyAccepted currencyUSD = new CurrencyAccepted();
		currencyUSD.setCurrencyId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		currencyUSD.setCurrencyType("USD");
		currencyUSD.setCurrencyValue("10");

		VintagesData vintage2023 = new VintagesData();
		vintage2023.setVintages(System.getProperty("VINTAGE_YEAR_ID_2023"));
		vintage2023.setVintagesAllowancesAvailable("120");
		vintage2023.setVintageType(System.getProperty("CURRENT_VINTAGE_TYPE_ID"));
		vintage2023.setProcessingOrder("1");

		VintagesData vintage2025 = new VintagesData();
		vintage2025.setVintages(System.getProperty("VINTAGE_YEAR_ID_2025"));
		vintage2025.setVintagesAllowancesAvailable("100");
		vintage2025.setVintageType(System.getProperty("ADVANCE_VINTAGE_TYPE_ID"));
		vintage2025.setProcessingOrder("2");

		detail.setJurisdictions(List.of(jurisdictionCA));
		detail.setCurrencyAccepted(List.of(currencyUSD));
		detail.setVintagesData(List.of(vintage2023, vintage2025));
		detail.setPriceLabelChangeEnabled(false);

		request.setDetail(detail);

		DateTime dateTime = new DateTime();
		dateTime.setEventBiddingPeriodOpen(eventBiddingPeriodOpen+"-04:00");
		dateTime.setEventBiddingPeriodClose(eventBiddingPeriodClose+"-04:00");
		dateTime.setEventApplicationOpen(eventApplicationOpen+"-04:00");
		dateTime.setEventApplicationClose(eventApplicationClose+"-04:00");
		dateTime.setBiddingGuaranteeSubmissionDeadline(biddingGuaranteeSubmissionDeadline+"-04:00");
		dateTime.setResultsAvailable(resultsAvailable+ "-04:00");
		dateTime.setEventClosure(eventClosure+"-04:00");
		dateTime.setFinancialSettlement(financialSettlement+"-04:00");

		BiddersConference biddersConference = new BiddersConference();
		biddersConference.setJurisdictionId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		biddersConference.setBiddersConferenceDateTime("");

		dateTime.setBiddersConference(List.of(biddersConference));
		request.setDateTime(dateTime);

		AdditionalSettings settings = new AdditionalSettings();
		settings.setAllowancesPerBidLot(1000);
		settings.setLimitMaximumBidsAllowed(1000);
		settings.setSetMaximumBidPrice(false);
		settings.setAlgorithm(System.getProperty("ALGORITHM_ID"));

		request.setAdditionalSettings(settings);

		String url = BaseUrl+"auction/api/event";
		Response res = RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), request);

		jointAuctionEventId = RestClient.extractJsonValue(res, "data.eventDBId");

		System.out.println("eventDbId: " + jointAuctionEventId);
	}
	
	public static void getAllEntities() {
		API_Common_Endpoints.getARByToken();
			
			String url = BaseUrl+"user/api/user/"+System.getProperty("arUserId")+"/entities";
			
			Response res = RestClient.get(url, accessToken, idToken, languageCode, refreshToken, sessionId,
					System.getProperty("entityId"));
			
			
			JsonPath jsonPath = res.jsonPath();
			List<Map<String, Object>> dataList = jsonPath.getList("data");

			for (Map<String, Object> entry : dataList) {
			    String accountNumber = (String) entry.get("Entity_General_Account_Number");
			    String entityId = (String) entry.get("Entity_ID");

			    if ("CA3213-4519".equals(accountNumber)) {
			        System.out.println("CA4519_Entity_ID: " + entityId);
			        System.setProperty("CA4519_Entity_ID", entityId);
			    } else if ("CA3223-4531".equals(accountNumber)) {
			        System.out.println("CA4531_Entity_ID: " + entityId);
			        System.setProperty("CA4531_Entity_ID", entityId);
			    } else if ("CA3225-4535".equals(accountNumber)) {
			        System.out.println("CA4535_Entity_ID: " + entityId);
			        System.setProperty("CA4535_Entity_ID", entityId);
			    }
			}
		}
		
		public static String arEventId;
		public static void getLiveEvents(String name) {
			String url = BaseUrl+"auction/api/getLiveEvents";
			
			Response res = given().queryParam("entityId", System.getProperty("CA4519_Entity_ID"))
					.header("content-type", "application/json").header("access-token", accessToken)
					.header("authorization", idToken).header("language-code", languageCode)
					.header("refresh-token", refreshToken).header("session-id", sessionId)
					.header("Entity-Id", System.getProperty("entityId")).when().get(url).then().log().all().assertThat().statusCode(200)
					.extract().response();
			
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
			String url = BaseUrl+"auction/api/get-all-event-details";
			
			Response res = given().queryParam("entityId", System.getProperty("CA4519_Entity_ID"))
					.queryParam("eventId", arEventId)
					.header("content-type", "application/json").header("access-token", accessToken)
					.header("authorization", idToken).header("language-code", languageCode)
					.header("refresh-token", refreshToken).header("session-id", sessionId)
					.header("Entity-Id", System.getProperty("entityId")).when().get(url).then().assertThat().statusCode(200)
					.extract().response();
		
			List<Map<String, Object>> vintageList = res.jsonPath().getList("data.saleEventVintage");

	        if (vintageList != null && vintageList.size() >= 2) {
	            String currentVintageTypeId = (String) vintageList.get(0).get("saleEventVintageID");
	            String advanceVintageTypeId = (String) vintageList.get(1).get("saleEventVintageID");

	            System.out.println("Current Vintage Type ID: " + currentVintageTypeId);
	            System.out.println("Advance Vintage Type ID: " + advanceVintageTypeId);
	            
	            System.setProperty("currentvintageType", currentVintageTypeId);
	            System.setProperty("advanceVintageType", advanceVintageTypeId);
	        }
		}
		
		public static void addFirstBid() {
			String url = BaseUrl+"auction/api/add-bid";
			
			Map<String, Object> api = new HashMap<>();
			api.put("entityId", System.getProperty("CA4519_Entity_ID"));
			api.put("bidPrice", "10");
			api.put("bidLot", "10");
			api.put("vintageId", System.getProperty("currentvintageType"));
			api.put("tierId", null);
			api.put("eventId", arEventId);
			
			RestClient.post1(url, accessToken, idToken, languageCode, refreshToken, sessionId,
					System.getProperty("entityId"), api);
		}
		
		public static String eventBiddingPeriodCloseedit;
		public static String resultsAvailableedit;
		public static String eventClosureedit;
		public static String financialSettlementedit;
		
		public static void editEventbySponsor() {
//			api_Common_Endpoints.getEventId(CAL_Reserve_Sale.randomEventName);
			
			Date currentDate = new Date();
			Date estCurrentDate = convertISTtoET(currentDate);
			Date eventBiddingPeriodCloseDate = adjustDateTime(estCurrentDate, 1);
			eventBiddingPeriodCloseedit = formatDateWithoutTimeZone(eventBiddingPeriodCloseDate);
			
			Date resultsAvailableDate = adjustDateTime(eventBiddingPeriodCloseDate, 5 * 24 * 60);
			Date eventClosureDate = adjustDateTime(resultsAvailableDate, 7 * 24 * 60);
			Date financialSettlementDate = adjustDateTime(resultsAvailableDate, 1 * 24 * 60);
			
			resultsAvailableedit = formatDateWithoutTimeZone(resultsAvailableDate);
			eventClosureedit = formatDateWithoutTimeZone(eventClosureDate);
			financialSettlementedit = formatDateWithoutTimeZone(financialSettlementDate);
			
			
			System.out.println(eventBiddingPeriodCloseedit);
			System.out.println(resultsAvailableedit);
			System.out.println(eventClosureedit);
			System.out.println(financialSettlementedit);
			
			Map<String, Object> eventData = new HashMap<>();

	        Map<String, Object> basicInfo = new HashMap<>();
	        basicInfo.put("eventDBId", API_Common_Endpoints.eventID);
	        basicInfo.put("eventStatus", "Open Bidding Window");
	        basicInfo.put("eventTypeName", "Auction");
	        basicInfo.put("participatingJurisdictionsNames", Arrays.asList("California"));
	        eventData.put("basicInfo", basicInfo);

	        eventData.put("detail", new HashMap<>());

	        Map<String, String> dateTime = new HashMap<>();
	        dateTime.put("eventBiddingPeriodClose", eventBiddingPeriodCloseedit+"-04:00");
	        dateTime.put("resultsAvailable", resultsAvailableedit+"-04:00");
	        dateTime.put("eventClosure", eventClosureedit+"-04:00");
	        dateTime.put("financialSettlement", financialSettlementedit+"-04:00");
	        eventData.put("dateTime", dateTime);

	        eventData.put("additionalSettings", new HashMap<>());
	        
	        System.out.println(eventData);
	        
	        
	        String url = BaseUrl+"auction/api/event";
	        Response res = RestClient.patch(url, accessToken, idToken, languageCode, refreshToken, sessionId,
					System.getProperty("entityId"), eventData);
	        res.prettyPrint();	
		}
}