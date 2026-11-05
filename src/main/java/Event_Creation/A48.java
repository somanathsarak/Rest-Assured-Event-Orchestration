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
import cal_JointAuction_POJO.AdditionalSettings;
import cal_JointAuction_POJO.BasicInfo;
import cal_JointAuction_POJO.BiddersConference;
import cal_JointAuction_POJO.CurrencyAccepted;
import cal_JointAuction_POJO.DateTime;
import cal_JointAuction_POJO.Detail;
import cal_JointAuction_POJO.EventName;
import cal_JointAuction_POJO.Jurisdiction;
import cal_JointAuction_POJO.Jurisdictions;
import cal_JointAuction_POJO.ResultData;
import cal_JointAuction_POJO.SaleEventData;
import cal_JointAuction_POJO.VintagesData;
import cal_JointAuction_POJO.createJointAuctionEvent;
import io.restassured.response.Response;

public class A48 {

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
	public static String randomEventName;      //= "API_A46_8PH8";
	public static String jointAuctionEventId;

	public static void createJointAuctionEvent() {

		randomEventName = UsersAndMFASecreteKey.Release+"A48_CA_QC_JOINT_AUCTION_" + generateRandomString(4);
		System.out.println("randomEventName: " + randomEventName);

//		eventId = "API_" + generateRandomString(4);
//		System.out.println("eventId: " + eventId);

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

		createJointAuctionEvent request = new createJointAuctionEvent();

		BasicInfo basicInfo = new BasicInfo();
		basicInfo.setEventId("A48");
		basicInfo.setEventTypeId(System.getProperty("AUCTION_SALE_TYPE_ID"));
		basicInfo.setEventTypeName("Auction");
		basicInfo.setParticipatingJurisdictions(List.of(System.getProperty("JURISDICTION_ID_CALIFORNIA"),
				System.getProperty("JURISDICTION_ID_QUEBEC")));
		basicInfo.setParticipatingJurisdictionsNames(List.of("California", "Quebec"));

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

		Jurisdiction jurisdictionQC = new Jurisdiction();
		jurisdictionQC.setId(System.getProperty("JURISDICTION_ID_QUEBEC"));
		jurisdictionQC.setName("Quebec");

		CurrencyAccepted currencyUSD = new CurrencyAccepted();
		currencyUSD.setCurrencyId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		currencyUSD.setCurrencyType("USD");
		currencyUSD.setCurrencyValue(ConfigFileManager.getProperty("FloorPriceUSD_PE5"));

		CurrencyAccepted currencyCAD = new CurrencyAccepted();
		currencyCAD.setCurrencyId(System.getProperty("JURISDICTION_ID_QUEBEC"));
		currencyCAD.setCurrencyType("CAD");
		currencyCAD.setCurrencyValue(ConfigFileManager.getProperty("FloorPriceCAD_PE5"));

		VintagesData vintage2023 = new VintagesData();
		vintage2023.setVintages(System.getProperty("VINTAGE_YEAR_ID_2023"));
		vintage2023.setVintagesAllowancesAvailable(ConfigFileManager.getProperty("TotalAllowances_Current_PE5"));
		vintage2023.setVintageType(System.getProperty("CURRENT_VINTAGE_TYPE_ID"));
		vintage2023.setProcessingOrder("1");

		detail.setJurisdictions(List.of(jurisdictionCA, jurisdictionQC));
		detail.setCurrencyAccepted(List.of(currencyUSD, currencyCAD));
		detail.setVintagesData(List.of(vintage2023));
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
		biddersConference.setJurisdictionId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		biddersConference.setBiddersConferenceDateTime("");

		dateTime.setBiddersConference(List.of(biddersConference));
		request.setDateTime(dateTime);

		AdditionalSettings additionalSettings = new AdditionalSettings();
		additionalSettings.setAllowancesPerBidLot(1000);
		additionalSettings.setLimitMaximumBidsAllowed(1000);
		additionalSettings.setSetMaximumBidPrice(false);
		additionalSettings.setAlgorithm(System.getProperty("ALGORITHM_ID"));

		request.setAdditionalSettings(additionalSettings);

		String url = BaseUrl + "auction/api/event";
		Response res = RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), request);

		jointAuctionEventId = RestClient.extractJsonValue(res, "data.eventDBId");

		System.out.println("eventDbId: " + jointAuctionEventId);
	}

	public static void addFxRateByCASponsor() {

		SaleEventData request = new SaleEventData();

		request.setSaleEventId(API_Common_Endpoints.eventID);
		request.setBaseCurrencyTypeId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		request.setToCurrencyTypeId(System.getProperty("JURISDICTION_ID_QUEBEC"));
		request.setFxRate("1.1045");
		request.setJurisdictionId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		request.setSecondSubmission(false);

		ResultData resultData = new ResultData();
		resultData.setSaleEventName(randomEventName);
		resultData.setSaleEventId(API_Common_Endpoints.eventID);
		resultData.setBaseCurrencyTypeId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		resultData.setToCurrencyTypeId(System.getProperty("JURISDICTION_ID_QUEBEC"));
		resultData.setEventFXRateStatus(false);
		resultData.setIsAllowedToResetFxRate(1);
		resultData.setBiddingOpen(false);

		Jurisdictions California = new Jurisdictions();
		California.setJurisdictionName("CA");
		California.setAnnualReservePrice(10);
		California.setCurrencyId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		California.setCurrency("USD");
		California.setFxRate("1.1045");
		California.setApproverName("");
		California.setJuridictionSubmited(false);
		California.setApprovedReservePriceCurrent("12.01");
		California.setApprovedReservePriceFuture("12.01");
		California.setJurisdictionId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));

		Jurisdictions Quebec = new Jurisdictions();
		Quebec.setJurisdictionName("QC");
		Quebec.setAnnualReservePrice(13.27);
		Quebec.setCurrencyId(System.getProperty("JURISDICTION_ID_QUEBEC"));
		Quebec.setCurrency("CAD");
		Quebec.setFxRate("");
		Quebec.setApproverName("");
		Quebec.setJuridictionSubmited(false);
		Quebec.setApprovedReservePriceCurrent(13.27);
		Quebec.setApprovedReservePriceFuture(13.27);
		Quebec.setJurisdictionId(System.getProperty("JURISDICTION_ID_QUEBEC"));

		resultData.setJurisdictions(List.of(California, Quebec));

		request.setResultData(resultData);

		String url = BaseUrl + "auction/api/add-fx-rate";
		RestClient.post(url, accessToken, idToken, languageCode, refreshToken, sessionId,
				System.getProperty("entityId"), request);

	}

	public static void addFxrateByQCSponsor() {
		SaleEventData request = new SaleEventData();

		request.setSaleEventId(API_Common_Endpoints.eventID);
		request.setBaseCurrencyTypeId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		request.setToCurrencyTypeId(System.getProperty("JURISDICTION_ID_QUEBEC"));
		request.setFxRate("1.1045");
		request.setJurisdictionId(System.getProperty("JURISDICTION_ID_QUEBEC"));
		request.setSecondSubmission(true);

		ResultData result = new ResultData();
		result.setSaleEventName(randomEventName);
		result.setSaleEventId(API_Common_Endpoints.eventID);
		result.setBaseCurrencyTypeId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		result.setToCurrencyTypeId(System.getProperty("JURISDICTION_ID_QUEBEC"));
		result.setEventFXRateStatus(false);
		result.setIsAllowedToResetFxRate(1);
		result.setBiddingOpen(false);

		Jurisdictions ca = new Jurisdictions();
		ca.setJurisdictionName("CA");
		ca.setAnnualReservePrice(10);
		ca.setCurrencyId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));
		ca.setCurrency("USD");
		ca.setFxRate(1.1045);
		ca.setApproverName("user nick");
		ca.setJuridictionSubmited(true);
		ca.setApprovedReservePriceCurrent("12.01");
		ca.setApprovedReservePriceFuture("12.01");
		ca.setJurisdictionId(System.getProperty("JURISDICTION_ID_CALIFORNIA"));

		Jurisdictions qc = new Jurisdictions();
		qc.setJurisdictionName("QC");
		qc.setAnnualReservePrice(13.27);
		qc.setCurrencyId(System.getProperty("JURISDICTION_ID_QUEBEC"));
		qc.setCurrency("CAD");
		qc.setFxRate("1.1045");
		qc.setApproverName("");
		qc.setJuridictionSubmited(false);
		qc.setApprovedReservePriceCurrent(13.27);
		qc.setApprovedReservePriceFuture(13.27);
		qc.setJurisdictionId(System.getProperty("JURISDICTION_ID_QUEBEC"));

		result.setJurisdictions(List.of(ca, qc));
		request.setResultData(result);

		String url = BaseUrl + "auction/api/add-fx-rate";
		RestClient.post(url, accessToken, idToken, "en", refreshToken, sessionId,
				System.getProperty("entityId"), request);
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
		basicInfo.put("participatingJurisdictionsNames", Arrays.asList("California", "Quebec"));
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