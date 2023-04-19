package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.HomePage;
import com.qa.dotdash.pages.MouseHoversPage;

public class MouseHoversPageTest extends BaseClass {
	HomePage homePage;
	MouseHoversPage hovers;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		hovers = homePage.clickHovers();
	}

	@Test
	public void verifyTextAppearOnHoverImage1Test() {
		hovers.mouseHoverFirstImage();
		Assert.assertEquals(hovers.firstHeaderIsDisplayed(), true);
	}

	@Test
	public void verifyTextAppearOnHoverImage2Test() {
		hovers.mouseHoverSecondImage();
		Assert.assertEquals(hovers.secondHeaderIsDisplayed(), true);
	}

	@Test
	public void verifyTextAppearOnHoverImage3Test() {
		hovers.mouseHoverThirdImage();
		Assert.assertEquals(hovers.thirdHeaderIsDisplayed(), true);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}


