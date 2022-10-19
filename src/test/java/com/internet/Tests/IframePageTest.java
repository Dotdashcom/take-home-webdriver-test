package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.FramesPage;
import com.internet.pages.IframePage;
import com.internet.pages.TheInternetPage;

public class IframePageTest extends Baseclass {
	TheInternetPage internet;
	FramesPage frames;
	IframePage iframe;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		frames = internet.clickFrames();
		iframe = frames.clickiFrames();

	}

	@Test
	public void verifyFrameMessageText() {
		Assert.assertEquals(iframe.getTextIframe(), "Your content goes here.");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
