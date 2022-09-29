package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.CheckBoxesPage;
import com.internet.pages.LoginPage;
import com.internet.pages.TheInternetPage;

public class CheckBoxesPageTest extends Baseclass {
	TheInternetPage internet;
	CheckBoxesPage check;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
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
