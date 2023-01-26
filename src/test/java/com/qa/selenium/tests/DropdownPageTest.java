package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.DropdownPage;

public class DropdownPageTest extends TestBase{

	DropdownPage dropdownPage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "dropdown");
		dropdownPage = new DropdownPage();
	}
	
	@Test
	public void option1Test() throws InterruptedException {
		dropdownPage.menu();
		Thread.sleep(2000);
		dropdownPage.selectOption1();
		Assert.assertEquals(dropdownPage.selected1(), true);
	}

	@Test
		public void option2Test() throws InterruptedException {
			dropdownPage.menu();
			Thread.sleep(2000);
			dropdownPage.selectOption2();
			Assert.assertEquals(dropdownPage.selected2(), true);

		}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
