package prescribedEventTest;

import org.testng.annotations.Test;

import API_Base_Classes.BaseClass;
import API_Base_Classes.user_LogIn;
import api_Common_Utilities.API_Common_Endpoints;
import api_Common_Utilities.ConfigFileManager;
import Event_Creation.R69;
import Event_Creation.R70;
import Event_Creation.R71;
import Event_Creation.R72;
import Event_Creation.R73;
import Event_Creation.R74;
import Event_Creation.R76;
import TestData.UsersAndMFASecreteKey;

public class QcSBMA extends BaseClass{

	@Test(priority = 1)
	public void R69() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R69.createSBMAEvent();
		//MyListeners.getExtentTest().log(Status.PASS, "Event R69 create successfully");

		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R69");
		Thread.sleep(70000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName7_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName7_PE1_MFAKey);//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA1_API");
		API_Common_Endpoints.getLiveEvents(R69.randomEventName);
		API_Common_Endpoints.getTierId();

		R69.addBid(System.getProperty("QC01647_92680_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_1"), System.getProperty("CA_allowanceTierTwoID"),
				API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC01684_02852_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_2"), System.getProperty("CA_allowanceTierOneID"),
				API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC21659_42726_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_3"), System.getProperty("CA_allowanceTierTwoID"),
				API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC41652_42656_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_4"), System.getProperty("CA_allowanceTierTwoID"),
				API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC91608_52231_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_5"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName8_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName8_PE1_MFAKey);//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA1_API");
		API_Common_Endpoints.getLiveEvents(R69.randomEventName);
		API_Common_Endpoints.getTierId();

