package com.internet.Tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.DynamicControlsPage;
import com.internet.pages.DynamicLoadingPage;
import com.internet.pages.TheInternetPage;

public class DynamicLoadingPageTest extends Baseclass {
	TheInternetPage internet;
	DynamicLoadingPage dynamicLoading;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		dynamicLoading = internet.clickDynamicLoading();
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
