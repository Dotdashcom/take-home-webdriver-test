package com.dotdash.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.DynamicPageLoading;
import com.dotdash.Pages.InternetPage;

public class DynamicPageLoadingTest extends BaseClass {
	InternetPage internet;
	DynamicPageLoading dynamicLoading;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
		dynamicLoading = internet.clickDynamicLoading();
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
