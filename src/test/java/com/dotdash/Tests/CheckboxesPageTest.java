package com.dotdash.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.CheckBoxesPage;
import com.dotdash.Pages.InternetPage;

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
