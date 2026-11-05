package prescribedEventTest;

import org.testng.annotations.Test;
import API_Base_Classes.BaseClass;
import API_Base_Classes.user_LogIn;
import Event_Creation.R317;
import TestData.UsersAndMFASecreteKey;
import api_Common_Utilities.ConfigFileManager;
import api_Common_Utilities.API_Common_Endpoints;

public class calReserveSale extends BaseClass {

	@Test(priority = 1)
	public void R317() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
//		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R317.createReserveEvent();
//		MyListeners.getExtentTest().log(Status.PASS, "Event R317 create successfully");
		
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca2_MFAKey);//CA2
//		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		Thread.sleep(55000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName11_PE1, UsersAndMFASecreteKey.password2, UsersAndMFASecreteKey.AR_UserName11_PE1_MFAKey);//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_RE1Ca_API");
		API_Common_Endpoints.getLiveEvents(R317.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R317.addBid(System.getProperty("CA3213_4519_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_Tier_two_RE1Ca"), ConfigFileManager.getProperty("Bid_Lot__RE1Ca"), System.getProperty("CA_allowanceTierTwoID"), API_Common_Endpoints.arEventId);
		R317.addBid(System.getProperty("CA3223_4531_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_Tier_one_RE1Ca"), ConfigFileManager.getProperty("Bid_Lot1__RE1Ca"), System.getProperty("CA_allowanceTierOneID"), API_Common_Endpoints.arEventId);
		R317.addBid(System.getProperty("CA3223_4531_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_Tier_two_RE1Ca"), ConfigFileManager.getProperty("Bid_Lot2__RE1Ca"), System.getProperty("CA_allowanceTierTwoID"), API_Common_Endpoints.arEventId);
		R317.addBid(System.getProperty("CA3225_4535_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_Tier_one_RE1Ca"), ConfigFileManager.getProperty("Bid_Lot3__RE1Ca"), System.getProperty("CA_allowanceTierOneID"), API_Common_Endpoints.arEventId);
//		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		R317.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca2_MFAKey);//CA2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca2_MFAKey);//CA2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca2_MFAKey);//CA2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
//		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
}