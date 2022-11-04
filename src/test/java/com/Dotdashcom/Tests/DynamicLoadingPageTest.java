package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.DynamicLoadingPage;
import com.Dotdashcom.Pages.HomePage;

public class DynamicLoadingPageTest extends TestBase {
	HomePage homePage;
	DynamicLoadingPage dynamicLoadingPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		dynamicLoadingPage = homePage.clickDynamicLoading();
	}
	
	@Test
	public void verifyHeaderAppearTest() {
		dynamicLoadingPage.clickstartBtn();
		Assert.assertEquals(dynamicLoadingPage.getText(), "Hello World!");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
