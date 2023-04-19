package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.HomePage;
import com.qa.dotdash.pages.JavascriptErrorPage;

public class JavaScriptErrorPageTest extends BaseClass {
	HomePage homePage;
	JavascriptErrorPage error;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		error = homePage.clickerror();

	}

	@Test
	public void verifyErrorMessageTest() {
		Assert.assertEquals(error.verifyErrorText("Cannot read properties of undefined (reading 'xyz')"), true);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
