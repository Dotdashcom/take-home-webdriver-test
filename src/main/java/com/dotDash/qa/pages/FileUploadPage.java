package com.dotDash.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotDash.qa.base.TestBase;

public class FileUploadPage extends TestBase {

	@FindBy(xpath = "//a[@href='/upload']")
	WebElement fileInput;

	@FindBy(id = "file-submit")
	public WebElement submitBtn;

	@FindBy(id = "file-upload")
	public WebElement uploadBtn;

	// Initializing the Page Objects:
	public FileUploadPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public String uploadFile(String filePath) {
		fileInput.click();
		uploadBtn.sendKeys(filePath);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		submitBtn.click();
		return driver.findElement(By.id("uploaded-files")).getText();
	}
}
