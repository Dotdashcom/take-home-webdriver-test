package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.CheckBoxesPage;
import com.qa.dotdash.pages.HomePage;

public class CheckBoxesPageTest extends BaseClass {
	HomePage homePage;
	CheckBoxesPage check;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		check = homePage.clickCheckBoxes();
	}

	@Test
	public void checkBoxesCheckedTest() {
		if (check.isCheckBox1Selected()) {
			check.clickCheckBox2();
		} else {
			check.clickCheckBox1();
		}
		Assert.assertEquals(check.isCheckBoxesSelected(), true);
	}

	@Test
	public void checkBoxesUncheckedTest() {
		if (check.isCheckBox1Selected()) {
			check.clickCheckBox1();
		} else {
			check.clickCheckBox2();
		}
		Assert.assertEquals(check.isCheckBoxesSelected(), false);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
