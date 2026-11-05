package API_Base_Classes;

import org.testng.annotations.BeforeMethod;

import api_Common_Utilities.ConfigFileManager;

public class BaseClass {

	@BeforeMethod
	public void setup() {
		ConfigFileManager.readProperties();
	}
}
