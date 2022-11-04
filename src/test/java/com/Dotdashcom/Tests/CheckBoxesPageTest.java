package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Pages.HomePage;
import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.CheckBoxesPage;

public class CheckBoxesPageTest extends TestBase {
	HomePage homePage;
	CheckBoxesPage checkBoxesPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		checkBoxesPage = homePage.clickCheckBoxes();
	}

	@Test
	public void checkBoxesCheckedTest() {
		if (checkBoxesPage.isCheckBox1Selected()) {
			checkBoxesPage.clickCheckBox2();
		} else {
			checkBoxesPage.clickCheckBox1();
		}
		Assert.assertEquals(checkBoxesPage.isCheckBoxesSelected(), true);
	}

	@Test
	public void checkBoxesUncheckedTest() {
		if (checkBoxesPage.isCheckBox1Selected()) {
			checkBoxesPage.clickCheckBox1();
		} else {
			checkBoxesPage.clickCheckBox2();
		}
		Assert.assertEquals(checkBoxesPage.isCheckBoxesSelected(), false);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
