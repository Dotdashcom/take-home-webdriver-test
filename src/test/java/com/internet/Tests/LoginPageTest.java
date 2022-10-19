package com.internet.Tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.LoginPage;
import com.internet.pages.SecureAreaPage;
import com.internet.pages.TheInternetPage;
import com.internet.utils.Utils;

public class LoginPageTest extends Baseclass {
	TheInternetPage internet;
	LoginPage login;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);

		login = internet.clickformAuthentication();

	}

	@Test
	public void loginSuccessTest() {
		login.enterUsername(username);
		login.enterPassword(password);
		SecureAreaPage secure = login.clickSubmitBtn();
		Assert.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "You logged into a secure area!");

	}

	@Test
	public void loginFailureInvalidUsernameTest() {
		login.enterUsername(Utils.generateRandomInput());
		login.enterPassword(password);
		SecureAreaPage secure = login.clickSubmitBtn();
		Assert.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "Your username is invalid!");

	}

	@Test
	public void loginFailureInvalidPasswordTest() {
		login.enterUsername(username);
		login.enterPassword(Utils.generateRandomInput());
		SecureAreaPage secure = login.clickSubmitBtn();
		Assert.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "Your password is invalid!");

	}

	@Test
	public void loginFailureNoInputTest() {
		SecureAreaPage secure = login.clickSubmitBtn();
		Assert.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "Your username is invalid!");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
