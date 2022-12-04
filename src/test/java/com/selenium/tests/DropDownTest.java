package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends TestBase {

	@Test
	public void dropDown() {

		driver.get("http://localhost:7080/dropdown");
		
		driver.findElement(By.id("dropdown")).click();
		WebElement option = driver.findElement(By.cssSelector("option[value='1']"));
		option.click();
		Assert.assertTrue(option.isSelected());

		driver.findElement(By.id("dropdown")).click();
		option = driver.findElement(By.cssSelector("option[value='2']"));
		option.click();
		Assert.assertTrue(option.isSelected());

	}
}