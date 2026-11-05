package prescribedEventTest;

import org.testng.annotations.Test;
import API_Base_Classes.BaseClass;
import API_Base_Classes.user_LogIn;
import Event_Creation.A218;
import Event_Creation.A278;
import TestData.UsersAndMFASecreteKey;
import api_Common_Utilities.API_Common_Endpoints;
import api_Common_Utilities.ConfigFileManager;

public class WAsingleAuction extends BaseClass{

	@Test(priority = 1)
	public void A218() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
//		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getJurisdiction();
		API_Common_Endpoints.getAlgorithmData();
		A218.createSingleAuctionEvent();
//		MyListeners.getExtentTest().log(Status.PASS, "Event A218 create successfully");

		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
//		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(20000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		Thread.sleep(70000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName12_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName12_PE1_MFAKey);//AR
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
//		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		A218.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A218.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 2)
	public void A278() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
//		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getJurisdiction();
		API_Common_Endpoints.getAlgorithmData();
		A278.createSingleAuctionEvent();
//		MyListeners.getExtentTest().log(Status.PASS, "Event A278 create successfully");

		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
//		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(20000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		Thread.sleep(70000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName13_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName13_PE1_MFAKey);//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PEWa2_API");
		API_Common_Endpoints.getLiveEvents(A278.randomEventName);
		API_Common_Endpoints.getVintages();

		A278.addBid(System.getProperty("WA7031_10710_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_1"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_1"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7031_10710_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_2"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_2"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7031_10710_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Advance_PEWa2_1"),
				ConfigFileManager.getProperty("Bid_Lot_Advance_PEWa2_1"), System.getProperty("advanceVintageType"),
				API_Common_Endpoints.arEventId);

		A278.addBid(System.getProperty("WA7088_10824_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_3"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_3"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7088_10824_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_4"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_4"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7088_10824_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Advance_PEWa2_2"),
				ConfigFileManager.getProperty("Bid_Lot_Advance_PEWa2_2"), System.getProperty("advanceVintageType"),
				API_Common_Endpoints.arEventId);

		A278.addBid(System.getProperty("WA7089_10826_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_5"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_5"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7089_10826_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_6"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_6"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7089_10826_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_7"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_7"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7089_10826_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_8"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_8"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7089_10826_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_9"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_9"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7089_10826_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_10"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_10"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7089_10826_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Advance_PEWa2_3"),
				ConfigFileManager.getProperty("Bid_Lot_Advance_PEWa2_3"), System.getProperty("advanceVintageType"),
				API_Common_Endpoints.arEventId);

		A278.addBid(System.getProperty("WA7090_10828_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_11"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_11"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7090_10828_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_12"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_12"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7090_10828_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Advance_PEWa2_4"),
				ConfigFileManager.getProperty("Bid_Lot_Advance_PEWa2_4"), System.getProperty("advanceVintageType"),
				API_Common_Endpoints.arEventId);

		A278.addBid(System.getProperty("WA7091_10830_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_13"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_13"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7091_10830_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_14"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_14"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7091_10830_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_15"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_15"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7091_10830_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Advance_PEWa2_5"),
				ConfigFileManager.getProperty("Bid_Lot_Advance_PEWa2_5"), System.getProperty("advanceVintageType"),
				API_Common_Endpoints.arEventId);

		A278.addBid(System.getProperty("WA7154_10914_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_16"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_16"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7154_10914_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_17"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_17"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7154_10914_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Advance_PEWa2_6"),
				ConfigFileManager.getProperty("Bid_Lot_Advance_PEWa2_6"), System.getProperty("advanceVintageType"),
				API_Common_Endpoints.arEventId);

		A278.addBid(System.getProperty("WA7202_11058_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_18"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_18"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7202_11058_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_19"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_19"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7202_11058_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_20"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_20"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7202_11058_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Current_PEWa2_21"),
				ConfigFileManager.getProperty("Bid_Lot_Current_PEWa2_21"), System.getProperty("currentvintageType"),
				API_Common_Endpoints.arEventId);
		A278.addBid(System.getProperty("WA7202_11058_Entity_ID"),
				ConfigFileManager.getProperty("Bid_Price_Advance_PEWa2_7"),
				ConfigFileManager.getProperty("Bid_Lot_Advance_PEWa2_7"), System.getProperty("advanceVintageType"),
				API_Common_Endpoints.arEventId);
//		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		A278.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa1_MFAKey);// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_wa2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_wa2_MFAKey);// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
}