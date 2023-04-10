package com.homedriver;

import static org.junit.Assert.assertNotEquals;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.TestHelperMethods;

public class DynamicContentTest {
	private static WebDriver driver;
	private static ConfigFileReader configFileReader;
	private static TestHelperMethods testHelperMethods;

	By contentInPage = By.xpath("//div[@class='large-10 columns']");

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		driver = new ChromeDriver();
		testHelperMethods = new TestHelperMethods();
	}

	// Test content changes with page reload.
	@Test
	public void dynamicContent_refreshContent_check() {
		driver.get(configFileReader.getBaseUrl() + "/dynamic_content");
		for (int i = 1; i <= 4; i++) {
			List<String> beforeContent = testHelperMethods.getContentsInPage(driver);
			driver.navigate().refresh();
			List<String> afterContent = testHelperMethods.getContentsInPage(driver);
			for (int j = 0; j < beforeContent.size(); j++) {
				assertNotEquals(beforeContent.get(j), afterContent.get(j));
			}
		}
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
