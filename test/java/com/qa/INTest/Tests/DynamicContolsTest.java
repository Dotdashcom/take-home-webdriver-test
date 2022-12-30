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

public class DynamicContolsTest {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\SeleniumCopy\\Selenium_WorkSpace_Copy\\InterviewTestPOM\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_controls");
		wait = new WebDriverWait(driver, 10);
	}

	@Test(priority = 1)
	public void vldClickRemoveTest() {

		driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Add')]")).isDisplayed());
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']//div[1]")));
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkbox-example']//div[1]")).isDisplayed());
	}

	@Test(priority = 2)
	public void vldClickEnableTest() {
		driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Disable')]")));
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());

		driver.findElement(By.xpath("//button[contains(text(),'Disable')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enable')]")));
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
