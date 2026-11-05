package Event_Creation;

import static API_Base_Classes.user_LogIn.accessToken;
import static API_Base_Classes.user_LogIn.idToken;
import static API_Base_Classes.user_LogIn.languageCode;
import static API_Base_Classes.user_LogIn.refreshToken;
import static API_Base_Classes.user_LogIn.sessionId;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ReserveSale_and_SBMA_POJO.AdditionalSettings1;
import ReserveSale_and_SBMA_POJO.BasicInfo;
import ReserveSale_and_SBMA_POJO.BiddersConference;
import ReserveSale_and_SBMA_POJO.CurrencyAccepted;
import ReserveSale_and_SBMA_POJO.DateTime;
import ReserveSale_and_SBMA_POJO.Detail;
import ReserveSale_and_SBMA_POJO.EventName;
import ReserveSale_and_SBMA_POJO.Jurisdiction;
import ReserveSale_and_SBMA_POJO.TiersData;
import ReserveSale_and_SBMA_POJO.auctionCreateReserveSale1;
import TestData.UsersAndMFASecreteKey;
import api_Common_Utilities.API_Common_Endpoints;
import api_Common_Utilities.ConfigFileManager;
import api_Common_Utilities.RestClient;
import io.restassured.response.Response;

public class R319 {

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
	public static String randomEventName;    //= "API_APCR_Z2XC";
	public static String allowanceSaleEventId;

	public static void createAPCREvent() {

		randomEventName = UsersAndMFASecreteKey.Release+ "R319_WA_APCR_EVENT_" + generateRandomString(4);
		System.out.println("randomEventName: " + randomEventName);
		
//		eventId = "API_" + generateRandomString(4);
//		randomEventName = "API_R319_" + generateRandomString(4);
//
//		System.out.println("eventId: " + eventId);
//		System.out.println("randomEventName: " + randomEventName);

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

		auctionCreateReserveSale1 request = new auctionCreateReserveSale1();

		BasicInfo basicInfo = new BasicInfo();
		basicInfo.setEventId("R319");
		basicInfo.setEventTypeId(System.getProperty("ALLOWANCE_SALE_TYPE_ID"));
		basicInfo.setEventTypeName("Allowance Sale");
		basicInfo.setParticipatingJurisdictions(List.of(System.getProperty("JURISDICTION_ID_WASHINGTON")));
		basicInfo.setParticipatingJurisdictionsNames(List.of("Washington"));

		EventName eventName = new EventName();
		eventName.setLanguageId(System.getProperty("ALLOWANCE_TIER_ID_TIER_ONE"));
		eventName.setLanguageName("English");
		eventName.setEventName(randomEventName);
		
		EventName eventNameFr = new EventName();
		eventNameFr.setLanguageId(System.getProperty("ALLOWANCE_TIER_ID_TIER_TWO"));
		eventNameFr.setLanguageName("French");
		eventNameFr.setEventName(randomEventName);

		basicInfo.setEventName(List.of(eventName, eventNameFr));
		request.setBasicInfo(basicInfo);

		Detail detail = new Detail();

		Jurisdiction jurisdiction = new Jurisdiction();
		jurisdiction.setId(System.getProperty("JURISDICTION_ID_WASHINGTON"));
		jurisdiction.setName("Washington");

		CurrencyAccepted currency = new CurrencyAccepted();
		currency.setCurrencyId(System.getProperty("ALLOWANCE_TIER_ID_TIER_ONE"));
		currency.setCurrencyType("USD");
		currency.setCurrencyValue("");

		TiersData tier = new TiersData();
		tier.setTiers(System.getProperty("ALLOWANCE_TIER_ID_TIER_ONE"));
		tier.setTiersPrices(ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA1"));
		tier.setTotalAllowancesAvailablePerTier(ConfigFileManager.getProperty("TotalAllowances_Tier_one_REWA1"));
		tier.setProcessingOrder(1);
		tier.setLimitTotalMaximumBidAllowances(false);
		tier.setMaximumBidAllowances(1000);
		
		TiersData tier2 = new TiersData();
		tier2.setTiers(System.getProperty("ALLOWANCE_TIER_ID_TIER_TWO"));
		tier2.setTiersPrices(ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA1"));
		tier2.setTotalAllowancesAvailablePerTier(ConfigFileManager.getProperty("TotalAllowances_Tier_two_REWA1"));
		tier2.setProcessingOrder(2);
		tier2.setLimitTotalMaximumBidAllowances(false);
		tier2.setMaximumBidAllowances(1000);
		
		TiersData tier3 = new TiersData();
		tier3.setTiers(System.getProperty("ALLOWANCE_TIER_ID_TIER_THREE"));
		tier3.setTiersPrices(ConfigFileManager.getProperty("PriceOffered_Tier_three_REWA1"));
		tier3.setTotalAllowancesAvailablePerTier(ConfigFileManager.getProperty("TotalAllowances_Tier_three_REWA1"));
		tier3.setProcessingOrder(3);
		tier3.setLimitTotalMaximumBidAllowances(false);
		tier3.setMaximumBidAllowances(1000);

		detail.setJurisdictions(List.of(jurisdiction));
		detail.setCurrencyAccepted(List.of(currency));
		detail.setTiersData(List.of(tier, tier2, tier3));
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

		AdditionalSettings1 additionalSettings = new AdditionalSettings1();
		additionalSettings.setAllowancesPerBidLot(1);
		additionalSettings.setLimitMaximumBidsAllowed(""); // Integer
		additionalSettings.setLimitMaximumBidsAllowedEnabled(false); // Boolean
		additionalSettings.setSetMaximumBidPrice(true);
		additionalSettings.setRollDownProcedure(false);
		additionalSettings.setPriceCeiling(false);

		request.setAdditionalSettings1(additionalSettings);

		Response res = RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), request);

		allowanceSaleEventId = RestClient.extractJsonValue(res, "data.eventDBId");

		System.out.println("eventDbId: " + allowanceSaleEventId);
	}
	
	public static String eventBiddingPeriodCloseedit;
	public static String resultsAvailableedit;
	public static String eventClosureedit;
	public static String financialSettlementedit;
	
	public static void editEventbySponsor() {
		
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
        basicInfo.put("participatingJurisdictionsNames", Arrays.asList("Washington"));
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
	
	public static void addBid(String entityId, String bidPrice, String bidLot, String tierId, String eventId) {
		String url = BaseUrl+"auction/api/add-bid";
		
		Map<String, Object> api = new HashMap<>();
		api.put("entityId", entityId);
		api.put("bidPrice", bidPrice);
		api.put("bidLot",bidLot);
		api.put("vintageId", null);
		api.put("tierId", tierId);
		api.put("eventId", eventId);
		
		RestClient.post1(url, accessToken, idToken, "en", refreshToken, sessionId,
				System.getProperty("entityId"), api);
	}
}