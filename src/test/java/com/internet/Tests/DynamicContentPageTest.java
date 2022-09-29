package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.DropDownPage;
import com.internet.pages.DynamicContentPage;
import com.internet.pages.TheInternetPage;

public class DynamicContentPageTest extends Baseclass {
	TheInternetPage internet;
	DynamicContentPage dynamicContent;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		dynamicContent = internet.clickDynamicContent();
	}

	@Test(invocationCount = 3)
	public void textChangedAfterRefreshTest() {
		Assert.assertNotEquals(dynamicContent.getTextOfContent2(), dynamicContent.getTextContent2AfterRefresh());
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
