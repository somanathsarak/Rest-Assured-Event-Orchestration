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

import TestData.UsersAndMFASecreteKey;
import api_Common_Utilities.API_Common_Endpoints;
import api_Common_Utilities.ConfigFileManager;
import api_Common_Utilities.RestClient;
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
import io.restassured.response.Response;

public class A278 {

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
	public static String bidderConferencedate;
	public static String resultsAvailable;
	public static String eventClosure;
	public static String financialSettlement;
	public static String eventId;
	public static String randomEventName;      //= "API_A278_YG4N";
	public static String jointAuctionEventId;

	public static void createSingleAuctionEvent() {

		randomEventName = UsersAndMFASecreteKey.Release+ "A278_WA_SINGLE_AUCTION_" + generateRandomString(4);
		System.out.println("randomEventName: " + randomEventName);
		
//		eventId = "API_" + generateRandomString(4);
//		randomEventName = "API_A278_" + generateRandomString(4);
//
//		System.out.println("eventId: " + eventId);
//		System.out.println("randomEventName: " + randomEventName);

		Date currentDate = new Date();

		Date estCurrentDate = convertISTtoET(currentDate);

		Date eventBiddingPeriodOpenDate = adjustDateTime(estCurrentDate, 2);
		Date eventBiddingPeriodCloseDate = adjustDateTime(estCurrentDate, 50);
		Date eventApplicationOpenDate = adjustDateTime(estCurrentDate, -60);
		Date eventApplicationCloseDate = adjustDateTime(estCurrentDate, -30);
		Date biddingGuaranteeSubmissionDeadlineDate = adjustDateTime(estCurrentDate, 1);
		
		Date bidderConferenceDateTime = adjustDateTime(estCurrentDate, 10);

		Date resultsAvailableDate = adjustDateTime(eventBiddingPeriodCloseDate, 7 * 24 * 60);
		Date eventClosureDate = adjustDateTime(resultsAvailableDate, 7 * 24 * 60);
		Date financialSettlementDate = adjustDateTime(resultsAvailableDate, 6 * 24 * 60);

		eventBiddingPeriodOpen = formatDateWithoutTimeZone(eventBiddingPeriodOpenDate);
		eventBiddingPeriodClose = formatDateWithoutTimeZone(eventBiddingPeriodCloseDate);
		eventApplicationOpen = formatDateWithoutTimeZone(eventApplicationOpenDate);
		eventApplicationClose = formatDateWithoutTimeZone(eventApplicationCloseDate);
		biddingGuaranteeSubmissionDeadline = formatDateWithoutTimeZone(biddingGuaranteeSubmissionDeadlineDate);
		bidderConferencedate = formatDateWithoutTimeZone(bidderConferenceDateTime);
		resultsAvailable = formatDateWithoutTimeZone(resultsAvailableDate);
		eventClosure = formatDateWithoutTimeZone(eventClosureDate);
		financialSettlement = formatDateWithoutTimeZone(financialSettlementDate);

		createSingleAuctionEvent request = new createSingleAuctionEvent();

		BasicInfo basicInfo = new BasicInfo();
		basicInfo.setEventId("A278");
		basicInfo.setEventTypeId(System.getProperty("AUCTION_SALE_TYPE_ID"));
		basicInfo.setEventTypeName("Auction");
		basicInfo.setParticipatingJurisdictions(List.of(System.getProperty("JURISDICTION_ID_WASHINGTON")));
		basicInfo.setParticipatingJurisdictionsNames(List.of("Washington"));

		EventName eventNameEN = new EventName();
		eventNameEN.setLanguageId(System.getProperty("AUCTION_SALE_TYPE_ID"));
		eventNameEN.setLanguageName("English");
		eventNameEN.setEventName(randomEventName);

		basicInfo.setEventName(List.of(eventNameEN));
		request.setBasicInfo(basicInfo);

		Detail detail = new Detail();

		Jurisdiction jurisdictionWA = new Jurisdiction();
		jurisdictionWA.setId(System.getProperty("JURISDICTION_ID_WASHINGTON"));
		jurisdictionWA.setName("Washington");

		CurrencyAccepted currencyUSD = new CurrencyAccepted();
		currencyUSD.setCurrencyId(System.getProperty("AUCTION_SALE_TYPE_ID"));
		currencyUSD.setCurrencyType("USD");
		currencyUSD.setCurrencyValue(ConfigFileManager.getProperty("AnnualAuctionFloorPriceA278"));

		VintagesData vintage2023 = new VintagesData();
		vintage2023.setVintages(System.getProperty("VINTAGE_YEAR_ID_2023"));
		vintage2023.setVintagesAllowancesAvailable(ConfigFileManager.getProperty("TotalAllowances_Current_PEWa2"));
		vintage2023.setVintageType(System.getProperty("CURRENT_VINTAGE_TYPE_ID"));
		vintage2023.setProcessingOrder("1");

		VintagesData vintage2025 = new VintagesData();
		vintage2025.setVintages(System.getProperty("VINTAGE_YEAR_ID_2025"));
		vintage2025.setVintagesAllowancesAvailable(ConfigFileManager.getProperty("TotalAllowances_Advance_PEWa2"));
		vintage2025.setVintageType(System.getProperty("ADVANCE_VINTAGE_TYPE_ID"));
		vintage2025.setProcessingOrder("2");

		detail.setJurisdictions(List.of(jurisdictionWA));
		detail.setCurrencyAccepted(List.of(currencyUSD));
		detail.setVintagesData(List.of(vintage2023, vintage2025));
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
		biddersConference.setJurisdictionId(System.getProperty("JURISDICTION_ID_WASHINGTON"));
		biddersConference.setBiddersConferenceDateTime(bidderConferencedate+"-04:00");

		dateTime.setBiddersConference(List.of(biddersConference));
		request.setDateTime(dateTime);

		AdditionalSettings settings = new AdditionalSettings();
		settings.setAllowancesPerBidLot(1000);
		settings.setLimitMaximumBidsAllowed(1000);
		settings.setSetMaximumBidPrice(false);
		settings.setAlgorithm(System.getProperty("ALGORITHM_ID"));

		request.setAdditionalSettings(settings);

		String url = BaseUrl + "auction/api/event";
		Response res = RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), request);

		jointAuctionEventId = RestClient.extractJsonValue(res, "data.eventDBId");

		System.out.println("eventDbId: " + jointAuctionEventId);
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
		basicInfo.put("participatingJurisdictionsNames", Arrays.asList("Washington"));
		eventData.put("basicInfo", basicInfo);

		eventData.put("detail", new HashMap<>());

		Map<String, String> dateTime = new HashMap<>();
		dateTime.put("eventBiddingPeriodClose", eventBiddingPeriodCloseedit + "-04:00");
		dateTime.put("resultsAvailable", resultsAvailableedit + "-04:00");
		dateTime.put("eventClosure", eventClosureedit + "-04:00");
		dateTime.put("financialSettlement", financialSettlementedit + "-04:00");
		eventData.put("dateTime", dateTime);

		eventData.put("additionalSettings", new HashMap<>());

		System.out.println(eventData);

		String url = BaseUrl + "auction/api/event";
		Response res = RestClient.patch(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), eventData);
		res.prettyPrint();
	}
	
	public static void addBid(String entityId, String bidPrice, String bidLot, String vintageId, String eventId) {
		String url = BaseUrl+"auction/api/add-bid";
		
		Map<String, Object> api = new HashMap<>();
		api.put("entityId", entityId);
		api.put("bidPrice", bidPrice);
		api.put("bidLot",bidLot);
		api.put("vintageId", vintageId);
		api.put("tierId", null);
		api.put("eventId", eventId);
		
		RestClient.post1(url, accessToken, idToken, "en", refreshToken, sessionId,
				System.getProperty("entityId"), api);
	}
}