package com.theInternetApp.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.theInternetApp.qa.Utilities.BaseClass;
import com.theInternetApp.qa.Utilities.WaitHelper;

/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
	public class FileUploadPage extends BaseClass {
	
		// The following Initialization of the Page factory
		public FileUploadPage(WebDriver driver) {
	
			PageFactory.initElements(driver, this);
			waitHelper = new WaitHelper(driver);
		}
	
		// The following are Declaration the web elements
	
		@FindBy(xpath = "//a[contains(text(),'File Upload')]")
		@CacheLookup
		WebElement FileUploadLink;
		
		@FindBy(xpath = "//input[@id='file-upload']")
		@CacheLookup
		WebElement ChosseAFile;
		
		@FindBy(id = "file-submit")
		@CacheLookup
		WebElement UploadButton;	
		
		@FindBy(id = "drag-drop-upload")
		@CacheLookup
		WebElement dragAndDropToUpload;
		
		@FindBy(xpath = "//h3[contains(text(),'File Uploaded!')]")
		@CacheLookup
		WebElement FileUploadedMessage;
	
	
		// The following are the Utilizations by creating methods for each of the
		// components.
	
		// get URL
		public void getUrl() {
			driver.get(Base_URL);
			FileUploadLink.click();
		}
	
		//click on upload File
		public void uploadFile(String filePath) {
			ChosseAFile.sendKeys(filePath);
			UploadButton.click();
		}
		
		//get Message Text
		public String getFileUploadedText() {
			return FileUploadedMessage.getText();
		}
	}
