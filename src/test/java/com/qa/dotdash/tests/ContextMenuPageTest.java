package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.ContextMenuPage;
import com.qa.dotdash.pages.HomePage;

public class ContextMenuPageTest extends BaseClass {
	HomePage homePage;
	ContextMenuPage context;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		context = homePage.clickContextMenu();

	}

	@Test
	public void alertTextMatchingTest() {
		context.rightClickContextBox();
		context.alertText();
		Assert.assertEquals(context.alertText(), "You selected a context menu");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
