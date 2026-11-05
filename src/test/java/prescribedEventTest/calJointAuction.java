package prescribedEventTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import API_Base_Classes.BaseClass;
import API_Base_Classes.user_LogIn;
import api_Common_Utilities.API_Common_Endpoints;
import api_Common_Utilities.ConfigFileManager;
import Event_Creation.A42;
import Event_Creation.A45;
import Event_Creation.A46;
import Event_Creation.A47;
import Event_Creation.A48;
import Event_Creation.A49;
import Event_Creation.A50;
import Event_Creation.A51;
import Event_Creation.A56;
import Event_Creation.A57;
import Event_Creation.A297;
import Event_Creation.A298;
import TestData.UsersAndMFASecreteKey;
import Utilities.MyListeners;

@Listeners(Utilities.MyListeners.class)
public class calJointAuction extends BaseClass {

	@Test (priority = 1)
	public void A42() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A42.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A42 Created successfully");

		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Event Approved by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Event Approved by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A42.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A42.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by second Sponsor");
		Thread.sleep(80000);
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName1_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName1_PE1_MFAKey);//CA

		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE1_API");
		API_Common_Endpoints.getLiveEvents(A42.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A42.addBid(System.getProperty("CA4044_5032_Entity_ID"), ConfigFileManager.getProperty("Bid_Price_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("CA4044_5032_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("CA4044_5032_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Advance_PE1"), ConfigFileManager.getProperty("Bid_Lot3_Advance_PE1"), System.getProperty("advanceVintageType"), API_Common_Endpoints.arEventId);

		A42.addBid(System.getProperty("CA4211_5424_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("CA4211_5424_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("CA4211_5424_Entity_ID"), ConfigFileManager.getProperty("Bid_Price6_Advance_PE1"), ConfigFileManager.getProperty("Bid_Lot6_Advance_PE1"), System.getProperty("advanceVintageType"), API_Common_Endpoints.arEventId);

		A42.addBid(System.getProperty("CA4259_5372_Entity_ID"), ConfigFileManager.getProperty("Bid_Price7_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot7_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("CA4259_5372_Entity_ID"), ConfigFileManager.getProperty("Bid_Price8_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot8_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("CA4259_5372_Entity_ID"), ConfigFileManager.getProperty("Bid_Price9_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot9_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("CA4259_5372_Entity_ID"), ConfigFileManager.getProperty("Bid_Price10_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot10_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("CA4259_5372_Entity_ID"), ConfigFileManager.getProperty("Bid_Price11_Advance_PE1"), ConfigFileManager.getProperty("Bid_Lot11_Advance_PE1"), System.getProperty("advanceVintageType"), API_Common_Endpoints.arEventId);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE1_API");
		API_Common_Endpoints.getLiveEvents(A42.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A42.addBid(System.getProperty("QC4103_5136_Entity_ID"), ConfigFileManager.getProperty("Bid_Price12_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot12_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4103_5136_Entity_ID"), ConfigFileManager.getProperty("Bid_Price13_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot13_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4103_5136_Entity_ID"), ConfigFileManager.getProperty("Bid_Price14_Advance_PE1"), ConfigFileManager.getProperty("Bid_Lot14_Advance_PE1"), System.getProperty("advanceVintageType"), API_Common_Endpoints.arEventId);

		A42.addBid(System.getProperty("QC4104_5138_Entity_ID"), ConfigFileManager.getProperty("Bid_Price15_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot15_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4104_5138_Entity_ID"), ConfigFileManager.getProperty("Bid_Price16_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot16_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4104_5138_Entity_ID"), ConfigFileManager.getProperty("Bid_Price17_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot17_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4104_5138_Entity_ID"), ConfigFileManager.getProperty("Bid_Price18_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot18_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4104_5138_Entity_ID"), ConfigFileManager.getProperty("Bid_Price19_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot19_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4104_5138_Entity_ID"), ConfigFileManager.getProperty("Bid_Price20_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot20_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4104_5138_Entity_ID"), ConfigFileManager.getProperty("Bid_Price21_Advance_PE1"), ConfigFileManager.getProperty("Bid_Lot21_Advance_PE1"), System.getProperty("advanceVintageType"), API_Common_Endpoints.arEventId);
		
		A42.addBid(System.getProperty("QC4105_5140_Entity_ID"), ConfigFileManager.getProperty("Bid_Price22_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot22_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4105_5140_Entity_ID"), ConfigFileManager.getProperty("Bid_Price23_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot23_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4105_5140_Entity_ID"), ConfigFileManager.getProperty("Bid_Price24_Advance_PE1"), ConfigFileManager.getProperty("Bid_Lot24_Advance_PE1"), System.getProperty("advanceVintageType"), API_Common_Endpoints.arEventId);
		
		A42.addBid(System.getProperty("QC4106_5142_Entity_ID"), ConfigFileManager.getProperty("Bid_Price25_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot25_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4106_5142_Entity_ID"), ConfigFileManager.getProperty("Bid_Price26_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot26_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4106_5142_Entity_ID"), ConfigFileManager.getProperty("Bid_Price27_Current_PE1"), ConfigFileManager.getProperty("Bid_Lot27_Current_PE1"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A42.addBid(System.getProperty("QC4106_5142_Entity_ID"), ConfigFileManager.getProperty("Bid_Price28_Advance_PE1"), ConfigFileManager.getProperty("Bid_Lot28_Advance_PE1"), System.getProperty("advanceVintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		A42.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 2)
	public void A45() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A45.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A45 created Successfully");

		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Event Approved by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Event Approved by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A45.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A45.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by Second Sponsor");
		Thread.sleep(80000);

		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName1_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName1_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE2_API");
		API_Common_Endpoints.getLiveEvents(A45.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A45.addBid(System.getProperty("CA4001_4954_Entity_ID"), ConfigFileManager.getProperty("Bid_Price_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("CA4001_4954_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("CA4001_4954_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("CA4001_4954_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE2_API");
		API_Common_Endpoints.getLiveEvents(A45.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A45.addBid(System.getProperty("QC4099_5128_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4099_5128_Entity_ID"), ConfigFileManager.getProperty("Bid_Price6_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot6_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4099_5128_Entity_ID"), ConfigFileManager.getProperty("Bid_Price7_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot7_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4099_5128_Entity_ID"), ConfigFileManager.getProperty("Bid_Price8_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot8_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A45.addBid(System.getProperty("QC4100_5130_Entity_ID"), ConfigFileManager.getProperty("Bid_Price9_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot9_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4100_5130_Entity_ID"), ConfigFileManager.getProperty("Bid_Price10_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot10_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4100_5130_Entity_ID"), ConfigFileManager.getProperty("Bid_Price11_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot11_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4100_5130_Entity_ID"), ConfigFileManager.getProperty("Bid_Price12_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot12_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A45.addBid(System.getProperty("QC4101_5132_Entity_ID"), ConfigFileManager.getProperty("Bid_Price13_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot13_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4101_5132_Entity_ID"), ConfigFileManager.getProperty("Bid_Price14_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot14_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4101_5132_Entity_ID"), ConfigFileManager.getProperty("Bid_Price15_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot15_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4101_5132_Entity_ID"), ConfigFileManager.getProperty("Bid_Price16_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot16_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A45.addBid(System.getProperty("QC4102_5134_Entity_ID"), ConfigFileManager.getProperty("Bid_Price17_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot17_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4102_5134_Entity_ID"), ConfigFileManager.getProperty("Bid_Price18_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot18_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4102_5134_Entity_ID"), ConfigFileManager.getProperty("Bid_Price19_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot19_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("QC4102_5134_Entity_ID"), ConfigFileManager.getProperty("Bid_Price20_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot20_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		A45.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test (priority = 3)
	public void A46() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A46.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A46 created successfully");

		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Event Approved by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Event Approved by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A46.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A46.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by Second Sponsor");
		Thread.sleep(80000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName1_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName1_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE3_API");
		API_Common_Endpoints.getLiveEvents(A46.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A46.addBid(System.getProperty("CA4065_5066_Entity_ID"), ConfigFileManager.getProperty("Bid_Price_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4065_5066_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4065_5066_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4065_5066_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A46.addBid(System.getProperty("CA4071_5078_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4071_5078_Entity_ID"), ConfigFileManager.getProperty("Bid_Price6_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot6_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4071_5078_Entity_ID"), ConfigFileManager.getProperty("Bid_Price7_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot7_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4071_5078_Entity_ID"), ConfigFileManager.getProperty("Bid_Price8_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot8_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A46.addBid(System.getProperty("CA4077_5090_Entity_ID"), ConfigFileManager.getProperty("Bid_Price9_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot9_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4077_5090_Entity_ID"), ConfigFileManager.getProperty("Bid_Price10_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot10_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4077_5090_Entity_ID"), ConfigFileManager.getProperty("Bid_Price11_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot11_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4077_5090_Entity_ID"), ConfigFileManager.getProperty("Bid_Price12_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot12_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A46.addBid(System.getProperty("CA4082_5418_Entity_ID"), ConfigFileManager.getProperty("Bid_Price13_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot13_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4082_5418_Entity_ID"), ConfigFileManager.getProperty("Bid_Price14_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot14_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4082_5418_Entity_ID"), ConfigFileManager.getProperty("Bid_Price15_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot15_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("CA4082_5418_Entity_ID"), ConfigFileManager.getProperty("Bid_Price16_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot16_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
	
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE3_API");
		API_Common_Endpoints.getLiveEvents(A46.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A46.addBid(System.getProperty("QC4090_5110_Entity_ID"), ConfigFileManager.getProperty("Bid_Price17_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot17_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("QC4090_5110_Entity_ID"), ConfigFileManager.getProperty("Bid_Price18_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot18_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("QC4090_5110_Entity_ID"), ConfigFileManager.getProperty("Bid_Price19_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot19_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A46.addBid(System.getProperty("QC4090_5110_Entity_ID"), ConfigFileManager.getProperty("Bid_Price20_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot20_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		A46.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 4)
	public void A47() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A47.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A47 created successfully");

		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A47.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A47.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by Second Sponsor");
		Thread.sleep(80000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName1_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName1_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE4_API");
		API_Common_Endpoints.getLiveEvents(A47.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A47.addBid(System.getProperty("CA4061_5058_Entity_ID"), ConfigFileManager.getProperty("Bid_Price_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4061_5058_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4061_5058_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4061_5058_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A47.addBid(System.getProperty("CA4067_5070_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4067_5070_Entity_ID"), ConfigFileManager.getProperty("Bid_Price6_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot6_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4067_5070_Entity_ID"), ConfigFileManager.getProperty("Bid_Price7_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot7_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4067_5070_Entity_ID"), ConfigFileManager.getProperty("Bid_Price8_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot8_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A47.addBid(System.getProperty("CA4073_5082_Entity_ID"), ConfigFileManager.getProperty("Bid_Price9_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot9_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4073_5082_Entity_ID"), ConfigFileManager.getProperty("Bid_Price10_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot10_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4073_5082_Entity_ID"), ConfigFileManager.getProperty("Bid_Price11_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot11_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4073_5082_Entity_ID"), ConfigFileManager.getProperty("Bid_Price12_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot12_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A47.addBid(System.getProperty("CA4079_5094_Entity_ID"), ConfigFileManager.getProperty("Bid_Price13_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot13_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4079_5094_Entity_ID"), ConfigFileManager.getProperty("Bid_Price14_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot14_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4079_5094_Entity_ID"), ConfigFileManager.getProperty("Bid_Price15_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot15_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("CA4079_5094_Entity_ID"), ConfigFileManager.getProperty("Bid_Price16_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot16_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
	
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE4_API");
		API_Common_Endpoints.getLiveEvents(A47.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A47.addBid(System.getProperty("QC4086_5102_Entity_ID"), ConfigFileManager.getProperty("Bid_Price17_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot17_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("QC4086_5102_Entity_ID"), ConfigFileManager.getProperty("Bid_Price18_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot18_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("QC4086_5102_Entity_ID"), ConfigFileManager.getProperty("Bid_Price19_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot19_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A47.addBid(System.getProperty("QC4086_5102_Entity_ID"), ConfigFileManager.getProperty("Bid_Price20_Current_PE3"), ConfigFileManager.getProperty("Bid_Lot20_Current_PE3"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		A47.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test (priority = 5)
	public void A48() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A48.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A48 created successfully");

		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A48.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A48.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		Thread.sleep(80000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName1_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName1_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE5_API");
		API_Common_Endpoints.getLiveEvents(A48.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A48.addBid(System.getProperty("CA4064_5064_Entity_ID"), ConfigFileManager.getProperty("Bid_Price_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4064_5064_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4064_5064_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4064_5064_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A48.addBid(System.getProperty("CA4070_5076_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4070_5076_Entity_ID"), ConfigFileManager.getProperty("Bid_Price6_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot6_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4070_5076_Entity_ID"), ConfigFileManager.getProperty("Bid_Price7_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot7_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4070_5076_Entity_ID"), ConfigFileManager.getProperty("Bid_Price8_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot8_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A48.addBid(System.getProperty("CA4076_5088_Entity_ID"), ConfigFileManager.getProperty("Bid_Price9_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot9_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4076_5088_Entity_ID"), ConfigFileManager.getProperty("Bid_Price10_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot10_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4076_5088_Entity_ID"), ConfigFileManager.getProperty("Bid_Price11_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot11_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4076_5088_Entity_ID"), ConfigFileManager.getProperty("Bid_Price12_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot12_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A48.addBid(System.getProperty("CA4081_5098_Entity_ID"), ConfigFileManager.getProperty("Bid_Price13_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot13_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4081_5098_Entity_ID"), ConfigFileManager.getProperty("Bid_Price14_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot14_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4081_5098_Entity_ID"), ConfigFileManager.getProperty("Bid_Price15_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot15_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("CA4081_5098_Entity_ID"), ConfigFileManager.getProperty("Bid_Price16_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot16_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
	
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE5_API");
		API_Common_Endpoints.getLiveEvents(A48.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A48.addBid(System.getProperty("QC4089_5108_Entity_ID"), ConfigFileManager.getProperty("Bid_Price17_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot17_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("QC4089_5108_Entity_ID"), ConfigFileManager.getProperty("Bid_Price18_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot18_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("QC4089_5108_Entity_ID"), ConfigFileManager.getProperty("Bid_Price19_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot19_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A48.addBid(System.getProperty("QC4089_5108_Entity_ID"), ConfigFileManager.getProperty("Bid_Price20_Current_PE5"), ConfigFileManager.getProperty("Bid_Lot20_Current_PE5"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		A48.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 6)
	public void A49() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A49.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A49 created successfully");

		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A49.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A49.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(80000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName1_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName1_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE6_API");
		API_Common_Endpoints.getLiveEvents(A49.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A49.addBid(System.getProperty("CA4062_5060_Entity_ID"), ConfigFileManager.getProperty("Bid_Price_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4062_5060_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4062_5060_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4062_5060_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A49.addBid(System.getProperty("CA4068_5072_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4068_5072_Entity_ID"), ConfigFileManager.getProperty("Bid_Price6_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot6_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4068_5072_Entity_ID"), ConfigFileManager.getProperty("Bid_Price7_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot7_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4068_5072_Entity_ID"), ConfigFileManager.getProperty("Bid_Price8_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot8_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A49.addBid(System.getProperty("CA4074_5084_Entity_ID"), ConfigFileManager.getProperty("Bid_Price9_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot9_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4074_5084_Entity_ID"), ConfigFileManager.getProperty("Bid_Price10_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot10_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4074_5084_Entity_ID"), ConfigFileManager.getProperty("Bid_Price11_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot11_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4074_5084_Entity_ID"), ConfigFileManager.getProperty("Bid_Price12_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot12_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A49.addBid(System.getProperty("CA4080_5096_Entity_ID"), ConfigFileManager.getProperty("Bid_Price13_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot13_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4080_5096_Entity_ID"), ConfigFileManager.getProperty("Bid_Price14_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot14_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4080_5096_Entity_ID"), ConfigFileManager.getProperty("Bid_Price15_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot15_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("CA4080_5096_Entity_ID"), ConfigFileManager.getProperty("Bid_Price16_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot16_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
	
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE6_API");
		API_Common_Endpoints.getLiveEvents(A49.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A49.addBid(System.getProperty("QC4093_5116_Entity_ID"), ConfigFileManager.getProperty("Bid_Price17_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot17_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("QC4093_5116_Entity_ID"), ConfigFileManager.getProperty("Bid_Price18_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot18_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("QC4093_5116_Entity_ID"), ConfigFileManager.getProperty("Bid_Price19_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot19_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A49.addBid(System.getProperty("QC4093_5116_Entity_ID"), ConfigFileManager.getProperty("Bid_Price20_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot20_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		A49.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 7)
	public void A50() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A50.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A50 created successfully");

		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A50.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A50.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName1_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName1_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE7_API");
		API_Common_Endpoints.getLiveEvents(A50.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A50.addBid(System.getProperty("CA4065_5066_Entity_ID"), ConfigFileManager.getProperty("Bid_Price_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4065_5066_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4065_5066_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4065_5066_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A50.addBid(System.getProperty("CA4071_5078_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4071_5078_Entity_ID"), ConfigFileManager.getProperty("Bid_Price6_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot6_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4071_5078_Entity_ID"), ConfigFileManager.getProperty("Bid_Price7_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot7_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4071_5078_Entity_ID"), ConfigFileManager.getProperty("Bid_Price8_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot8_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A50.addBid(System.getProperty("CA4077_5090_Entity_ID"), ConfigFileManager.getProperty("Bid_Price9_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot9_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4077_5090_Entity_ID"), ConfigFileManager.getProperty("Bid_Price10_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot10_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4077_5090_Entity_ID"), ConfigFileManager.getProperty("Bid_Price11_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot11_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4077_5090_Entity_ID"), ConfigFileManager.getProperty("Bid_Price12_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot12_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A50.addBid(System.getProperty("CA4082_5418_Entity_ID"), ConfigFileManager.getProperty("Bid_Price13_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot13_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4082_5418_Entity_ID"), ConfigFileManager.getProperty("Bid_Price14_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot14_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4082_5418_Entity_ID"), ConfigFileManager.getProperty("Bid_Price15_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot15_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("CA4082_5418_Entity_ID"), ConfigFileManager.getProperty("Bid_Price16_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot16_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
	
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE7_API");
		API_Common_Endpoints.getLiveEvents(A50.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A50.addBid(System.getProperty("QC4095_5120_Entity_ID"), ConfigFileManager.getProperty("Bid_Price17_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot17_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("QC4095_5120_Entity_ID"), ConfigFileManager.getProperty("Bid_Price18_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot18_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("QC4095_5120_Entity_ID"), ConfigFileManager.getProperty("Bid_Price19_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot19_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A50.addBid(System.getProperty("QC4095_5120_Entity_ID"), ConfigFileManager.getProperty("Bid_Price20_Current_PE6"), ConfigFileManager.getProperty("Bid_Lot20_Current_PE6"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		A50.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test (priority = 8)
	public void A51() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A51.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A51 created successfully");
		
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A51.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A51.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName1_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName1_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE8_API");
		API_Common_Endpoints.getLiveEvents(A51.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A51.addBid(System.getProperty("CA4060_5416_Entity_ID"), ConfigFileManager.getProperty("Bid_Price_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4060_5416_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4060_5416_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4060_5416_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A51.addBid(System.getProperty("CA4066_5068_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4066_5068_Entity_ID"), ConfigFileManager.getProperty("Bid_Price6_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot6_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4066_5068_Entity_ID"), ConfigFileManager.getProperty("Bid_Price7_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot7_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4066_5068_Entity_ID"), ConfigFileManager.getProperty("Bid_Price8_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot8_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A51.addBid(System.getProperty("CA4072_5080_Entity_ID"), ConfigFileManager.getProperty("Bid_Price9_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot9_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4072_5080_Entity_ID"), ConfigFileManager.getProperty("Bid_Price10_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot10_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4072_5080_Entity_ID"), ConfigFileManager.getProperty("Bid_Price11_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot11_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4072_5080_Entity_ID"), ConfigFileManager.getProperty("Bid_Price12_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot12_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A51.addBid(System.getProperty("CA4078_5092_Entity_ID"), ConfigFileManager.getProperty("Bid_Price13_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot13_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4078_5092_Entity_ID"), ConfigFileManager.getProperty("Bid_Price14_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot14_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4078_5092_Entity_ID"), ConfigFileManager.getProperty("Bid_Price15_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot15_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("CA4078_5092_Entity_ID"), ConfigFileManager.getProperty("Bid_Price16_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot16_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
	
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE8_API");
		API_Common_Endpoints.getLiveEvents(A51.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A51.addBid(System.getProperty("QC4092_5114_Entity_ID"), ConfigFileManager.getProperty("Bid_Price17_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot17_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("QC4092_5114_Entity_ID"), ConfigFileManager.getProperty("Bid_Price18_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot18_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("QC4092_5114_Entity_ID"), ConfigFileManager.getProperty("Bid_Price19_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot19_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A51.addBid(System.getProperty("QC4092_5114_Entity_ID"), ConfigFileManager.getProperty("Bid_Price20_Current_PE8"), ConfigFileManager.getProperty("Bid_Lot20_Current_PE8"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		A51.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 9)
	public void A56() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A56.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A56 create successfully");
		
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A56.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A56.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName1_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName1_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE9_API");
		API_Common_Endpoints.getLiveEvents(A56.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A56.addBid(System.getProperty("CA4062_5060_Entity_ID"), ConfigFileManager.getProperty("Bid_Price_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("CA4062_5060_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("CA4062_5060_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("CA4062_5060_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A56.addBid(System.getProperty("CA4068_5072_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("CA4068_5072_Entity_ID"), ConfigFileManager.getProperty("Bid_Price6_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot6_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("CA4068_5072_Entity_ID"), ConfigFileManager.getProperty("Bid_Price7_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot7_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("CA4068_5072_Entity_ID"), ConfigFileManager.getProperty("Bid_Price8_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot8_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A56.addBid(System.getProperty("CA4074_5084_Entity_ID"), ConfigFileManager.getProperty("Bid_Price9_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot9_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("CA4074_5084_Entity_ID"), ConfigFileManager.getProperty("Bid_Price10_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot10_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("CA4074_5084_Entity_ID"), ConfigFileManager.getProperty("Bid_Price11_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot11_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("CA4074_5084_Entity_ID"), ConfigFileManager.getProperty("Bid_Price12_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot12_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
			
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE9_API");
		API_Common_Endpoints.getLiveEvents(A56.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A56.addBid(System.getProperty("QC4087_5104_Entity_ID"), ConfigFileManager.getProperty("Bid_Price13_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot13_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("QC4087_5104_Entity_ID"), ConfigFileManager.getProperty("Bid_Price14_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot14_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("QC4087_5104_Entity_ID"), ConfigFileManager.getProperty("Bid_Price15_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot15_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("QC4087_5104_Entity_ID"), ConfigFileManager.getProperty("Bid_Price16_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot16_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);

		A56.addBid(System.getProperty("QC4093_5116_Entity_ID"), ConfigFileManager.getProperty("Bid_Price17_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot17_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("QC4093_5116_Entity_ID"), ConfigFileManager.getProperty("Bid_Price18_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot18_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("QC4093_5116_Entity_ID"), ConfigFileManager.getProperty("Bid_Price19_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot19_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A56.addBid(System.getProperty("QC4093_5116_Entity_ID"), ConfigFileManager.getProperty("Bid_Price20_Current_PE9"), ConfigFileManager.getProperty("Bid_Lot20_Current_PE9"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		A56.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test(priority = 10)
	public void A57() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A57.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A57 create successfully");

		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A57.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A57.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName1_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName1_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE10_API");
		API_Common_Endpoints.getLiveEvents(A57.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A57.addBid(System.getProperty("CA4063_5062_Entity_ID"), ConfigFileManager.getProperty("Bid_Price_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("CA4063_5062_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("CA4063_5062_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("CA4063_5062_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A57.addBid(System.getProperty("CA4069_5074_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("CA4069_5074_Entity_ID"), ConfigFileManager.getProperty("Bid_Price6_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot6_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("CA4069_5074_Entity_ID"), ConfigFileManager.getProperty("Bid_Price7_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot7_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("CA4069_5074_Entity_ID"), ConfigFileManager.getProperty("Bid_Price8_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot8_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		A57.addBid(System.getProperty("CA4075_5086_Entity_ID"), ConfigFileManager.getProperty("Bid_Price9_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot9_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("CA4075_5086_Entity_ID"), ConfigFileManager.getProperty("Bid_Price10_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot10_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("CA4075_5086_Entity_ID"), ConfigFileManager.getProperty("Bid_Price11_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot11_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("CA4075_5086_Entity_ID"), ConfigFileManager.getProperty("Bid_Price12_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot12_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
			
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_USerName2_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_USerName2_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE10_API");
		API_Common_Endpoints.getLiveEvents(A57.randomEventName);
		API_Common_Endpoints.getVintages();
	
		A57.addBid(System.getProperty("QC4088_5106_Entity_ID"), ConfigFileManager.getProperty("Bid_Price13_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot13_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("QC4088_5106_Entity_ID"), ConfigFileManager.getProperty("Bid_Price14_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot14_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("QC4088_5106_Entity_ID"), ConfigFileManager.getProperty("Bid_Price15_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot15_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("QC4088_5106_Entity_ID"), ConfigFileManager.getProperty("Bid_Price16_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot16_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);

		A57.addBid(System.getProperty("QC4094_5118_Entity_ID"), ConfigFileManager.getProperty("Bid_Price17_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot17_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("QC4094_5118_Entity_ID"), ConfigFileManager.getProperty("Bid_Price18_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot18_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("QC4094_5118_Entity_ID"), ConfigFileManager.getProperty("Bid_Price19_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot19_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A57.addBid(System.getProperty("QC4094_5118_Entity_ID"), ConfigFileManager.getProperty("Bid_Price20_Current_PE10"), ConfigFileManager.getProperty("Bid_Lot20_Current_PE10"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		A57.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 11)
	public void A297() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A297.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A297 create successfully");

		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A297.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A297.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName3_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName3_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE11_API");
		API_Common_Endpoints.getLiveEvents(A297.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A297.addBid(System.getProperty("CA3339_4660_Entity_ID"), ConfigFileManager.getProperty("Bid_Price1_Current_PE11"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE11"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A297.addBid(System.getProperty("CA3340_4662_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE11"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE11"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A297.addBid(System.getProperty("CA3341_4664_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE11"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE11"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
			
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName4_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName4_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE11_API");
		API_Common_Endpoints.getLiveEvents(A297.randomEventName);
		API_Common_Endpoints.getVintages();
	
		A297.addBid(System.getProperty("QC3796_4241_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE11"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE11"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A297.addBid(System.getProperty("QC3797_4243_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE11"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE11"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		A297.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test (priority = 12)
	public void A298() throws InterruptedException {
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		A298.createJointAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A298 create successfully");
		
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A298.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A298.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName3_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName3_PE1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE12_API");
		API_Common_Endpoints.getLiveEvents(A298.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A298.addBid(System.getProperty("CA3339_4660_Entity_ID"), ConfigFileManager.getProperty("Bid_Price1_Current_PE12"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE12"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A298.addBid(System.getProperty("CA3340_4662_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE12"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE12"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A298.addBid(System.getProperty("CA3341_4664_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE12"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE12"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
			
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName5_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName5_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE12_API");
		API_Common_Endpoints.getLiveEvents(A298.randomEventName);
		API_Common_Endpoints.getVintages();
	
		A298.addBid(System.getProperty("QC3796_4241_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE12"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE12"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.AR_UserName6_PE1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.AR_UserName6_PE1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE12_API");
		API_Common_Endpoints.getLiveEvents(A298.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A298.addBid(System.getProperty("QC3797_4243_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE12"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE12"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		A298.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(15000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(20000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_ca1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_ca1_MFAKey);//CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		user_LogIn.logInUser(UsersAndMFASecreteKey.Sponsor_qc1,UsersAndMFASecreteKey.password, UsersAndMFASecreteKey.Sponsor_qc1_MFAKey);//QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
}