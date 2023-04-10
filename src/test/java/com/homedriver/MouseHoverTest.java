package com.homedriver;

import static org.junit.Assert.assertTrue;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHoverTest {
	private static WebDriver driver;
	private static ConfigFileReader configFileReader;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		driver = new ChromeDriver();
	}

	// Test Mouse Hover.
	@Test
	public void mouseHoverOver_eachImage_check() {
		driver.get(configFileReader.getBaseUrl() + "/hovers");
		Actions actions = new Actions(driver);
		List<WebElement> images = driver.findElements(By.xpath("//*[@class='figure']"));
		for (WebElement image : images) {
			actions.moveToElement(image).perform();
			WebElement additionalInformation = image.findElement(By.xpath("*[@class='figcaption']"));
			assertTrue(additionalInformation.isDisplayed());
			assertTrue(additionalInformation.getText().length() > 0);
		}
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
