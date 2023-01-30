package tests;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pages.LoginPage;

public class Test1_2_Login extends LoginPage {

	Logger logger = LogManager.getLogger(Test1_2_Login.class);

	String URL = prw.getProperties("baseURL");
	String userName = prw.getProperties("userName");
	String userPass = prw.getProperties("userPass");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/login");
		logger.info("The browser opened and navigated to " + URL + "/login");
	}

	@Test
	void validCredentialsLogin() {
		loginToWebTestLoginPage(userName, userPass);
		assertLoginSuccessfull("Welcome to the Secure Area. When you are done click logout below.");
		logger.info("validCredentialsLogin() Test successfully passed");
	}

	@Test
	void invalidCredentialsLogin() {
		loginToWebTestLoginPage("fakeName", "fakePass");
		assertLoginFailed("Your username is invalid!\n" + "×");
		logger.info("invalidCredentialsLogin() Test successfully passed");
	}
	
	

}
