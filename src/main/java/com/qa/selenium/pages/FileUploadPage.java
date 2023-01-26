package com.qa.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class FileUploadPage extends TestBase{

	@FindBy (xpath= "//form[@method= 'POST']/input[1]")
	WebElement browseBtn;
	
	@FindBy (xpath = "//form[@method= 'POST']/input[2]")
	WebElement uploadBtn;
	
	@FindBy (xpath = "//div[@Class='example']/h3")
	WebElement fileUploadverify;
	
	
	
	public FileUploadPage() {
		PageFactory.initElements(driver, this);
	}
	

	public void selectBrowse() {
		browse().sendKeys("C:\\Users\\yashh\\Downloads\\sample-upload-text.txt");
		
		
	}
	
	public void selectupload() {
		uploadBtn.click();
	}
	
	public WebElement browse() {
		return browseBtn;
	}
	 
	public String verifyUpload() {
		return fileUploadverify.getText();
	}
}
