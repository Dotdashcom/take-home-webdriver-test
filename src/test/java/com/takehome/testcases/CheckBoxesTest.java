package com.takehome.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.CheckboxPage;

public class CheckBoxesTest {

	DriverScript driverSetup;
	CheckboxPage page;

	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();

	}

	@Test

	public void checkboxes() {
		page = new CheckboxPage(driverSetup.getDriver(), driverSetup.getBaseURL());

		page.getCheckBox1().click();
		page.getCheckBox2().click();
		boolean isselected = page.getCheckBox1().isSelected();
		boolean unselected = !page.getCheckBox2().isSelected();
		Assert.assertTrue(isselected && unselected);

	}

	@AfterTest
	public void teardown() {

		driverSetup.getDriver().close();
	}
}
