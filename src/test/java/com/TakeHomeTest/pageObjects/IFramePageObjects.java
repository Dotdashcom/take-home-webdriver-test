package com.TakeHomeTest.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFramePageObjects {


	WebDriver ldriver;

	public IFramePageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	}
	
	
	
	@FindBy(xpath="//body[@id='tinymce']")
	private WebElement textarea;
	
	public String WriteText() {
		
		textarea.clear();
		textarea.sendKeys("inside frame text");
		String textentered=textarea.getText();
		return textentered;
	
	}
}
