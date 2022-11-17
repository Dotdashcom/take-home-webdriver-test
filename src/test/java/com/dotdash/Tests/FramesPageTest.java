package com.dotdash.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.FramePage;
import com.dotdash.Pages.InternetPage;

public class FramesPageTest extends BaseClass {
	InternetPage internet;
	FramePage frames;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
		frames = internet.clickFrames();
	}



	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
