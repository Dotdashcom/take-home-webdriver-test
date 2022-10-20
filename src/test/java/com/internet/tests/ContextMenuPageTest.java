package com.internet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.ContextMenuPage;
import com.internet.pages.InternetPage;

public class ContextMenuPageTest extends BaseClass {
	InternetPage internet;
	ContextMenuPage rightClick;;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
		rightClick = internet.clickContextMenu();

	}

	@Test
	public void alertTextMatchingTest() {
		rightClick.rightClickContextMenu();
		rightClick.alertText();
		Assert.assertEquals(rightClick.alertText(), "You selected a context menu");
	}
	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}