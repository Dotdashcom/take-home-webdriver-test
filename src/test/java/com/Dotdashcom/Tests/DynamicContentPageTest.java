package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.DynamicContentPage;
import com.Dotdashcom.Pages.HomePage;

public class DynamicContentPageTest extends TestBase {
	HomePage homePage;
	DynamicContentPage dynamicContentPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		dynamicContentPage = homePage.clickDynamicContent();
	}

	@Test(invocationCount = 2)
	public void textChangedAfterRefreshTest() {
		Assert.assertNotEquals(dynamicContentPage.getTextOfPara3(), dynamicContentPage.getTextPara3AfterRefresh());
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
