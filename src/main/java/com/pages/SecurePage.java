package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SecurePage {
	
	public SecurePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div#flash")
	public WebElement flasMessage;

}
