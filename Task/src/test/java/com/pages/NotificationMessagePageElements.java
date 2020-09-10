package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePageElements extends BaseClass {

	// "Click here" location
	@FindBy(xpath = "//a[contains(@href,'message')]")
	public WebElement clickHere;
	
	//Notification Message
	@FindBy(xpath = "//div[@id='flash']")
	public WebElement actMessage;
	
	
	public NotificationMessagePageElements() {
		PageFactory.initElements(driver, this);
	}
}
