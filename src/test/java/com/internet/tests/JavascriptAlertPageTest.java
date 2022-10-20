package com.internet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.FramePage;
import com.internet.pages.IframePage;
import com.internet.pages.JavascriptAlertPage;
import com.internet.pages.InternetPage;
import com.internet.utils.Utils;

public class JavascriptAlertPageTest extends BaseClass {
	InternetPage internet;
	JavascriptAlertPage script;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
		script = internet.clickalert();

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