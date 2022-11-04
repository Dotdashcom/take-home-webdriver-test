package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;


public class NotificationMessagePage extends GeneralPage {
	private static final String PAGE_URL = "/notification_message_rendered";

	public NotificationMessagePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By clickLink = By.cssSelector("#content>a");
	private By message = By.id("#flash");

	public void clickLink() {
		((ProxyDriver) wd).click(clickLink);
	}

	public String getTextHeader() {
		return ((ProxyDriver) wd).getText(message).replaceAll("×", "").trim();
	}

	public ArrayList<String> expectedNotificationMessages() {
		ArrayList<String> actualmessages = new ArrayList<String>();
		actualmessages.add("Action successful");
		actualmessages.add("Action unsuccesful, please try again");
		actualmessages.add("Action Unsuccessful");
		return actualmessages;
	} 
	@Override
	protected void isLoaded() throws Error {
		if (!urlContains(wd.getCurrentUrl())) {
			fail("Page didn't load");
		}
	}

	@Override
	public String getPageURL() {
		return String.format("%s%s", getDomain(), PAGE_URL);
	}

}
