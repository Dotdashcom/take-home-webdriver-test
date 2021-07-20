package com.dotDash.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.DynamicControlPage;

public class DynamicControlPageTest extends TestBase {
	DynamicControlPage dynamicControlPage;

	public DynamicControlPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		dynamicControlPage = new DynamicControlPage();
	}

	@Test(priority = 1)
	public void checked() {
		boolean invisible = dynamicControlPage.dynamicCheckbox();
		Assert.assertEquals(true, invisible);
		boolean visible = dynamicControlPage.dynamicCheckboxEndable();
		Assert.assertEquals(false, visible);
	}

	@Test(priority = 2)

	public void enable() {
		boolean enable = dynamicControlPage.dynamicTextbox();
		Assert.assertEquals(false, enable);
		boolean disable = dynamicControlPage.dynamicTextboxDisable();
		Assert.assertEquals(true, disable);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
