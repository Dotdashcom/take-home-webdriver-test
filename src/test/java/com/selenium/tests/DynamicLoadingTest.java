package com.selenium.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends TestBase {

	@Test
	public void dinamicLoading() {

		//Example 1: Element on page that is hidden
		
		driver.get("http://localhost:7080/dynamic_loading");
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.cssSelector("#start button")).click();
		WebElement msg1 = driver.findElement(By.cssSelector("#finish"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(msg1));
		
		Assert.assertEquals(msg1.getText(), "Hello World!");
		
		//Example 2: Element rendered after the fact
		
		driver.get("http://localhost:7080/dynamic_loading");
		driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
		driver.findElement(By.cssSelector("#start button")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish")));
		WebElement msg2 = driver.findElement(By.cssSelector("#finish"));
		
		Assert.assertEquals(msg2.getText(), "Hello World!");
	
	}
}