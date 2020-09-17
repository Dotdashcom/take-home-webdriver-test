package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMsgPage {
	public WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Click here')]")
	WebElement msg;
	@FindBy(xpath = "//div[@id='flash']")
	WebElement clickButton;
	String message;

	public NotificationMsgPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// paageObjectModel using selenium pagefactory

	}
	public void Message(){
		msg.click();
		message = clickButton.getText();
	}
}
