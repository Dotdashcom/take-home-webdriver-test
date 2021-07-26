package com.dotDash.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotDash.qa.base.TestBase;

public class FileUploadPage extends TestBase {

	// Finding the link to the file upload page
	@FindBy(xpath = "//a[@href='/upload']")
	WebElement fileInput;

	// Finding the submit button on the page
	@FindBy(id = "file-submit")
	public WebElement submitBtn;

	// Finding the upload button on the page
	@FindBy(id = "file-upload")
	public WebElement uploadBtn;

	// Initializing the Page Objects:
	public FileUploadPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// Uploading file test function
	public String uploadFile(String filePath) {
		fileInput.click();
		uploadBtn.sendKeys(filePath);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		submitBtn.click();
		return driver.findElement(By.id("uploaded-files")).getText();
	}
}
