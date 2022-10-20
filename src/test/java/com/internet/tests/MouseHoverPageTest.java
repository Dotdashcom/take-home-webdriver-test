package com.internet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.FramePage;
import com.internet.pages.MouseHoverPage;
import com.internet.pages.IframePage;
import com.internet.pages.InternetPage;

public class MouseHoverPageTest extends BaseClass {
	InternetPage internet;
	MouseHoverPage hovers;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
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