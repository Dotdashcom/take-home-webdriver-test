package com.homedriver;

import static org.junit.Assert.assertEquals;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenuTest {

	private static WebDriver driver;
	private static ConfigFileReader configFileReader;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		driver = new ChromeDriver();
	}

	// Right-click in the box to see one called 'the-internet'. Test JavaScript
	// alert text on Right-Click.
	@Test
	public void contextMenu_rightClick_check() {
		driver.get(configFileReader.getBaseUrl() + "/context_menu");

		Actions actions = new Actions(driver);
		WebElement contextMenuArea = driver.findElement(By.id("hot-spot"));
		actions.contextClick(contextMenuArea).perform();
		assertEquals(configFileReader.getContextMenuText(), driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
