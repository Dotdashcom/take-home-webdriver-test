package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC12_FloatingMenu {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC12_FloatingMenu_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/floating_menu");

		// Verify whether the element is present before scroll down
		Boolean x = driver.findElement(By.id("menu")).isDisplayed();
		// scroll down
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,2000)");
		// Verify whether the element still present
		Boolean y = driver.findElement(By.id("menu")).isDisplayed();
		Assert.assertEquals(x, y);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
}
