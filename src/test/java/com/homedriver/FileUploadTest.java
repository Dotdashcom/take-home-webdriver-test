package com.homedriver;

import static org.junit.Assert.assertEquals;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadTest {
	private static WebDriver driver;
	private static ConfigFileReader configFileReader;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader = new ConfigFileReader();
		driver = new ChromeDriver();
	}

	// Test File Upload.
	@Test
	public void uploadFile_check() throws IOException {

		driver.get(configFileReader.getBaseUrl() + "/upload");

		// create a temporary file to be uploaded
		String text = "testing upload functionality by uploading this file";
		File tempFile = File.createTempFile("testFileToUpload_", ".tmp");
		FileWriter writer = new FileWriter(tempFile);
		writer.write(text);
		writer.close();

		driver.findElement(By.id("file-upload")).sendKeys(tempFile.getPath());
		driver.findElement(By.id("file-submit")).click();
		assertEquals("File Uploaded!", driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText());
		assertEquals(tempFile.getName(), driver.findElement(By.id("uploaded-files")).getText());
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
