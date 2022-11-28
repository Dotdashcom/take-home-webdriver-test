package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class CheckboxTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("checkboxURL"));
	}

	@Test(priority = 2)
	public void checkboxTest() throws Exception {
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		// If the checkbox is unchecked then isSelected() will return false
		// and NOT of false is true, hence we can click on checkbox
		if (!checkbox1.isSelected())
			checkbox1.click();
//checkbox option2
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		if (!checkbox2.isSelected())
			checkbox2.click();
		Thread.sleep(2000);
		// If it is selected uncheck the checkbox
		if (checkbox2.isSelected())
			checkbox2.click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		// close all browser windows
	}

}
