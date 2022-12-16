package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class FileUploadPageElements extends CommonMethods{
	
	@FindBy (id = "file-upload")
	public WebElement cfbutton;
	
	@FindBy (id = "file-submit")
	public WebElement uploadButton;
	
	@FindBy (id = "drag-drop-upload")
	public WebElement dragdropbox;
	
	@FindBy (css = "div.example > h3")
	public WebElement succesmsg;

	
	public FileUploadPageElements() {
		PageFactory.initElements(driver, this);
	}

}
