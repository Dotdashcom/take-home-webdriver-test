package com.homedriver;

import static org.junit.Assert.assertEquals;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownTest {
	private static WebDriver driver;
	private static ConfigFileReader configFileReader;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		driver = new ChromeDriver();
	}

	// Test dropdown using Webdriver.
	@Test
	public void dropDown_selectOptions_check() {
		driver.get(configFileReader.getBaseUrl() + "/dropdown");

		String option1Text = "Option 1";
		String option2Text = "Option 2";

		Select dropdownOptions = new Select(driver.findElement(By.id("dropdown")));

		// https://webdriver.io/docs/api/element/selectByVisibleText/ - Select option
		// with displayed text matching the argument
		dropdownOptions.selectByVisibleText(option1Text);
		assertEquals(option1Text, dropdownOptions.getFirstSelectedOption().getText());

		dropdownOptions.selectByVisibleText(option2Text);
		assertEquals(option2Text, dropdownOptions.getFirstSelectedOption().getText());
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
