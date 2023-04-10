package com.homedriver;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownloadTest {
	private static WebDriver driver;
	private static ConfigFileReader configFileReader;
	private static File folder;

	@BeforeTest
	public void setup() {
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserName", "chrome");
		options.setCapability("platform", false);

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", folder.getAbsolutePath());
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
	}

	// Test File Download.
	@Test
	public void downloadFile_check() throws IOException, InterruptedException {
		driver.get(configFileReader.getBaseUrl() + "/download");
		driver.findElement(By.cssSelector(".example > a:nth-child(2)")).click();
		Thread.sleep(2000);
		File fileList[] = folder.listFiles();
		Assert.assertTrue(fileList.length > 0);
		for (File file : fileList) {
			Assert.assertTrue(file.length() > 0);
		}
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
