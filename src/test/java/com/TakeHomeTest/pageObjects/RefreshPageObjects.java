package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RefreshPageObjects {
	WebDriver ldriver;

	public RefreshPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	}
	
	@FindBy(xpath="//div[@id='content']/div[1]/div[2]")
	public WebElement text1;
}
