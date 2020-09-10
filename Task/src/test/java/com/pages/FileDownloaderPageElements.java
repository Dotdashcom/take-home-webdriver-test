package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloaderPageElements extends BaseClass{

	//location of file
	@FindBy(xpath = "//a[contains(text(),'file.txt')]")
	public WebElement fileLoc;
	
	public FileDownloaderPageElements(){
		PageFactory.initElements(driver, this);
	}
	
}
