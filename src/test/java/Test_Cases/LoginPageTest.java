package Test_Cases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import TestBase.BaseTest;

public class LoginPageTest extends BaseTest {
	LoginPage logInPage;

	public LoginPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		logInPage = new LoginPage();
	}

	@Test
	public void validLoginTest() {
		// Log.info("Trying to logging into the application.");
		// logging into application
		logInPage.getUrl();
		logInPage.enterUserName(BaseTest.username);
		logInPage.enterPassword(BaseTest.password);
		logInPage.clickSignIn();
		// verify login successful
		assertTrue(logInPage.verifyLogout());

	}

	@Test
	public void invalidUserName_ValidPassword() {
		// Log.info("Trying to logging into the application.");
		// logging into application
		logInPage.getUrl();
		logInPage.enterUserName("");
		logInPage.enterPassword(BaseTest.password);
		logInPage.clickSignIn();
		// verify login successful
		String expected = "Your username is invalid!";
		String actual = logInPage.readMessage();
		assertTrue(actual.contains(expected));
	}

	@Test
	public void validUserName_inValidPassword() {
		// Log.info("Trying to logging into the application.");
		// logging into application
		logInPage.getUrl();
		logInPage.enterUserName(BaseTest.username);
		logInPage.enterPassword("");
		logInPage.clickSignIn();
		// verify login successful
		String expected = "Your password is invalid!";
		String actual = logInPage.readMessage();
		assertTrue(actual.contains(expected));
	}
}
