package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.HomePage;
import com.Dotdashcom.Pages.IFramePage;

public class IFramePageTest extends TestBase {
	IFramePage iFramePage;
	HomePage homePage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);

	}

	@Test
	public void frameTest() {
		iFramePage = homePage.clickFrames();
		Assert.assertEquals(iFramePage.getTextIframe(), "Your content goes here.", "Text does not match");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
