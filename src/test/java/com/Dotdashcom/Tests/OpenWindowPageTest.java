package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.HomePage;
import com.Dotdashcom.Pages.OpenNewWindowPage;

public class OpenWindowPageTest extends TestBase {
	HomePage homePage;
	OpenNewWindowPage openNewWindowPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		

	}

	@Test
	public void verifyNewTabTest() {
		homePage.clickWindows();
		Assert.assertEquals(openNewWindowPage.getTextHeader(), "New Window");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
   
