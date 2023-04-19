package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.DynamicContentPage;
import com.qa.dotdash.pages.HomePage;

public class DynamicContentPageTest extends BaseClass {
	HomePage homePage;
	DynamicContentPage dynamicContent;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
			
		dynamicContent = homePage.clickDynamicContent();
	}

	@Test(invocationCount = 3)
	public void textChangedAfterRefreshTest() {
		Assert.assertNotEquals(dynamicContent.getText(), dynamicContent.getTextAfterRefresh());
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
