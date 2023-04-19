package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.DropDownPage;
import com.qa.dotdash.pages.HomePage;

public class DropDownPageTest  extends BaseClass {
	HomePage homePage;
	DropDownPage dropDown;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);

		dropDown = homePage.clickDropDown();

	}

	@Test
	public void selectOption1Test() {
		dropDown.selectOption1();
		Assert.assertEquals(dropDown.getTextOfSelectedOption(), "Option 1");
	}

	@Test
	public void selectOption2Test() {
		dropDown.selectOption2();

		Assert.assertEquals(dropDown.getTextOfSelectedOption(), "Option 2");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}


}
