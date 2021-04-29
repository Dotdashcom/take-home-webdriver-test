package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FileUploadPage {
	public static final By FILEUPLOADINGHEADER=By.xpath("//h3[text()='File Uploader']");
	public static final By CHOOSEFILE_BTN=By.id("file-upload");
	public static final By UPLOAD_BTN=By.id("file-submit");
	public static final By FILEUPLOADEDGHEADER=By.xpath("//h3[text()='File Uploaded!']");
	public static final By UPLOADED_FILENAME=By.id("uploaded-files");
	

	
	public static void validateFileUploadHeader(WebDriver driver) {
		WebElement element= driver.findElement(FILEUPLOADINGHEADER);
		Assert.assertTrue(element.isDisplayed(), "FileUpload Header is not Displaying");

	}

	public static void FileUploadAndValidation(WebDriver driver,String fileName) {
		WebElement uploadElement = driver.findElement(CHOOSEFILE_BTN);
       String filePath= System.getProperty("user.dir")+"/src/test/resources/"+fileName;
        uploadElement.sendKeys(filePath);
        driver.findElement(UPLOAD_BTN).click();
	}
	public static void validateFileUploaded(WebDriver driver,String fileName) {
		WebElement element= driver.findElement(FILEUPLOADEDGHEADER);
		Assert.assertTrue(element.isDisplayed(), "FileUploaded Header is not Displaying");
  
		Assert.assertEquals(driver.findElement(UPLOADED_FILENAME).getText().trim(), fileName);
	}
	
	
	

}
