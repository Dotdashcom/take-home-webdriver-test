package com.internet.tests;

//import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.AccountLoginPage;
import com.internet.pages.SecurePage;
import com.internet.pages.InternetPage;
import com.internet.utils.Utils;

public class AccountLoginPageTest extends BaseClass {
	InternetPage internet;
	AccountLoginPage login;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);

		login = internet.clickformAuthentication();

	}

	@Test
	public void loginSuccess() {
		login.enterUsername(username);
		login.enterPassword(password);
		SecurePage secure = login.clickSubmitBtn();
		Assert.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "You logged into a secure area!");

	}

	@Test
	public void loginFailureInvalidCredentials() {
		login.enterUsername(Utils.generateRandomInput());
		login.enterPassword(Utils.generateRandomInput());
		SecurePage secure = login.clickSubmitBtn();
		Assert.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "Your username is invalid!");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}