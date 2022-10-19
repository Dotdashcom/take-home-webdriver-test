package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.FramesPage;
import com.internet.pages.IframePage;
import com.internet.pages.JavascriptAlertPage;
import com.internet.pages.TheInternetPage;
import com.internet.utils.Utils;

public class JavaScriptAlertPageTest extends Baseclass {
	TheInternetPage internet;
	JavascriptAlertPage script;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
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
