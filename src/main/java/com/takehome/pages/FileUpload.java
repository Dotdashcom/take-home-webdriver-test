package com.takehome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUpload {
	
	WebDriver driver;
	
	
	@FindBy(id = "file-upload") WebElement fileInput;
	@FindBy(id = "file-submit") WebElement uploadButton;
	@FindBy(id = "uploaded-files") WebElement afterUploadDisplay;
	
	public FileUpload(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" +"upload";
		driver.get(url);
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getFileInput()
	{
		return fileInput;
	}
	
	public WebElement getUploadButton()
	{
		return uploadButton;
	}
	
	public WebElement getAfterUploadDisplay()
	{
		return afterUploadDisplay;
	}

}
