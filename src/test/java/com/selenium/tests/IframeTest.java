package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {

	@Test
	public void iframe() {

		driver.get("http://localhost:7080/iframe");
		WebElement frame = driver.findElement(By.id("mce_0_ifr"));
		driver.switchTo().frame(frame);
		WebElement body = driver.findElement(By.id("tinymce"));
		body.clear();
		body.sendKeys("Hello World!");
		
		Assert.assertTrue(body.getText().contains("Hello World!"));
	}
}