package com.dotDash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotDash.qa.base.TestBase;

public class NotificationMessagesPage extends TestBase {

	// Finding the link to the Notification message page
	@FindBy(xpath = "//a[@href='/notification_message']")
	WebElement notificationMsg;

	// Finding the link to get the notification
	@FindBy(xpath = "//a[@href='/notification_message']")
	WebElement notificationGenerator;

	// Finding the notification element
	@FindBy(id = "flash")
	WebElement notification;

	// Initializing the Page Objects:
	public NotificationMessagesPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// Notification test function
	public String newNotification() {
		notificationMsg.click();
		notificationGenerator.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String str = notification.getText();
		return str;

	}
}
