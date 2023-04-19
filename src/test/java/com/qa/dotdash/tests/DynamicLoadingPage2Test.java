package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.DynamicLoadPage;
import com.qa.dotdash.pages.DynamicLoadedPage2;
import com.qa.dotdash.pages.HomePage;

public class DynamicLoadingPage2Test extends BaseClass {
	HomePage homePage;
	DynamicLoadPage dynamicLoading;
	DynamicLoadedPage2 loading2;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		dynamicLoading = homePage.clickDynamicLoading();
		loading2 = dynamicLoading.ClickDynamicLoaded2();

	}

	@Test
	public void verifyHeaderAppearTest() {
		loading2.clickStartButton();
		Assert.assertEquals(loading2.getTextHeader(), "Hello World!");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
