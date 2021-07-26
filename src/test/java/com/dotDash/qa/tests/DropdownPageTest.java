package com.dotDash.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.DropdownPage;

public class DropdownPageTest extends TestBase {
	DropdownPage dropdownPage;

	public DropdownPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		dropdownPage = new DropdownPage();
	}

	// Testing and asserting the value
	@Test(priority = 1)
	public void option1() {
		String opt1 = dropdownPage.dropDownOption1();
		Assert.assertEquals("Option 1", opt1);
	}

	// Testing and asserting the value
	@Test(priority = 2)
	public void option2() {
		String opt2 = dropdownPage.dropDownOption2();
		Assert.assertEquals("Option 2", opt2);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
