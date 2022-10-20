package com.internet.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class NotificationMessagePage extends Page {
	private static final String PAGE_URL = "/notification_message_rendered";

	public NotificationMessagePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By clickLink = By.cssSelector("#content a");
	private By message = By.cssSelector("#flash");

	public void clickLink() {
		((ProxyDriver) driver).click(clickLink);
	}

	public String getTextHeader() {
		return ((ProxyDriver) driver).getText(message).replaceAll("×", "").trim();
	}

	public ArrayList<String> expectedNotificationMessages() {
		ArrayList<String> actualmessages = new ArrayList<String>();
		actualmessages.add("Action successful");
		actualmessages.add("Action unsuccesful, please try again");
		actualmessages.add("Action Unsuccessful");
		return actualmessages;
	}

}