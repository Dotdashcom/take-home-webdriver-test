package com.theInternetPages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class FileUploadPage extends BasePage {

	WebDriver obj_Driver;
	String fileUploadTitle = "//h3[text()='File Uploader']";
	String chooseFileButton = "//input[@id='file-upload']";
	String uploadButton = "//input[@type='submit']";
	String fileUploadMsg = "//h3[text()='File Uploaded!']";

	public FileUploadPage(WebDriver driver) {
		super(driver);
		this.obj_Driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void isDisplayedPage() {
		explicitWait(fileUploadTitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(fileUploadTitle)).size() > 0,
				"file Upload page is displayed");
	}

	public void fileUpload() {
		System.out.println(System.getProperty("user.dir") + File.separator + "Data" + File.separator + "TestFile.txt");
		obj_Driver.findElement(By.xpath(chooseFileButton))
				.sendKeys(System.getProperty("user.dir") + File.separator + "Data" + File.separator + "TestFile.txt");
		click(uploadButton, "Upload buttton");
		explicitWait(fileUploadMsg);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(fileUploadMsg)).size() >= 0,
				"File did not upload successfully");
		Reporter.log("File has been uploaded successfully");
	}

}
