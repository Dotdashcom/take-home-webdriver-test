package com.theInternet.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NotificationMessagePage {
	public WebDriver driver;

	@FindBy(linkText = "Click here")
	WebElement clickHere;

	@FindBy(xpath="//div[@id='flash']")
	WebElement notificationMessage;

	public NotificationMessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void VerifyNotificationMessagePage() {

		String Notification_msg = notificationMessage.getText();
		for (int i = 0; i < 3; i++) {
			clickHere.click();
			if (Notification_msg.contains("Action unsuccessful, please try again")) {
				Assert.assertTrue(Notification_msg.contains("Action unsuccessful, please try again"));
			} else if (Notification_msg.contains("Action successful")) // Validating Scenario-2
			{
				Assert.assertTrue(Notification_msg.contains("Action successful"));
			}

		}

	}

}