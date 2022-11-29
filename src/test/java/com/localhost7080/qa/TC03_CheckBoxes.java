package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC03_CheckBoxes {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeClass() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC03_CheckBoxes_Script() {				
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/checkboxes");
		
		// Verify first checkbox is checked
		Assert.assertFalse(driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)")).isSelected());
		driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)")).isSelected());

		// Verify second checkbox is unchecked
		Assert.assertTrue(driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(3)")).isSelected());
		driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(3)")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(3)")).isSelected());
	}

	@AfterTest
	public void afterClass() {		
		driver.close();		
	}

}
