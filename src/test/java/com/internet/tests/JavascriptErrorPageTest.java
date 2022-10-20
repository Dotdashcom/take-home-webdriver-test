package com.internet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.JavascriptAlertPage;
import com.internet.pages.JavascriptErrorPage;
import com.internet.pages.InternetPage;

public class JavascriptErrorPageTest extends BaseClass {
	InternetPage internet;
	JavascriptErrorPage error;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
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