package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class FileUploadTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("fileUploadURL"));
	}

	@Test(priority = 2)
	public void fileUploadTest() throws Exception {
		WebElement uploadElement = driver.findElement(By.id("file-upload"));
		Thread.sleep(1000);
		// enter the file path onto the file-selection input field
		uploadElement.sendKeys("/Users/h/Downloads/some-file.txt");
		// click the "UploadFile" button
		driver.findElement(By.id("file-submit")).click();
		Thread.sleep(1000);
		System.out.println("File is Uploaded Successfully");
		String title = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
		Assert.assertEquals(title, "File Uploaded!");//Assert

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
