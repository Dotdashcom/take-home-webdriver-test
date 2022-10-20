package com.internet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.FloatingMenuPage;
import com.internet.pages.FramePage;
import com.internet.pages.InternetPage;

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
