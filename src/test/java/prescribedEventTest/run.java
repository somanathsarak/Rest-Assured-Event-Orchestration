package prescribedEventTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import API_Base_Classes.BaseClass;
import API_Base_Classes.existingUser_LogIn;
import Event_Creation.A218;
import Event_Creation.R319;
import Event_Creation.R325;
import Event_Creation.R69;
import Event_Creation.R72;
import Utilities.MyListeners;
import api_Common_Utilities.API_Common_Endpoints;
import api_Common_Utilities.ConfigFileManager;
@Listeners(Utilities.MyListeners.class)

public class run extends BaseClass {

	@Test(priority = 0)
	public void A218() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getJurisdiction();
		API_Common_Endpoints.getAlgorithmData();
		A218.createSingleAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A218 create successfully");

		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(20000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		Thread.sleep(70000);

		existingUser_LogIn.logInUser("AR_USerName1_PEWa", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PEWa_API");
		API_Common_Endpoints.getLiveEvents(A218.randomEventName);
		API_Common_Endpoints.getVintages();

		A218.addBid(System.getProperty("WA6585_9938_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa1"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa1"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A218.addBid(System.getProperty("WA6585_9938_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Advance_PEWa1"),
				ConfigFileManager.getProperty("Bid_Lot_Advance_PEWa1"), System.getProperty("advanceVintageType"),
				API_Common_Endpoints.arEventId);

		A218.addBid(System.getProperty("WA6586_9940_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A218.addBid(System.getProperty("WA6586_9940_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Advance_PEWa2"),
				ConfigFileManager.getProperty("Bid_Lot_Advance_PEWa2"), System.getProperty("advanceVintageType"),
				API_Common_Endpoints.arEventId);

		A218.addBid(System.getProperty("WA6611_9990_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa3"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa3"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A218.addBid(System.getProperty("WA6611_9990_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Advance_PEWa3"),
				ConfigFileManager.getProperty("Bid_Lot_Advance_PEWa3"), System.getProperty("advanceVintageType"),
				API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A218.randomEventName);
		A218.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(25000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test(priority = 1)
	public void R319() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getJurisdiction();
		R319.createAPCREvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event R319 create successfully");
		
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(20000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		Thread.sleep(70000);

		existingUser_LogIn.logInUser("AR_USerName_REWA1", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_REWA1_API");
		API_Common_Endpoints.getLiveEvents(R319.randomEventName);
		API_Common_Endpoints.getTierId();

		R319.addBid(System.getProperty("WA6585_9938_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA1"),
				ConfigFileManager.getProperty("Bid_Lot1__REWA1"), System.getProperty("CA_allowanceTierOneID"),
				API_Common_Endpoints.arEventId);
		R319.addBid(System.getProperty("WA6586_9940_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA1"),
				ConfigFileManager.getProperty("Bid_Lot2__REWA1"), System.getProperty("CA_allowanceTierTwoID"),
				API_Common_Endpoints.arEventId);
		R319.addBid(System.getProperty("WA6587_9942_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA1"),
				ConfigFileManager.getProperty("Bid_Lot3__REWA1"), System.getProperty("CA_allowanceTierOneID"),
				API_Common_Endpoints.arEventId);
		R319.addBid(System.getProperty("WA6588_9944_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA1"),
				ConfigFileManager.getProperty("Bid_Lot4__REWA1"), System.getProperty("CA_allowanceTierTwoID"),
				API_Common_Endpoints.arEventId);
		R319.addBid(System.getProperty("WA6589_9946_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_Tier_three_REWA1"),
				ConfigFileManager.getProperty("Bid_Lot5__REWA1"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		R319.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);

		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(25000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 2)
	public void R325() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getJurisdiction();
		R325.createAPCREvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event R325 create successfully");
		
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");//2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(20000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		Thread.sleep(70000);

		existingUser_LogIn.logInUser("AR_USerName_REWA2", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_REWA2_API");
		API_Common_Endpoints.getLiveEvents(R325.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R325.addBid(System.getProperty("WA6585_9938_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot1__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6585_9938_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot2__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6586_9940_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot3__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6586_9940_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot4__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6587_9942_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot5__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6587_9942_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot6__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6588_9944_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot7__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6588_9944_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot8__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6589_9946_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot9__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6590_9948_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot10__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6591_9950_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot11__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6591_9950_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot12__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);

		R325.addBid(System.getProperty("WA6592_9952_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot13__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6593_9954_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot14__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6593_9954_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot15__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6594_9956_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot16__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6594_9956_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot17__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6611_9990_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot18__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6611_9990_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot19__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6612_9993_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot20__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6612_9993_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot21__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6613_9996_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot22__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6613_9996_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot23__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6614_9999_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot24__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6614_9999_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot25__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6615_10002_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot26__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6615_10002_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot27__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6616_10005_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot28__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6616_10005_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot29__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6617_10008_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot30__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6617_10008_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot31__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6618_10011_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot32__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6618_10011_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot33__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6619_10014_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot34__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6619_10014_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot35__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6619_10014_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot36__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		
		R325.addBid(System.getProperty("WA6620_10017_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_one_REWA2"),ConfigFileManager.getProperty("Bid_Lot37__REWA2"), System.getProperty("CA_allowanceTierOneID"),API_Common_Endpoints.arEventId);
		R325.addBid(System.getProperty("WA6620_10017_Entity_ID"),ConfigFileManager.getProperty("PriceOffered_Tier_two_REWA2"),ConfigFileManager.getProperty("Bid_Lot38__REWA2"), System.getProperty("CA_allowanceTierTwoID"),API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		R325.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);

		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(25000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 16)
	public void R72() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R72.createSBMAEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event R72 create successfully");
		
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R72");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName_SBMA4", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA4_API");
		API_Common_Endpoints.getLiveEvents(R72.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R72.addBid(System.getProperty("QC4085_5100_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA4"), ConfigFileManager.getProperty("Bid_Lot__SBMA4_1"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R72.addBid(System.getProperty("QC4091_5112_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA4"), ConfigFileManager.getProperty("Bid_Lot__SBMA4_2"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R72.addBid(System.getProperty("QC4096_5122_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA4"), ConfigFileManager.getProperty("Bid_Lot__SBMA4_3"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R72.addBid(System.getProperty("QC4097_5124_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA4"), ConfigFileManager.getProperty("Bid_Lot__SBMA4_4"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R72.addBid(System.getProperty("QC4098_5126_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA4"), ConfigFileManager.getProperty("Bid_Lot__SBMA4_5"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		R72.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	
	@Test (priority = 13)
	public void R69() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R69.createSBMAEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event R69 create successfully");
		
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R69");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName1_SBMA1", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA1_API");
		API_Common_Endpoints.getLiveEvents(R69.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R69.addBid(System.getProperty("QC01647_92680_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_1"), System.getProperty("CA_allowanceTierTwoID"), API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC01684_02852_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_2"), System.getProperty("CA_allowanceTierOneID"), API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC21659_42726_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_3"), System.getProperty("CA_allowanceTierTwoID"), API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC41652_42656_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_4"), System.getProperty("CA_allowanceTierTwoID"), API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC91608_52231_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_5"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		
		existingUser_LogIn.logInUser("AR_USerName2_SBMA1", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA1_API");
		API_Common_Endpoints.getLiveEvents(R69.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R69.addBid(System.getProperty("QC3737_4143_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_6"), System.getProperty("CA_allowanceTierTwoID"), API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC3738_4145_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_7"), System.getProperty("CA_allowanceTierOneID"), API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC3739_4147_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_8"), System.getProperty("CA_allowanceTierTwoID"), API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC3740_4149_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_9"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC3741_4151_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_10"), System.getProperty("CA_allowanceTierOneID"), API_Common_Endpoints.arEventId);
		
		existingUser_LogIn.logInUser("AR_USerName3_SBMA1", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA1_API");
		API_Common_Endpoints.getLiveEvents(R69.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R69.addBid(System.getProperty("QC3774_4207_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_11"), System.getProperty("CA_allowanceTierOneID"), API_Common_Endpoints.arEventId);
		
		existingUser_LogIn.logInUser("AR_USerName4_SBMA1", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA1_API");
		API_Common_Endpoints.getLiveEvents(R69.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R69.addBid(System.getProperty("QC71576_51728_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA1"), ConfigFileManager.getProperty("Bid_Lot__SBMA1_12"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		R69.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
}