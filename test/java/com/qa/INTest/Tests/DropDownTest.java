package com.qa.INTest.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.INTest.Pages.DropDownPage;
import com.qa.INTest.TestBase.TestBase;

public class DropDownTest extends TestBase {

	DropDownPage ddp1;

	public DropDownTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initilize();
		ddp1 = new DropDownPage();
		ddp1.clickDropDownLink();
	}

	@Test
	public void vldDropDownTest() {
		String expOption = ddp1.selectOption1();
		Assert.assertEquals(expOption, "Option 2");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
