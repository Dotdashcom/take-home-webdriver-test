package com.qa.INTest.Tests;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileDownloadTest {

	WebDriver driver;
	File folder;

	@BeforeMethod
	public void setup() {
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();

		System.setProperty("webdriver.chrome.driver",
				"C:\\SeleniumCopy\\Selenium_WorkSpace_Copy\\InterviewTestPOM\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());

		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(cap);

	}

	@Test
	public void vldFileDownloadTest() throws InterruptedException {

		driver.get("http://localhost:7080/download");
		driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]")).click();

		Thread.sleep(5000);

		File listofFiles[] = folder.listFiles();
		Assert.assertTrue(listofFiles.length > 0);

		for (File file : listofFiles) {
			Assert.assertTrue(listofFiles.length > 0);
		}
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