		R69.addBid(System.getProperty("QC3737_4143_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_6"), System.getProperty("CA_allowanceTierTwoID"),
				API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC3738_4145_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_7"), System.getProperty("CA_allowanceTierOneID"),
				API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC3739_4147_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_8"), System.getProperty("CA_allowanceTierTwoID"),
				API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC3740_4149_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_9"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R69.addBid(System.getProperty("QC3741_4151_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_10"), System.getProperty("CA_allowanceTierOneID"),
				API_Common_Endpoints.arEventId);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName9_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName9_PE1_MFAKey);//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA1_API");
		API_Common_Endpoints.getLiveEvents(R69.randomEventName);
		API_Common_Endpoints.getTierId();

		R69.addBid(System.getProperty("QC3774_4207_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_11"), System.getProperty("CA_allowanceTierOneID"),
				API_Common_Endpoints.arEventId);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName10_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName10_PE1_MFAKey);//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA1_API");
		API_Common_Endpoints.getLiveEvents(R69.randomEventName);
		API_Common_Endpoints.getTierId();

		R69.addBid(System.getProperty("QC71576_51728_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA1"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA1_12"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		//MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		R69.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		Thread.sleep(10000);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R69.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 2)
	public void R70() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R70.createSBMAEvent();
		//MyListeners.getExtentTest().log(Status.PASS, "Event R70 create successfully");

		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R70");
		Thread.sleep(70000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA2_API");
		API_Common_Endpoints.getLiveEvents(R70.randomEventName);
		API_Common_Endpoints.getTierId();

		R70.addBid(System.getProperty("QC4085_5100_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA2"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA2_1"), System.getProperty("CA_allowanceTierOneID"),
				API_Common_Endpoints.arEventId);
		R70.addBid(System.getProperty("QC4091_5112_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA2"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA2_2"), System.getProperty("CA_allowanceTierOneID"),
				API_Common_Endpoints.arEventId);
		R70.addBid(System.getProperty("QC4096_5122_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA2"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA2_3"), System.getProperty("CA_allowanceTierTwoID"),
				API_Common_Endpoints.arEventId);
		R70.addBid(System.getProperty("QC4097_5124_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA2"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA2_4"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R70.addBid(System.getProperty("QC4098_5126_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA2"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA2_5"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		//MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		R70.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 3)
	public void R71() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R71.createSBMAEvent();
		//MyListeners.getExtentTest().log(Status.PASS, "Event R71 create successfully");

		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R71");
		Thread.sleep(70000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA3_API");
		API_Common_Endpoints.getLiveEvents(R71.randomEventName);
		API_Common_Endpoints.getTierId();

		R71.addBid(System.getProperty("QC4085_5100_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA3"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA3_1"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R71.addBid(System.getProperty("QC4091_5112_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA3"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA3_2"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R71.addBid(System.getProperty("QC4096_5122_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA3"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA3_3"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R71.addBid(System.getProperty("QC4097_5124_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA3"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA3_4"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R71.addBid(System.getProperty("QC4098_5126_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA3"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA3_5"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		//MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		R71.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 4)
	public void R72() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R72.createSBMAEvent();
		//MyListeners.getExtentTest().log(Status.PASS, "Event R72 create successfully");

		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R72");
		Thread.sleep(70000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA4_API");
		API_Common_Endpoints.getLiveEvents(R72.randomEventName);
		API_Common_Endpoints.getTierId();

		R72.addBid(System.getProperty("QC4085_5100_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA4"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA4_1"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R72.addBid(System.getProperty("QC4091_5112_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA4"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA4_2"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R72.addBid(System.getProperty("QC4096_5122_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA4"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA4_3"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R72.addBid(System.getProperty("QC4097_5124_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA4"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA4_4"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R72.addBid(System.getProperty("QC4098_5126_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA4"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA4_5"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		//MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		R72.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		Thread.sleep(10000);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R72.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 5)
	public void R73() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R73.createSBMAEvent();
		//MyListeners.getExtentTest().log(Status.PASS, "Event R73 create successfully");

		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R73");
		Thread.sleep(70000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA5_API");
		API_Common_Endpoints.getLiveEvents(R73.randomEventName);
		API_Common_Endpoints.getTierId();

		R73.addBid(System.getProperty("QC4085_5100_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA5"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA5_1"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R73.addBid(System.getProperty("QC4091_5112_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA5"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA5_2"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R73.addBid(System.getProperty("QC4096_5122_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA5"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA5_3"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R73.addBid(System.getProperty("QC4097_5124_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA5"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA5_4"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R73.addBid(System.getProperty("QC4098_5126_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA5"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA5_5"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		//MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		R73.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		Thread.sleep(10000);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 6)
	public void R74() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R74.createSBMAEvent();
		//MyListeners.getExtentTest().log(Status.PASS, "Event R74 create successfully");

		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R74");
		Thread.sleep(70000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA6_API");
		API_Common_Endpoints.getLiveEvents(R74.randomEventName);
		API_Common_Endpoints.getTierId();

		R74.addBid(System.getProperty("QC4085_5100_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA6"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA6_1"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R74.addBid(System.getProperty("QC4091_5112_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA6"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA6_2"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R74.addBid(System.getProperty("QC4096_5122_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA6"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA6_3"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R74.addBid(System.getProperty("QC4097_5124_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA6"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA6_4"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R74.addBid(System.getProperty("QC4098_5126_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA6"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA6_5"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		//MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		R74.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		Thread.sleep(10000);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 7)
	public void R76() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R76.createSBMAEvent();
		//MyListeners.getExtentTest().log(Status.PASS, "Event R76 create successfully");

		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		//MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R76");
		Thread.sleep(70000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA7_API");
		API_Common_Endpoints.getLiveEvents(R76.randomEventName);
		API_Common_Endpoints.getTierId();

		R76.addBid(System.getProperty("QC4085_5100_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA7"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA7_1"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R76.addBid(System.getProperty("QC4091_5112_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA7"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA7_2"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R76.addBid(System.getProperty("QC4096_5122_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA7"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA7_3"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R76.addBid(System.getProperty("QC4097_5124_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA7"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA7_4"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		R76.addBid(System.getProperty("QC4098_5126_Entity_ID"),
				ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA7"),
				ConfigFileManager.getProperty("Bid_Lot__SBMA7_5"), System.getProperty("CA_allowanceTierThreeID"),
				API_Common_Endpoints.arEventId);
		//MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		R76.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		Thread.sleep(10000);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc2,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc2_MFAKey);//QC2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		//MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
}