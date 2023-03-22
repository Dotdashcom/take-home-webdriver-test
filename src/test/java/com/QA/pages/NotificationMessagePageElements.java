package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class NotificationMessagePageElements extends CommonMethods {			
	
	@FindBy(css = "a[href='/notification_message']")
	public WebElement clickHere;
	
	@FindBy(id = "flash")
	public WebElement flashMessage;	
	
	public NotificationMessagePageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
