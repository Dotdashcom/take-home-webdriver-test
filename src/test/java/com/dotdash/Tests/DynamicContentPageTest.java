package com.dotdash.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.DynamicContentPage;
import com.dotdash.Pages.InternetPage;

public class DynamicContentPageTest extends BaseClass {
	InternetPage internet;
	DynamicContentPage dynamicContent;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
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
