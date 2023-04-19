package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.FramesPage;
import com.qa.dotdash.pages.HomePage;
import com.qa.dotdash.pages.IframePage;

public class IFramePageTest extends BaseClass {
	HomePage homePage;
	FramesPage frames;
	IframePage iframe;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage= new HomePage(webdriver, true);
		frames = homePage.clickFrames();
		iframe = frames.clickOniFrame();

	}

	@Test
	public void verifyFrameText() {
		Assert.assertEquals(iframe.getTextIframe(), "Your content goes here.");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
