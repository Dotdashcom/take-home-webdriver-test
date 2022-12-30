package com.qa.INTest.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicLoadTest {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\SeleniumCopy\\Selenium_WorkSpace_Copy\\InterviewTestPOM\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_loading/2");

	}

	@Test
	public void vldHelloWorldTest() {
		wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
		Assert.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).isDisplayed());

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
