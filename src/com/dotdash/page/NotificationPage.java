package com.dotdash.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/notification_message_rendered";
	private static final List<String> NOTIFICATIONS = Arrays.asList("Action successful", "Action unsuccesful, please try again");
	private WebElement notificationLink;
	private WebElement flashMessages;

	public NotificationPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		verifyPage(false);
	}

	public void verifyPage(boolean expectingNotification) {
		notificationLink = driver.findElement(By.cssSelector("a[href='/notification_message']"));
		assertTrue(notificationLink.isDisplayed());
		
		flashMessages = driver.findElement(By.id("flash-messages"));
		assertTrue(flashMessages.isDisplayed());
		if (expectingNotification) {
			String notificationText = flashMessages.getText().trim();
			long count = NOTIFICATIONS.stream().filter(n -> notificationText.contains(n)).count();
			assertEquals(count, 1);
		} else {
			assertEquals(flashMessages.getText().trim(), "");
		}
	}
	
	public NotificationPage loadNewNotificationMessage() {
		notificationLink.click();
		return new NotificationPage(driver);
	}
}
