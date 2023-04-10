package com.homedriver;

import static org.junit.Assert.assertTrue;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FloatingMenuTest {
	private static WebDriver driver;
	private static ConfigFileReader configFileReader;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		driver = new ChromeDriver();
	}

	// Test Floating Menu.
	@Test
	public void floatingMenu_displayedOnScrolling_check() {
		driver.get(configFileReader.getBaseUrl() + "/floating_menu");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)"); 
        assertTrue(driver.findElement(By.id("menu")).isDisplayed());

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        assertTrue(driver.findElement(By.id("menu")).isDisplayed());
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
