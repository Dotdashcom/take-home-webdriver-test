package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.DragAndDropPage;
import com.Dotdashcom.Pages.HomePage;

public class DragAndDropPageTest extends TestBase {
	HomePage homePage;
	DragAndDropPage dragAndDropPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		dragAndDropPage = homePage.clickDragAndDrop();
	}

	@Test
	public void DragAndDropExchangeTest() throws InterruptedException {
		dragAndDropPage.dragAndDrop();
		Assert.assertEquals(dragAndDropPage.isTextExchanged(), true);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
