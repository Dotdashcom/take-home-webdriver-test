package com.qa.dotdash.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.HomePage;
import com.qa.dotdash.pages.MultipleWindowsPage;

public class MultipleWindowsPageTest extends BaseClass {
	HomePage homePage;
	MultipleWindowsPage windows;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		windows = homePage.clickWindows();

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
