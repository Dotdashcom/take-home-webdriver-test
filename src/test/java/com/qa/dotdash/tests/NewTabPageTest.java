package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.HomePage;
import com.qa.dotdash.pages.MultipleWindowsPage;
import com.qa.dotdash.pages.NewWindowPage;

public class NewTabPageTest extends BaseClass {
	HomePage homePage;
	MultipleWindowsPage windows;
	NewWindowPage newwindow;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		windows = homePage.clickWindows();
		newwindow = windows.clickLink();

	}

	@Test
	public void verifyNewTabTest() {
		Assert.assertEquals(newwindow.getTextHeader(), "New Window");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
