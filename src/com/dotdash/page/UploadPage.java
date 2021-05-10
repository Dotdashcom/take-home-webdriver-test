package com.dotdash.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/upload";
	private WebElement fileUpload;
	private WebElement uploadButton;
	private WebElement uploadedFilesDiv;

	public UploadPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		fileUpload = driver.findElement(By.id("file-upload"));
		assertTrue(fileUpload.isDisplayed());
		assertTrue(fileUpload.isEnabled());
		
		uploadButton = driver.findElement(By.id("file-submit"));
		assertTrue(uploadButton.isDisplayed());
		assertTrue(uploadButton.isEnabled());
	}
	
	public void verifyUploadConfirmation(String fileName) {
		uploadedFilesDiv = driver.findElement(By.id("uploaded-files"));
		assertTrue(uploadedFilesDiv.isDisplayed());
		assertTrue(uploadedFilesDiv.getText().contains(fileName));
	}

	public void upload(String fullPath) {
		fileUpload.sendKeys(fullPath);
		uploadButton.click();
	}
}
