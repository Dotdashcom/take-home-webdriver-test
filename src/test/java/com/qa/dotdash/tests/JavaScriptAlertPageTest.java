package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.HomePage;
import com.qa.dotdash.pages.JavascriptAlertPage;

public class JavaScriptAlertPageTest extends BaseClass {
	HomePage homePage;
	JavascriptAlertPage script;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		script = homePage.clickalert();

	}

	@Test
	public void verifyAlertMessageTest() {
		Assert.assertEquals(script.getjsAlertMessage(), "I am a JS Alert");
	}

	@Test
	public void verifyConfirmAlertMessageTest() {
		String text = script.getjsConfirmMessage();
		script.acceptJsConfirm();
		Assert.assertEquals(text, "I am a JS Confirm");
	}

	@Test
	public void verifyPromptAlertMessageTest() {

		Assert.assertEquals(script.jsPromptsendKeysGetText("Happy"), "Happy");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
