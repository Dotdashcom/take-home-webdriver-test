package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPageElements extends BaseClass{

	//Choose File button location
	@FindBy(xpath = "//input[@id='file-upload']")
	public WebElement chooseFile;
	
	
	//Upload button location
	@FindBy(xpath = "//input[@id='file-submit']")
	public WebElement uploadBtn;
	
	//message
	@FindBy(xpath = "//div[@class='example']")
	public WebElement message;
	
	
	public FileUploadPageElements(){
		PageFactory.initElements(driver, this);
	}
}
