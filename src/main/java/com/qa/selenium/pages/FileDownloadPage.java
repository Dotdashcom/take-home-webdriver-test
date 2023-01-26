package com.qa.selenium.pages;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class FileDownloadPage extends TestBase{
	
	@FindBy (xpath = "//*[contains(text(),'some-file.txt')]")
	WebElement downloadLink;
	
	
	public FileDownloadPage() {
		PageFactory.initElements(driver, this);
	}


	public void DownloadStart() {
		
	
		
		downloadLink.click();
	}
	
}
