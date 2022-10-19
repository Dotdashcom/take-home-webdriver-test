package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.FramesPage;
import com.internet.pages.HoversPage;
import com.internet.pages.IframePage;
import com.internet.pages.TheInternetPage;

public class HoversPageTest extends Baseclass {
	TheInternetPage internet;
	HoversPage hovers;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		hovers = internet.clickHovers();
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
