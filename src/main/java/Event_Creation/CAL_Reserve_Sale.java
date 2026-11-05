package Event_Creation;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

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

import ReserveSale_and_SBMA_POJO.AdditionalSettings;
import ReserveSale_and_SBMA_POJO.BasicInfo;
import ReserveSale_and_SBMA_POJO.BiddersConference;
import ReserveSale_and_SBMA_POJO.CurrencyAccepted;
import ReserveSale_and_SBMA_POJO.DateTime;
import ReserveSale_and_SBMA_POJO.Detail;
import ReserveSale_and_SBMA_POJO.EventName;
import ReserveSale_and_SBMA_POJO.Jurisdiction;
import ReserveSale_and_SBMA_POJO.TiersData;
import ReserveSale_and_SBMA_POJO.auctionCreateReserveSale;
import api_Common_Utilities.RestClient;
import api_Common_Utilities.API_Common_Endpoints;

public class CAL_Reserve_Sale {

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
	public static String randomEventName;    // = "API_R172_Reserve_8I26";
	public static String allowanceSaleEventId;

	public static void createReserveEvent() {

		eventId = "API_" + generateRandomString(4);
		randomEventName = "API_Reserve_" + generateRandomString(4);

		System.out.println("eventId: " + eventId);
		System.out.println("randomEventName: " + randomEventName);

		Date currentDate = new Date();

		Date estCurrentDate = convertISTtoET(currentDate);

		Date eventBiddingPeriodOpenDate = adjustDateTime(estCurrentDate, 2);
		Date eventBiddingPeriodCloseDate = adjustDateTime(estCurrentDate, 60);
		Date eventApplicationOpenDate = adjustDateTime(estCurrentDate, -60);
		Date eventApplicationCloseDate = adjustDateTime(estCurrentDate, -30);
		Date biddingGuaranteeSubmissionDeadlineDate = adjustDateTime(estCurrentDate, 1);

		Date resultsAvailableDate = adjustDateTime(eventBiddingPeriodCloseDate, 5 * 24 * 60);
		Date eventClosureDate = adjustDateTime(resultsAvailableDate, 7 * 24 * 60);
		Date financialSettlementDate = adjustDateTime(resultsAvailableDate, 1 * 24 * 60);

		eventBiddingPeriodOpen = formatDateWithoutTimeZone(eventBiddingPeriodOpenDate);
		eventBiddingPeriodClose = formatDateWithoutTimeZone(eventBiddingPeriodCloseDate);
		eventApplicationOpen = formatDateWithoutTimeZone(eventApplicationOpenDate);
		eventApplicationClose = formatDateWithoutTimeZone(eventApplicationCloseDate);
		biddingGuaranteeSubmissionDeadline = formatDateWithoutTimeZone(biddingGuaranteeSubmissionDeadlineDate);
		resultsAvailable = formatDateWithoutTimeZone(resultsAvailableDate);
		eventClosure = formatDateWithoutTimeZone(eventClosureDate);
		financialSettlement = formatDateWithoutTimeZone(financialSettlementDate);

		String url = BaseUrl + "auction/api/event";

		auctionCreateReserveSale request = new auctionCreateReserveSale();

		BasicInfo basicInfo = new BasicInfo();
		basicInfo.setEventId(eventId);
		basicInfo.setEventTypeId(System.getProperty("ALLOWANCE_SALE_TYPE_ID"));
		basicInfo.setEventTypeName("Allowance Sale");
		basicInfo.setParticipatingJurisdictions(List.of(System.getProperty("JURISDICTION_ID_CALIFORNIA")));
		basicInfo.setParticipatingJurisdictionsNames(List.of("California"));

		EventName eventName = new EventName();
		eventName.setLanguageId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		eventName.setLanguageName("English");
		eventName.setEventName(randomEventName);

		basicInfo.setEventName(List.of(eventName));
		request.setBasicInfo(basicInfo);

		Detail detail = new Detail();

		Jurisdiction jurisdiction = new Jurisdiction();
		jurisdiction.setId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		jurisdiction.setName("California");

		CurrencyAccepted currency = new CurrencyAccepted();
		currency.setCurrencyId(System.getProperty("ALLOWANCE_TIER_ID_TIER_ONE"));
		currency.setCurrencyType("USD");
		currency.setCurrencyValue("");

		TiersData tier = new TiersData();
		tier.setTiers(System.getProperty("ALLOWANCE_TIER_ID_TIER_ONE"));
		tier.setTiersPrices("15");
		tier.setTotalAllowancesAvailablePerTier("100000");
		tier.setProcessingOrder(1);
		tier.setLimitTotalMaximumBidAllowances(false);
		tier.setMaximumBidAllowances(1000);

		detail.setJurisdictions(List.of(jurisdiction));
		detail.setCurrencyAccepted(List.of(currency));
		detail.setTiersData(List.of(tier));
		detail.setPriceLabelChangeEnabled(false);

		request.setDetail(detail);

		DateTime dateTime = new DateTime();
		dateTime.setEventBiddingPeriodOpen(eventBiddingPeriodOpen + "-04:00");
		dateTime.setEventBiddingPeriodClose(eventBiddingPeriodClose + "-04:00");
		dateTime.setEventApplicationOpen(eventApplicationOpen + "-04:00");
		dateTime.setEventApplicationClose(eventApplicationClose + "-04:00");
		dateTime.setBiddingGuaranteeSubmissionDeadline(biddingGuaranteeSubmissionDeadline + "-04:00");
		dateTime.setResultsAvailable(resultsAvailable + "-04:00");
		dateTime.setEventClosure(eventClosure + "-04:00");
		dateTime.setFinancialSettlement(financialSettlement + "-04:00");

		BiddersConference biddersConference = new BiddersConference();
		biddersConference.setBiddersConferenceDateTime("");

		dateTime.setBiddersConference(List.of(biddersConference));
		request.setDateTime(dateTime);

		AdditionalSettings additionalSettings = new AdditionalSettings();
		additionalSettings.setAllowancesPerBidLot(1000);
		additionalSettings.setLimitMaximumBidsAllowed(1000);
		additionalSettings.setSetMaximumBidPrice(false);
		additionalSettings.setRollDownProcedure(false);
		additionalSettings.setPriceCeiling(false);

		request.setAdditionalSettings(additionalSettings);

		Response res = RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), request);

		allowanceSaleEventId = RestClient.extractJsonValue(res, "data.eventDBId");

		System.out.println("eventDbId: " + allowanceSaleEventId);
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
	
	public static void getTierId() {
		
		String url = BaseUrl+"auction/api/get-all-event-details";
		
		Response res = given().queryParam("entityId", System.getProperty("CA4519_Entity_ID"))
				.queryParam("eventId", arEventId)
				.header("content-type", "application/json").header("access-token", accessToken)
				.header("authorization", idToken).header("language-code", languageCode)
				.header("refresh-token", refreshToken).header("session-id", sessionId)
				.header("Entity-Id", System.getProperty("entityId")).when().get(url).then().assertThat().statusCode(200)
				.extract().response();
		
		JsonPath jsonPath = res.jsonPath();
		List<Map<String, Object>> tiers = jsonPath.getList("data.saleEventTiers");

		for (Map<String, Object> tier : tiers) {
		    String tierName = (String) tier.get("tierName");
		    String tierID = tier.get("saleAllowanceTierID").toString();

		    if ("Tier One".equals(tierName)) {
		        System.setProperty("CA_allowanceTierOneID", tierID);
		        System.out.println("CA_allowanceTierOneID: " +tierID);
		    } else if ("Tier Two".equals(tierName)) {
		        System.setProperty("CA_allowanceTierTwoID", tierID);
		        System.out.println("CA_allowanceTierTwoID:" +tierID);
		    } else if ("Tier Three".equals(tierName)) {
		        System.setProperty("CA_allowanceTierThreeID", tierID);
		        System.out.println("CA_allowanceTierThreeID: "+tierID);
		    }
		}
	}
	
	public static void addFirstBid() {
		String url = BaseUrl+"auction/api/add-bid";
		
		Map<String, Object> api = new HashMap<>();
		api.put("entityId", System.getProperty("CA4519_Entity_ID"));
		api.put("bidPrice", "10");
		api.put("bidLot", "10");
		api.put("vintageId", null);
		api.put("tierId", System.getProperty("CA_allowanceTierOneID"));
		api.put("eventId", arEventId);
		
		RestClient.post1(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), api);
	}
	
	public static String eventBiddingPeriodCloseedit;
	public static String resultsAvailableedit;
	public static String eventClosureedit;
	public static String financialSettlementedit;
	
	public static void editEventbySponsor() {
		API_Common_Endpoints.getEventId(CAL_Reserve_Sale.randomEventName);
		
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
        basicInfo.put("eventTypeName", "Allowance Sale");
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