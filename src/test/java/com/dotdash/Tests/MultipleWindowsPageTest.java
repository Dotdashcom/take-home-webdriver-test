package com.dotdash.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.InternetPage;
import com.dotdash.Pages.MultipleWindowsPage;

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
