package com.internet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.CheckBoxesPage;
import com.internet.pages.AccountLoginPage;
import com.internet.pages.InternetPage;

public class CheckboxesPageTest extends BaseClass {
	InternetPage internet;
	CheckBoxesPage check;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
		check = internet.clickCheckBoxes();
	}

	@Test
	public void checkBoxesCheckedTest() {
		if (check.isCheckBox1Selected()) {
			check.selectCheckBox2();
		} else {
			check.selectCheckBox1();
		}
		Assert.assertEquals(check.isCheckBoxesSelected(), true);
	}

	@Test
	public void checkBoxesUncheckedTest() {
		if (check.isCheckBox1Selected()) {
			check.selectCheckBox1();
		} else {
			check.selectCheckBox2();
		}
		Assert.assertEquals(check.isCheckBoxesSelected(), false);
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}