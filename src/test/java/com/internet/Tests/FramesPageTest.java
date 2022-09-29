package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.FloatingMenuPage;
import com.internet.pages.FramesPage;
import com.internet.pages.TheInternetPage;

public class FramesPageTest extends Baseclass {
	TheInternetPage internet;
	FramesPage frames;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		frames = internet.clickFrames();
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
