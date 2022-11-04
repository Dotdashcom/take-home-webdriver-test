package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.HomePage;
import com.Dotdashcom.Pages.JavaScriptAlertsPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

;

public class JavascriptAlertPageTest extends TestBase {
	HomePage homePage;
	JavaScriptAlertsPage javaScriptAlertsPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		javaScriptAlertsPage = homePage.clickalert();

	}

	@Test
	public void verifyAlertMessageTest() {
		javaScriptAlertsPage.clickjsAlertBtn();
		Assert.assertEquals(javaScriptAlertsPage.getjsAlertMessage(), "I am a JS Alert");
	}

	@Test
	public void verifyConfirmAlertMessageTest() {
		String text = javaScriptAlertsPage.getjsAlertMessage();
		javaScriptAlertsPage.confirmJsAccept();
		Assert.assertEquals(text, "I am a JS Confirm");
	}

	@Test
	public void verifyPromptAlertMessageTest() {
		javaScriptAlertsPage.jsPromptsendKeysGetText("Testing");
		Assert.assertEquals(javaScriptAlertsPage.getjsAlertMessage(), "Testing");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
