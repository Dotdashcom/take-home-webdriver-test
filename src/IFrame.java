package com.dotDash.DotDash;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage {

	public IFramePage(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}
	
	@FindBy(xpath = "//body[@id='tinymce']//p" )
	public static WebElement textBox;
	
	
	
	public WebElement textBox() {
		return textBox;
	}
	
}
