package user;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import API_Base_Classes.BaseClass;
import API_Base_Classes.existingUser_LogIn;
import Event_Creation.A278;
import Event_Creation.A45;
import Event_Creation.A48;
import Event_Creation.R317;
import Event_Creation.R319;
import Event_Creation.R325;
import Utilities.MyListeners;
import api_Common_Utilities.API_Common_Endpoints;
import api_Common_Utilities.ConfigFileManager;
@Listeners(Utilities.MyListeners.class)
public class Sample extends BaseClass{

	@Test (priority = 1)
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
	
	@Test (priority = 2)
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

	@Test (priority = 3)
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

	@Test(priority = 4)
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

	@Test(priority = 5)
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

	@Test(priority = 6)
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