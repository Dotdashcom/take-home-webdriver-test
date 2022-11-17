package com.dotdash.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.ContextMenuPage;
import com.dotdash.Pages.InternetPage;

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
