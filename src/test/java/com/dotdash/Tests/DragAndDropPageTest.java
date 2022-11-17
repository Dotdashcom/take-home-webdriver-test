package com.dotdash.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.DragAndDropPage;
import com.dotdash.Pages.InternetPage;

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
