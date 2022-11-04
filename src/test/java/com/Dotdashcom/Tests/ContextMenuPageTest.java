package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.ContextMenuPage;
import com.Dotdashcom.Pages.HomePage;


public class ContextMenuPageTest extends TestBase {
	HomePage homePage;
	ContextMenuPage contextMenuPage;;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		contextMenuPage = homePage.clickContextMenu();

	}

	@Test
	public void alertTextMatchingTest() {
		contextMenuPage.rightClickContextMenu();
		contextMenuPage.textFromAlert();
		Assert.assertEquals(contextMenuPage.textFromAlert(), "You selected a context menu");
	}
	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
