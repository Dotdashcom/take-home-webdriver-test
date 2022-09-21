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

public class TC09_DynamicLoading {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC09_DynamicLoading_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/dynamic_loading/2");

		// Explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Click on button and wait until text "Hello World!" appear
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		Assert.assertEquals(driver.findElement(By.id("finish")).getText(), "Hello World!");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
