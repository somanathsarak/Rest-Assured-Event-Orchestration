package prescribedEventTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import API_Base_Classes.BaseClass;
import API_Base_Classes.existingUser_LogIn;
import Event_Creation.A218;
import Event_Creation.A278;
import Event_Creation.A297;
import Event_Creation.A298;
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
import Event_Creation.R317;
import Event_Creation.R319;
import Event_Creation.R325;
import Event_Creation.R69;
import Event_Creation.R70;
import Event_Creation.R71;
import Event_Creation.R72;
import Event_Creation.R73;
import Event_Creation.R74;
import Event_Creation.R76;
import Utilities.MyListeners;
import api_Common_Utilities.API_Common_Endpoints;
import api_Common_Utilities.ConfigFileManager;
@Listeners(Utilities.MyListeners.class)

public class PrescribedEvent extends BaseClass{

	@Test (priority = 1)
	public void A42() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Event Approved by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A42.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A42.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by second Sponsor");
		Thread.sleep(120000);
		
		existingUser_LogIn.logInUser("AR_USerName1_PE1_API", "APIPassWord");
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
		
		existingUser_LogIn.logInUser("AR_USerName2_PE1_API", "APIPassWord");
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
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A42.randomEventName);
		A42.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A42.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 2)
	public void A45() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Event Approved by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A45.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A45.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by Second Sponsor");
		Thread.sleep(120000);

		existingUser_LogIn.logInUser("AR_USerName1_PE2_API", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE2_API");
		API_Common_Endpoints.getLiveEvents(A45.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A45.addBid(System.getProperty("CA4001_4954_Entity_ID"), ConfigFileManager.getProperty("Bid_Price_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("CA4001_4954_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("CA4001_4954_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A45.addBid(System.getProperty("CA4001_4954_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE2"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE2"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		existingUser_LogIn.logInUser("AR_USerName2_PE2_API", "APIPassWord");
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
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A45.randomEventName);
		A45.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A45.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test (priority = 3)
	public void A46() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Event Approved by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A46.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A46.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by Second Sponsor");
		Thread.sleep(120000);
		
		existingUser_LogIn.logInUser("AR_USerName1_PE3_API", "APIPassWord");
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
	
		existingUser_LogIn.logInUser("AR_USerName2_PE3_API", "APIPassWord");
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
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A46.randomEventName);
		A46.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A46.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 4)
	public void A47() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A47.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A47.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Fx rate added by Second Sponsor");
		Thread.sleep(120000);
		
		existingUser_LogIn.logInUser("AR_USerName1_PE4", "APIPassWord");
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
	
		existingUser_LogIn.logInUser("AR_USerName2_PE4", "APIPassWord");
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
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A47.randomEventName);
		A47.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A47.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test (priority = 5)
	public void A48() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A48.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A48.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		Thread.sleep(120000);
		
		existingUser_LogIn.logInUser("AR_USerName1_PE5", "APIPassWord");
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
	
		existingUser_LogIn.logInUser("AR_USerName2_PE5", "APIPassWord");
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
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A48.randomEventName);
		A48.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A48.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 6)
	public void A49() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A49.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A49.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(120000);
		
		existingUser_LogIn.logInUser("AR_USerName1_PE6", "APIPassWord");
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
	
		existingUser_LogIn.logInUser("AR_USerName2_PE6", "APIPassWord");
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
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A49.randomEventName);
		A49.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A49.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 7)
	public void A50() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A50.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A50.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName1_PE7", "APIPassWord");
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
	
		existingUser_LogIn.logInUser("AR_USerName2_PE7", "APIPassWord");
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
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A50.randomEventName);
		A50.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A50.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test (priority = 8)
	public void A51() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A51.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A51.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName1_PE8", "APIPassWord");
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
	
		existingUser_LogIn.logInUser("AR_USerName2_PE8", "APIPassWord");
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
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A51.randomEventName);
		A51.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A51.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 9)
	public void A56() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A56.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A56.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName1_PE9", "APIPassWord");
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
			
		existingUser_LogIn.logInUser("AR_USerName2_PE9", "APIPassWord");
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
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A56.randomEventName);
		A56.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A56.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test(priority = 10)
	public void A57() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A57.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A57.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName1_PE10", "APIPassWord");
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
			
		existingUser_LogIn.logInUser("AR_USerName2_PE10", "APIPassWord");
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
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A57.randomEventName);
		A57.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A57.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test (priority = 11)
	public void A297() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A297.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A297.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName1_PE11", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE11_API");
		API_Common_Endpoints.getLiveEvents(A297.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A297.addBid(System.getProperty("CA3339_4660_Entity_ID"), ConfigFileManager.getProperty("Bid_Price1_Current_PE11"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE11"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A297.addBid(System.getProperty("CA3340_4662_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE11"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE11"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A297.addBid(System.getProperty("CA3341_4664_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE11"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE11"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
			
		existingUser_LogIn.logInUser("AR_USerName2_PE11", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE11_API");
		API_Common_Endpoints.getLiveEvents(A297.randomEventName);
		API_Common_Endpoints.getVintages();
	
		A297.addBid(System.getProperty("QC3796_4241_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE11"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE11"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A297.addBid(System.getProperty("QC3797_4243_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE11"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE11"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A297.randomEventName);
		A297.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A297.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test (priority = 12)
	public void A298() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");
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
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A298.addFxRateByCASponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.getLinkedJurisdiction();
		A298.addFxrateByQCSponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Add Fx rate by Second Sponsor");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName1_PE12", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE12_API");
		API_Common_Endpoints.getLiveEvents(A298.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A298.addBid(System.getProperty("CA3339_4660_Entity_ID"), ConfigFileManager.getProperty("Bid_Price1_Current_PE12"), ConfigFileManager.getProperty("Bid_Lot1_Current_PE12"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A298.addBid(System.getProperty("CA3340_4662_Entity_ID"), ConfigFileManager.getProperty("Bid_Price2_Current_PE12"), ConfigFileManager.getProperty("Bid_Lot2_Current_PE12"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		A298.addBid(System.getProperty("CA3341_4664_Entity_ID"), ConfigFileManager.getProperty("Bid_Price3_Current_PE12"), ConfigFileManager.getProperty("Bid_Lot3_Current_PE12"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
			
		existingUser_LogIn.logInUser("AR_USerName2_PE12_1", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE12_API");
		API_Common_Endpoints.getLiveEvents(A298.randomEventName);
		API_Common_Endpoints.getVintages();
	
		A298.addBid(System.getProperty("QC3796_4241_Entity_ID"), ConfigFileManager.getProperty("Bid_Price4_Current_PE12"), ConfigFileManager.getProperty("Bid_Lot4_Current_PE12"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		
		existingUser_LogIn.logInUser("AR_USerName2_PE12_2", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_PE12_API");
		API_Common_Endpoints.getLiveEvents(A298.randomEventName);
		API_Common_Endpoints.getVintages();
		
		A298.addBid(System.getProperty("QC3797_4243_Entity_ID"), ConfigFileManager.getProperty("Bid_Price5_Current_PE12"), ConfigFileManager.getProperty("Bid_Lot5_Current_PE12"), System.getProperty("currentvintageType"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A298.randomEventName);
		A298.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A298.randomEventName);
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
	
	@Test (priority = 14)
	public void R70() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R70.createSBMAEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event R70 create successfully");
		
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R70");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName_SBMA2", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA2_API");
		API_Common_Endpoints.getLiveEvents(R70.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R70.addBid(System.getProperty("QC4085_5100_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA2"), ConfigFileManager.getProperty("Bid_Lot__SBMA2_1"), System.getProperty("CA_allowanceTierOneID"), API_Common_Endpoints.arEventId);
		R70.addBid(System.getProperty("QC4091_5112_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryA_SBMA2"), ConfigFileManager.getProperty("Bid_Lot__SBMA2_2"), System.getProperty("CA_allowanceTierOneID"), API_Common_Endpoints.arEventId);
		R70.addBid(System.getProperty("QC4096_5122_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryB_SBMA2"), ConfigFileManager.getProperty("Bid_Lot__SBMA2_3"), System.getProperty("CA_allowanceTierTwoID"), API_Common_Endpoints.arEventId);
		R70.addBid(System.getProperty("QC4097_5124_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA2"), ConfigFileManager.getProperty("Bid_Lot__SBMA2_4"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R70.addBid(System.getProperty("QC4098_5126_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA2"), ConfigFileManager.getProperty("Bid_Lot__SBMA2_5"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		R70.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(35000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R70.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 15)
	public void R71() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R71.createSBMAEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event R71 create successfully");
		
		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R71");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName_SBMA3", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA3_API");
		API_Common_Endpoints.getLiveEvents(R71.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R71.addBid(System.getProperty("QC4085_5100_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA3"), ConfigFileManager.getProperty("Bid_Lot__SBMA3_1"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R71.addBid(System.getProperty("QC4091_5112_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA3"), ConfigFileManager.getProperty("Bid_Lot__SBMA3_2"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R71.addBid(System.getProperty("QC4096_5122_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA3"), ConfigFileManager.getProperty("Bid_Lot__SBMA3_3"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R71.addBid(System.getProperty("QC4097_5124_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA3"), ConfigFileManager.getProperty("Bid_Lot__SBMA3_4"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R71.addBid(System.getProperty("QC4098_5126_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA3"), ConfigFileManager.getProperty("Bid_Lot__SBMA3_5"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		R71.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(20000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R71.randomEventName);
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

	@Test(priority = 17)
	public void R73() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R73.createSBMAEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event R73 create successfully");
		
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R73");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName_SBMA5", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA5_API");
		API_Common_Endpoints.getLiveEvents(R73.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R73.addBid(System.getProperty("QC4085_5100_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA5"), ConfigFileManager.getProperty("Bid_Lot__SBMA5_1"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R73.addBid(System.getProperty("QC4091_5112_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA5"), ConfigFileManager.getProperty("Bid_Lot__SBMA5_2"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R73.addBid(System.getProperty("QC4096_5122_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA5"), ConfigFileManager.getProperty("Bid_Lot__SBMA5_3"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R73.addBid(System.getProperty("QC4097_5124_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA5"), ConfigFileManager.getProperty("Bid_Lot__SBMA5_4"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R73.addBid(System.getProperty("QC4098_5126_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA5"), ConfigFileManager.getProperty("Bid_Lot__SBMA5_5"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		R73.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(25000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R73.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test(priority = 18)
	public void R74() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R74.createSBMAEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event R74 create successfully");
		
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R74");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName_SBMA6", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA6_API");
		API_Common_Endpoints.getLiveEvents(R74.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R74.addBid(System.getProperty("QC4085_5100_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA6"), ConfigFileManager.getProperty("Bid_Lot__SBMA6_1"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R74.addBid(System.getProperty("QC4091_5112_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA6"), ConfigFileManager.getProperty("Bid_Lot__SBMA6_2"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R74.addBid(System.getProperty("QC4096_5122_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA6"), ConfigFileManager.getProperty("Bid_Lot__SBMA6_3"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R74.addBid(System.getProperty("QC4097_5124_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA6"), ConfigFileManager.getProperty("Bid_Lot__SBMA6_4"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R74.addBid(System.getProperty("QC4098_5126_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA6"), ConfigFileManager.getProperty("Bid_Lot__SBMA6_5"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		R74.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(25000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R74.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test(priority = 19)
	public void R76() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R76.createSBMAEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event R76 create successfully");
		
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		API_Common_Endpoints.uploadFIle("R76");
		Thread.sleep(70000);
		
		existingUser_LogIn.logInUser("AR_USerName_SBMA7", "APIPassWord");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_SBMA7_API");
		API_Common_Endpoints.getLiveEvents(R76.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R76.addBid(System.getProperty("QC4085_5100_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA7"), ConfigFileManager.getProperty("Bid_Lot__SBMA7_1"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R76.addBid(System.getProperty("QC4091_5112_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA7"), ConfigFileManager.getProperty("Bid_Lot__SBMA7_2"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R76.addBid(System.getProperty("QC4096_5122_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA7"), ConfigFileManager.getProperty("Bid_Lot__SBMA7_3"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R76.addBid(System.getProperty("QC4097_5124_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA7"), ConfigFileManager.getProperty("Bid_Lot__SBMA7_4"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		R76.addBid(System.getProperty("QC4098_5126_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_CategoryC_SBMA7"), ConfigFileManager.getProperty("Bid_Lot__SBMA7_5"), System.getProperty("CA_allowanceTierThreeID"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		R76.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		Thread.sleep(50000);
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(25000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();
		
		existingUser_LogIn.logInUser("APIUserNameQC1", "APIPassWord");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameQC2", "APIPassWord");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R76.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test (priority = 20)
	public void R317() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");//1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.fetchTiresData();
		API_Common_Endpoints.getLinkedJurisdiction();
		R317.createReserveEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event R317 create successfully");
		
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameCA2", "APIPassWord");//2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(30000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		Thread.sleep(55000);
		
		existingUser_LogIn.logInUser("AR_USerName1_RE1Ca", "APIPassWord");//AR
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.jurisdictionListFilter();
		API_Common_Endpoints.getAllEntities("Entity_RE1Ca_API");
		API_Common_Endpoints.getLiveEvents(R317.randomEventName);
		API_Common_Endpoints.getTierId();
		
		R317.addBid(System.getProperty("CA3213_4519_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_Tier_two_RE1Ca"), ConfigFileManager.getProperty("Bid_Lot__RE1Ca"), System.getProperty("CA_allowanceTierTwoID"), API_Common_Endpoints.arEventId);
		R317.addBid(System.getProperty("CA3223_4531_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_Tier_one_RE1Ca"), ConfigFileManager.getProperty("Bid_Lot1__RE1Ca"), System.getProperty("CA_allowanceTierOneID"), API_Common_Endpoints.arEventId);
		R317.addBid(System.getProperty("CA3223_4531_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_Tier_two_RE1Ca"), ConfigFileManager.getProperty("Bid_Lot2__RE1Ca"), System.getProperty("CA_allowanceTierTwoID"), API_Common_Endpoints.arEventId);
		R317.addBid(System.getProperty("CA3225_4535_Entity_ID"), ConfigFileManager.getProperty("PriceOffered_Tier_one_RE1Ca"), ConfigFileManager.getProperty("Bid_Lot3__RE1Ca"), System.getProperty("CA_allowanceTierOneID"), API_Common_Endpoints.arEventId);
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(R317.randomEventName);
		R317.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameCA2", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		Thread.sleep(15000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameCA2", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(20000);
		API_Common_Endpoints.calculateReserveSaleAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameCA1", "APIPassWord");// CA
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameCA2", "APIPassWord");// QC
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(R317.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}
	
	@Test(priority = 21)
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

	@Test(priority = 22)
	public void A278() throws InterruptedException {
		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by First Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getJurisdiction();
		API_Common_Endpoints.getAlgorithmData();
		A278.createSingleAuctionEvent();
		MyListeners.getExtentTest().log(Status.PASS, "Event A278 create successfully");

		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		MyListeners.getExtentTest().log(Status.PASS, "Logged in successfully by Second Sponsor");
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Approve event by Second Sponsor");
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(20000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		Thread.sleep(70000);

		existingUser_LogIn.logInUser("AR_USerName1_PEWa2", "APIPassWord");
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
		MyListeners.getExtentTest().log(Status.PASS, "Bid successfully added by Account Representative");
		
		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(10000);
		API_Common_Endpoints.getEventId(A278.randomEventName);
		A278.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();

		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Run algorithm by Second Sponsor");
		Thread.sleep(30000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();

		existingUser_LogIn.logInUser("APIUserNameWA1", "APIPassWord");// 1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by First Sponsor");
		existingUser_LogIn.logInUser("APIUserNameWA2", "APIPassWord");// 2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(A278.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		MyListeners.getExtentTest().log(Status.PASS, "Certified Event by Second Sponsor");
	}

	@Test(priority = 23)
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

	@Test(priority = 24)
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

}