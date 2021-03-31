package com.webdrivertest.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.webdrivertest.utils.ElementUtil;

public class FileUploadPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	By chooseFile = By.id("file-upload");
	private final String FILE_NAME = "some-file.txt";
    private String path = System.getProperty("user.dir");
    private String filePath = path + "/Downloads/" + FILE_NAME;
	
    public void uploadFile() {
    	elementUtil.waitForElementPresent(chooseFile);
    	elementUtil.doSendKeys(chooseFile, "/Users/bobit/Downloads/some-file.txt");
    }
    
    public boolean isDisplayed() {
    	return elementUtil.doIsDisplayed(chooseFile);
    }
}
