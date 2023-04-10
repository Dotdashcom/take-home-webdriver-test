package com.homedriver;

import static org.junit.Assert.assertEquals;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.TestHelperMethods;

public class OpenInNewTabTest {
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

	// Test Link Opens in new tab.
	@Test
	public void openInNewTab_onClickLink_check() {
		driver.get(configFileReader.getBaseUrl() + "/windows");
		driver.findElement(testHelperMethods.getLocatorByLinkText("Click Here")).click();

		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		assertEquals("New tab wasn't opened:", 2, tabs.size());
		driver.switchTo().window(tabs.get(1));
		assertEquals("New Window", driver.findElement(By.xpath("//body")).getText());
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
