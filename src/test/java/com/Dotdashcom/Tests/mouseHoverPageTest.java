package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.HomePage;
import com.Dotdashcom.Pages.MouseHoverPage;

public class mouseHoverPageTest extends TestBase {
	MouseHoverPage mouseHoverPage;
	HomePage homePage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);

	}

	@Test
	public void hoverTestImageOne() {
		mouseHoverPage = homePage.clickhoverPageBtn();
		mouseHoverPage.mouseHoverFirstImage();
		Assert.assertEquals(mouseHoverPage.IsfirstTestDisplayed(), true);
	}

	@Test
	public void hoverTestImageTwo() {
		mouseHoverPage = homePage.clickhoverPageBtn();
		mouseHoverPage.mouseHoverSecondImage();
		Assert.assertEquals(mouseHoverPage.IsSecondTextDisplayed(), true);
	}

	@Test
	public void hoverTestImageThird() {
		mouseHoverPage = homePage.clickhoverPageBtn();
		mouseHoverPage.mouseHoverThirdImage();
		Assert.assertEquals(mouseHoverPage.IsThirdTextDisplayed(), true);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
