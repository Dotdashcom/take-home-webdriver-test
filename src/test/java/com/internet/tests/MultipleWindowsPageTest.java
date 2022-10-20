package com.internet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.MultipleWindowsPage;
import com.internet.pages.InternetPage;

public class MultipleWindowsPageTest extends BaseClass {
	InternetPage internet;
	MultipleWindowsPage windows;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
		windows = internet.clickWindows();

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}