package com.dotdash.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.InternetPage;
import com.dotdash.Pages.LoginPage;
import com.dotdash.Pages.SecurePage;

public class LoginPageTest extends BaseClass {
	InternetPage internet;
	LoginPage login;

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
		AssertJUnit.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "You logged into a secure area!");

	}

	@Test
	public void loginFailureInvalidCredentials() {
		login.enterUsername(new Random(3).toString());
		login.enterPassword(password);
		SecurePage secure = login.clickSubmitBtn();
		AssertJUnit.assertEquals(secure.getMessageText().replaceAll("×", "").trim(), "Your username is invalid!");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
