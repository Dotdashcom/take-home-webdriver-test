package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class NotificationMessagePageElements extends CommonMethods {
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/p/a")
	public static WebElement clicklink;
	
	@FindBy(css = "#flash")
	public static WebElement msg;

	public NotificationMessagePageElements() {
		PageFactory.initElements(driver, this);
	}

}
