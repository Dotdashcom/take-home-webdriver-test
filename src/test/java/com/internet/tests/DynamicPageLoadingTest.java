package com.internet.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.DynamicControlsPage;
import com.internet.pages.DynamicPageLoading;
import com.internet.pages.InternetPage;

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