package com.qa.dotdash.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.DynamicLoadPage;
import com.qa.dotdash.pages.HomePage;

public class DynamicLoadingPageTest extends BaseClass {
	HomePage homePage;
	DynamicLoadPage dynamicLoading;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		dynamicLoading = homePage.clickDynamicLoading();
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}


}
