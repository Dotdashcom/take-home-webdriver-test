package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class FileDownloadPageElements extends CommonMethods {		
	
	@FindBy(xpath = "//a[contains(text(),'file')]")
	public WebElement linkToFile;		
	
	public FileDownloadPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
