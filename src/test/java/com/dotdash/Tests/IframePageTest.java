package com.dotdash.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.FramePage;
import com.dotdash.Pages.IframePage;
import com.dotdash.Pages.InternetPage;

public class IframePageTest extends BaseClass {
	InternetPage internet;
	FramePage frames;
	IframePage iframe;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
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
