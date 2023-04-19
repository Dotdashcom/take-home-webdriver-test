package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.HomePage;
import com.qa.dotdash.pages.LoginPage;
import com.qa.dotdash.pages.SecureAreaPage;
import com.qa.dotdash.utils.Utils;

public class LoginPageTest extends BaseClass {
	HomePage homePage;
	LoginPage login;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage= new HomePage(webdriver, true);

		login = homePage.clickformAuthentication();

	}

	@Test
	public void loginSuccessTest() {
		login.inputUsername(username);
		login.inputPassword(password);
		SecureAreaPage secure = login.clickSubmitButton();
		Assert.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "You logged into a secure area!");

	}

	@Test
	public void loginFailureInvalidUsernameTest() {
		login.inputUsername(Utils.generateRandomInput());
		login.inputPassword(password);
		SecureAreaPage secure = login.clickSubmitButton();
		Assert.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "Your username is invalid!");

	}

	@Test
	public void loginFailureInvalidPasswordTest() {
		login.inputUsername(username);
		login.inputPassword(Utils.generateRandomInput());
		SecureAreaPage secure = login.clickSubmitButton();
		Assert.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "Your password is invalid!");

	}

	@Test
	public void loginFailureNoInputTest() {
		SecureAreaPage secure = login.clickSubmitButton();
		Assert.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "Your username is invalid!");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
