package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.JavascriptAlertPage;
import com.internet.pages.JavascriptErrorPage;
import com.internet.pages.TheInternetPage;

public class JavaScriptErrorPageTest extends Baseclass {
	TheInternetPage internet;
	JavascriptErrorPage error;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		error = internet.clickerror();

	}

	@Test
	public void verifyErrorMessageTest() {
		Assert.assertEquals(error.verifyErrorContains("Cannot read properties of undefined (reading 'xyz')"), true);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
