package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.FloatingMenuPage;
import com.qa.dotdash.pages.HomePage;

public class FloatingMenuPageTest extends BaseClass {
	HomePage homePage;
	FloatingMenuPage floating;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		floating = homePage.clickFloatingMenu();
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
