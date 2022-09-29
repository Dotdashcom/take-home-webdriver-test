package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.DynamicLoadedPage2;
import com.internet.pages.DynamicLoadingPage;
import com.internet.pages.TheInternetPage;

public class DynamicLoadingPage2Test extends Baseclass {
	TheInternetPage internet;
	DynamicLoadingPage dynamicLoading;
	DynamicLoadedPage2 loading2;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
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
