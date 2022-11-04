package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.FloatingMenuPage;
import com.Dotdashcom.Pages.HomePage;

public class FloatingMenuPageTest extends TestBase {
	HomePage homePage;
	FloatingMenuPage floatingMenuPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		floatingMenuPage = homePage.clickFloatingMenu();
	}

	@Test
	public void floatingMenuDisplayedScrollTest() {
		floatingMenuPage.scrollToBottom();
		Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
