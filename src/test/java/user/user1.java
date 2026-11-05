package user;

import org.testng.annotations.Test;

import API_Base_Classes.existingUser_LogIn;
import api_Common_Utilities.API_Common_Endpoints;
import userCreation.userCreation;

public class user1 {

	@Test
	public void addNewUser() {
		existingUser_LogIn.logInUser("usernick@yopmail.com", "VGVzdEAxMjM0");//CA
		API_Common_Endpoints.getUserByToken();
		userCreation.getAllROles();
		userCreation.checkEmailIsExist();
		userCreation.addUser();
		userCreation.userList();
		userCreation.resendActivationLink();
		userCreation.getSecurityQuestions();
	}
	@Test
	public void activateUser() {
		existingUser_LogIn.logInUser("usernick@yopmail.com", "VGVzdEAxMjM0");//CA
		API_Common_Endpoints.getUserByToken();
		userCreation.userList();
		userCreation.activateUser();
	}
	@Test
	public void setUpCredential() {
		existingUser_LogIn.logInUser("usernick@yopmail.com", "VGVzdEAxMjM0");//CA
		API_Common_Endpoints.getUserByToken();
		userCreation.getAllROles();
		userCreation.checkEmailIsExist();
		userCreation.addUser();
		userCreation.userList();
		userCreation.getSecurityQuestions();
		userCreation.languageId();
		userCreation.setUpCredential();
	}
}