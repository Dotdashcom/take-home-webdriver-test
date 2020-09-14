package com.dotDash.DotDash;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIleUploadPage {

	public FIleUploadPage(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}
	
	@FindBy(xpath = "//input[@id='file-upload']" )
	public static WebElement browserTab;
	
	@FindBy(xpath = "//input[@id='file-submit']" )
	public static WebElement uploadBtn;
	
	@FindBy(xpath = "//div[@class='example']//h3" )
	public static WebElement text;
	
	
	
	public WebElement browserTab() {
		return browserTab;
	}
	public WebElement uploadBtn() {
		return uploadBtn;
	}
	public WebElement text() {
		return text;
	}
	
}


