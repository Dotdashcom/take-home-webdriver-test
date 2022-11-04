package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.HomePage;
import com.Dotdashcom.Pages.JavaScriptErrorPage;


public class JavaScriptErrorPageTest extends TestBase {
	HomePage homePage;
	JavaScriptErrorPage javaScriptErrorPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		javaScriptErrorPage = homePage.clickError();

	}

	@Test
	public void verifyErrorMessageTest() {
		Assert.assertEquals(javaScriptErrorPage.verifyError("Cannot read properties of undefined (reading 'xyz')"), true);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}