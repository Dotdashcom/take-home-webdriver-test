package com.dotdash.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.InternetPage;
import com.dotdash.Pages.JavascriptErrorPage;

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
