package com.qa.INTest.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.INTest.Pages.CheckboxesPage;
import com.qa.INTest.TestBase.TestBase;

public class CheckboxesTest extends TestBase {

	CheckboxesPage cbp;

	public CheckboxesTest() {

		super();

	}

	@BeforeMethod
	public void setup() {

		initilize();
		cbp = new CheckboxesPage();
		cbp.clickOnCheckboxesLink();
	}

	@Test(priority = 1)
	public void vldCheckedboxes() {
		int expCheckedBox = cbp.checkedboxes();
		Assert.assertEquals(expCheckedBox, 2);
	}

	@Test(priority = 2)
	public void vldUnCheckedboxes() {
		int expCheckedBox = cbp.unCheckedboxes();
		Assert.assertEquals(expCheckedBox, 0);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
