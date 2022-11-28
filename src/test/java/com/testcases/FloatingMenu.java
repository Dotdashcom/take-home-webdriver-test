package com.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class FloatingMenu extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("FloatingMenuURL"));
	}

	@Test(priority = 2)
	public void floatingMenuTest() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(0,2500)");
		Thread.sleep(2000);
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a"));
		boolean checkBoxStatus = dynamicElement.size() != 0;
		Assert.assertEquals(true, checkBoxStatus);//Assert

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
