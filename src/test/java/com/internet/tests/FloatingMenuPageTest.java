package com.internet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.FileUploadPage;
import com.internet.pages.FloatingMenuPage;
import com.internet.pages.InternetPage;

public class FloatingMenuPageTest extends BaseClass {
	InternetPage internet;
	FloatingMenuPage floating;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
		floating = internet.clickFloatingMenu();
	}

	@Test
	public void floatingMenuDisplayedScrollTest() {
		floating.scrollToBottom();
		Assert.assertTrue(floating.isFloatingMenuDisplayed());
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}