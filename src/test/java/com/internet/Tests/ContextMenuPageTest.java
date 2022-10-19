package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.ContextMenuPage;
import com.internet.pages.TheInternetPage;

public class ContextMenuPageTest extends Baseclass {
	TheInternetPage internet;
	ContextMenuPage context;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		context = internet.clickContextMenu();

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
