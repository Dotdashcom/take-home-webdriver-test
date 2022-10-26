package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadDownloadPageObjects {

	WebDriver ldriver;

	public FileUploadDownloadPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	}
	
	@FindBy(xpath="//div[@id='content']//a")
	private WebElement Downloadlink;
	
	@FindBy(xpath="//input[@id='file-upload']")
	public WebElement ChooseFileButton;
	
	@FindBy(xpath="//input[@id='file-submit']")
	private WebElement UploadButton;
	
	@FindBy(xpath="//div[@id='content']//h3")
	public WebElement FileUploadedmsg;
	
	public void clickDownload() {
		Downloadlink.click();
	}
	
	public void ClickUpload() {
		UploadButton.click();
	}
}
