package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import utilities.DriverUtility;

public class FileUploadTest extends Base {

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/upload");
	}

	@Test
	// Test uses Upload Button or Drag and Drop to upload a file.
	// Test asserts that the file is uploaded.

	public void fileUpload() {
		WebElement uploadFile = driver.findElement(By.id("file-upload"));
		WebElement uploadButton = driver.findElement(By.id("file-submit"));
		String filePath = "/Users/enkhtsetseg/Desktop/test2.xlsx";
		DriverUtility.enterText(uploadFile, filePath);
		DriverUtility.clickonElement(uploadButton);
		Assert.assertTrue(driver.findElement(By.id("uploaded-files")).isDisplayed());
	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();

	}
}