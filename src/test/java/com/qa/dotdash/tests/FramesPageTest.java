package com.qa.dotdash.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.FramesPage;
import com.qa.dotdash.pages.HomePage;

public class FramesPageTest extends BaseClass {
	HomePage homePage;
	FramesPage frames;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		frames = homePage.clickFrames();
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
