package prescribedEventTest;

import org.testng.annotations.Test;

import API_Base_Classes.BaseClass;
import API_Base_Classes.user_LogIn;
import api_Common_Utilities.API_Common_Endpoints;
import api_Common_Utilities.ConfigFileManager;
import Event_Creation.R319;
import Event_Creation.R325;
import TestData.UsersAndMFASecreteKey;

public class waAPCRevent extends BaseClass {

	@Test(priority = 1)
	public void R319() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
//		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getJurisdiction();
		R319.createAPCREvent();
//		MyListeners.getExtentTest().log(Status.PASS, "Event R319 create successfully");
		
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
//		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(20000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		Thread.sleep(70000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName12_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName12_PE1_MFAKey);// AR
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
//		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		R319.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R319.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 2)
	public void R325() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
//		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getJurisdiction();
		R325.createAPCREvent();
//		MyListeners.getExtentTest().log(Status.PASS, "Event R325 create successfully");
		
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
//		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(20000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		Thread.sleep(70000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName12_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName12_PE1_MFAKey);// AR
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
//		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		R325.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R325.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
}