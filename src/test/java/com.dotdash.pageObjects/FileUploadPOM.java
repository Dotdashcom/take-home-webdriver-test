package com.dotdash.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dotdash.testUtils.TestBase;

public class FileUploadPOM extends TestBase {

	@FindBy(css="input#file-upload")
	WebElement chooseFile;
	
	@FindBy(css="input#file-submit")
	WebElement upload;
	
	@FindBy(css="div.example>h3")
	WebElement fileUploadTxt;
	
	public FileUploadPOM() {
		PageFactory.initElements(driver,this);
	}
	public void userfileupload() {
		chooseFile.sendKeys(prop.getProperty("fileuploadpath"));
		upload.click();
	}
	
	public void userverifyFileUpload() {
		String fileUpload=fileUploadTxt.getText();
	    String propfileText=prop.getProperty("fileuploadMsg");
		Assert.assertEquals(fileUpload,propfileText.trim());
	}
}
