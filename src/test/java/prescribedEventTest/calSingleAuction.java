package prescribedEventTest;

import org.testng.annotations.Test;
import API_Base_Classes.existingUser_LogIn;
import Event_Creation.CAL_Single_Auction;
import api_Common_Utilities.API_Common_Endpoints;

public class calSingleAuction {

	@Test
	public void singleAuctionEvent() throws InterruptedException {
		existingUser_LogIn.logInUser("usernick@yopmail.com", "VGVzdEAxMjM0");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.fetchEventTypeData();
		API_Common_Endpoints.getVintageYear();
		API_Common_Endpoints.getVintageData();
		API_Common_Endpoints.getAlgorithmData();
		API_Common_Endpoints.getLinkedJurisdiction();
		CAL_Single_Auction.createSingleAuctionEvent();
		API_Common_Endpoints.getEventId(CAL_Single_Auction.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("usernick1@yopmail.com", "VGVzdEAxMjM0");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(CAL_Single_Auction.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		API_Common_Endpoints.getAPIList();
		API_Common_Endpoints.executeGetQualifiedBidderAPI();
		Thread.sleep(20000);
		API_Common_Endpoints.executeGetBidLimitationsAPI();
		
		existingUser_LogIn.logInUser("asmith@demo.citssdev.com", "VGVzdEAxMjM0");//AR
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(65000);
		API_Common_Endpoints.jurisdictionListFilter();
		CAL_Single_Auction.getAllEntities();
		CAL_Single_Auction.getLiveEvents(CAL_Single_Auction.randomEventName);
		CAL_Single_Auction.getVintages();
		CAL_Single_Auction.addFirstBid();
		
		existingUser_LogIn.logInUser("usernick@yopmail.com", "VGVzdEAxMjM0");//1
		API_Common_Endpoints.getUserByToken();
		Thread.sleep(55000);
		API_Common_Endpoints.getEventId(CAL_Single_Auction.randomEventName);
		CAL_Single_Auction.editEventbySponsor();
		API_Common_Endpoints.approveEventBySponsor();
		existingUser_LogIn.logInUser("usernick1@yopmail.com", "VGVzdEAxMjM0");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(CAL_Single_Auction.randomEventName);
		API_Common_Endpoints.approveEventBySponsor();
		
		existingUser_LogIn.logInUser("usernick@yopmail.com", "VGVzdEAxMjM0");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(CAL_Single_Auction.randomEventName);
		Thread.sleep(50000);
		API_Common_Endpoints.runAlgorithmBySponsor();
		existingUser_LogIn.logInUser("usernick1@yopmail.com", "VGVzdEAxMjM0");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(CAL_Single_Auction.randomEventName);
		API_Common_Endpoints.runAlgorithmBySponsor();
		Thread.sleep(35000);
		API_Common_Endpoints.calculateAuctionAlgorithm();
		Thread.sleep(10000);
		API_Common_Endpoints.checkAlgorithmExecutionStatus();
		
		existingUser_LogIn.logInUser("usernick@yopmail.com", "VGVzdEAxMjM0");//1
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(CAL_Single_Auction.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
		existingUser_LogIn.logInUser("usernick1@yopmail.com", "VGVzdEAxMjM0");//2
		API_Common_Endpoints.getUserByToken();
		API_Common_Endpoints.getEventId(CAL_Single_Auction.randomEventName);
		API_Common_Endpoints.setCertificationBySponsor();
	}
}