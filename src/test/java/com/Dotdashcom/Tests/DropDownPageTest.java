package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.DropDownPage;
import com.Dotdashcom.Pages.HomePage;

public class DropDownPageTest extends TestBase {
	HomePage homePage;
	DropDownPage dropDownPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);

		dropDownPage = homePage.clickDropDown();

	}

	@Test
	public void selectOption1Test() {
		dropDownPage.selectOption1();
		Assert.assertEquals(dropDownPage.getSelectedOptionsText(), "Option 1");
	}

	@Test
	public void selectOption2Test() {
		dropDownPage.selectOption2();

		Assert.assertEquals(dropDownPage.getSelectedOptionsText(), "Option 2");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
