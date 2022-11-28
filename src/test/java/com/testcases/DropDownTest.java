package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class DropDownTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("dropDownURL"));
	}

	@Test(priority = 2)
	public void dropDownTest() throws Exception {
		WebElement dropDown = driver.findElement(By.id("dropdown"));
		Select select = new Select(dropDown);
		// select option 2
		select.selectByValue("2");
		WebElement o = select.getFirstSelectedOption();
		String selectedoption = o.getText();
		Assert.assertEquals(selectedoption, "Option 2");
		
		// select option 1
		select.selectByVisibleText("Option 1");
		WebElement w = select.getFirstSelectedOption();
		//Assert
		String selectedWoption = w.getText();
		Assert.assertEquals(selectedWoption, "Option 1");
		

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
