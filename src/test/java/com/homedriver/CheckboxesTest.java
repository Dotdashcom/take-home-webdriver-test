package com.homedriver;

import static org.junit.Assert.assertFalse;
import util.TestHelperMethods;
import static org.junit.Assert.assertTrue;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxesTest {
	private static WebDriver driver;
	private static ConfigFileReader configFileReader;
	private static TestHelperMethods testHelperMethods;
	

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		driver = new ChromeDriver();
		testHelperMethods = new TestHelperMethods();
	}

	// Check and uncheck boxes.
	@Test
	public void checkboxes_ischecked_isUnchecked_check() {
		driver.get(configFileReader.getBaseUrl() + "/checkboxes");

		By checkboxesLocator = By.xpath("//form[@id='checkboxes']/input");
		WebElement checkbox1 = driver.findElements(checkboxesLocator).get(0);
		testHelperMethods.checkBoxSelect(true, checkbox1);
		assertTrue(checkbox1.isSelected());
		testHelperMethods.checkBoxSelect(false, checkbox1);
		assertFalse(checkbox1.isSelected());

		WebElement checkbox2 = driver.findElements(checkboxesLocator).get(1);
		testHelperMethods.checkBoxSelect(true, checkbox2);
		assertTrue(checkbox2.isSelected());
		testHelperMethods.checkBoxSelect(false, checkbox2);
		assertFalse(checkbox2.isSelected());
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
