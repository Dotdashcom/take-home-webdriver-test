package com.localhost7080.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC08_DynamicControls {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC08_DynamicControls_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/dynamic_controls");

		// Explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		// CHECKBOX
		// Click on button and wait until text "It's gone!" appear
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's gone!");

		// Click on button again and wait until text "It's back!" appear
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's back!");

		// INPUT
		// Click on button and wait until text "It's enabled!" appear
		driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's enabled!");

		// Click on button and wait until text "It's disabled!" appear
		driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's disabled!");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
