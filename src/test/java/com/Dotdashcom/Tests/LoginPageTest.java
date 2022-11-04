package com.Dotdashcom.Tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.HomePage;
import com.Dotdashcom.Pages.LoginPage;
import com.Dotdashcom.Pages.SecurePage;



public class LoginPageTest extends TestBase {
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
		login.enterUsername(username);
		login.enterPassword(password);
		SecurePage securePage = login.clickSubmitBtn();
		Assert.assertEquals(securePage.getMessageText().replaceAll("×", "").trim(), "You logged into a secure area!");

	}

	@Test
	public void loginFailureInvalidUserNameTest() {
		login.enterUsername(new Random(3).toString());
		login.enterPassword(password);
		SecurePage securePage = login.clickSubmitBtn();
		Assert.assertEquals(securePage.getMessageText().replaceAll("×", "").trim(), "Your username is invalid!");

	}
//
	@Test
	public void loginFailureInvalidPasswordTest() {
		login.enterUsername(username);
		login.enterPassword(new Random(3).toString());
		SecurePage securePage = login.clickSubmitBtn();
		Assert.assertEquals(securePage.getMessageText().replaceAll("×", "").trim(), "Your password is invalid!");

	}

	@Test
	public void loginFailureNoInputTest() {
		SecurePage securePage = login.clickSubmitBtn();
		Assert.assertEquals(securePage.getMessageText().replaceAll("×", "").trim(), "Your username is invalid!");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
