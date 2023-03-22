package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class FileUploadPageElements extends CommonMethods {		
	
	@FindBy(id = "file-upload")
	public WebElement chooseFileToUpload;	
	
	@FindBy(id = "file-submit")
	public WebElement uploadBtn;	
	
	@FindBy(className = "example")
	public WebElement messageHeader;	
	
	@FindBy(id = "uploaded-files")
	public WebElement nameOfUploadedFile;
	
	public FileUploadPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
