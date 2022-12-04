package com.selenium.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends TestBase {

	@Test
	public void dinamicControls() {

		driver.get("http://localhost:7080/dynamic_controls");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//checkbox
		WebElement remove = driver.findElement(By.cssSelector("#checkbox-example button"));
		remove.click();
		wait.until(ExpectedConditions.textToBePresentInElement(remove, "Add"));
		
		List<WebElement> checkboxList = driver.findElements(By.cssSelector("#checkbox [type=checkbox]"));
		Assert.assertTrue(checkboxList.size() == 0, "the checkbox is still visible");
		
		remove.click();
		wait.until(ExpectedConditions.textToBePresentInElement(remove, "Remove"));
		
		WebElement checkbox = driver.findElement(By.cssSelector("#checkbox-example [type=checkbox]"));
		Assert.assertTrue(checkbox.isDisplayed());
		
		//input-text
		WebElement enable = driver.findElement(By.cssSelector("#input-example button"));
		enable.click();
		wait.until(ExpectedConditions.textToBePresentInElement(enable, "Disable"));
		
		WebElement input = driver.findElement(By.cssSelector("#input-example input"));
		Assert.assertTrue(input.isEnabled());
		
		enable.click();
		wait.until(ExpectedConditions.textToBePresentInElement(enable, "Enable"));
		
		Assert.assertFalse(input.isEnabled());
	
		
		
	}
}