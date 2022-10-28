package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.MultipleWindowsPage;
import com.internet.pages.NewWindowPage;
import com.internet.pages.TheInternetPage;

public class NewWindowPageTest extends Baseclass {
	TheInternetPage internet;
	MultipleWindowsPage windows;
	NewWindowPage newwindow;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		windows = internet.clickWindows();
		newwindow = windows.clickLink();

	}

	@Test
	public void verifyNewTabTest() {
		Assert.assertEquals(newwindow.getTextHeader(), "New Window");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
