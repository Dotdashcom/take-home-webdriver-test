package com.internet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.DynamicPageLoaded;
import com.internet.pages.DynamicPageLoading;
import com.internet.pages.InternetPage;

public class DynamicLoadedPageTest extends BaseClass {
	InternetPage internet;
	DynamicPageLoading dynamicLoading;
	DynamicPageLoaded loading2;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
		dynamicLoading = internet.clickDynamicLoading();
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