package com.dotdash.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.InternetPage;
import com.dotdash.Pages.MultipleWindowsPage;
import com.dotdash.Pages.NewWindowPage;

public class NewWindowPageTest extends BaseClass {
	InternetPage internet;
	MultipleWindowsPage windows;
	NewWindowPage newwindow;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
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
