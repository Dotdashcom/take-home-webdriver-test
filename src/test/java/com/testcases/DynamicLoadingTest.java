package com.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class DynamicLoadingTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("dynamicLoadingURL"));
	}

	@Test(priority = 2)
	public void dynamicLoadingTest() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"start\"]/button[text()='Start']")));
		driver.findElement(By.xpath("//*[@id=\"start\"]/button[text()='Start']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("finish")));

		String helloTxt = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4")).getText();
		Assert.assertEquals(helloTxt, "Hello World!");//Assert
		

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
