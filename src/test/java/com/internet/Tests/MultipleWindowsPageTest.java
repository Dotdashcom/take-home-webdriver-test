package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.MultipleWindowsPage;
import com.internet.pages.TheInternetPage;

public class MultipleWindowsPageTest extends Baseclass {
	TheInternetPage internet;
	MultipleWindowsPage windows;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		windows = internet.clickWindows();

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
