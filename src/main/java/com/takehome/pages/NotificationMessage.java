package com.takehome.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessage {
	
WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/p/a")
	WebElement clickHereLink;
	
	@FindBy(id = "flash")
	WebElement alertElement;
	

	public NotificationMessage(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" + "notification_message_rendered";
		driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getClickHereLink()
	{
		return clickHereLink;
	}

	public WebElement getAlertElement()
	{
		return alertElement;
	}
}
