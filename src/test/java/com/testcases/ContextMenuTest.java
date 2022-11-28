package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class ContextMenuTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("contextMenuURL"));
	}

	@Test(priority = 2)
	public void contextMenuTest() throws Exception {
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.id("hot-spot"));
		actions.contextClick(elementLocator).perform();
		//Assert
		String assertMsg = driver.switchTo().alert().getText();
		Assert.assertEquals(assertMsg, "You selected a context menu");
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
