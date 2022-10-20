package com.internet.tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.DragAndDropPage;
import com.internet.pages.AccountLoginPage;
import com.internet.pages.Page;
import com.internet.pages.InternetPage;

public class DragAndDropPageTest extends BaseClass {
	InternetPage internet;
	DragAndDropPage drag;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
		drag = internet.clickDragAndDrop();
	}

	@Test
	public void DragAndDropExchangeTest() {
		drag.dragAndDrop();
		Assert.assertEquals(drag.isTextExchanged(), true);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}