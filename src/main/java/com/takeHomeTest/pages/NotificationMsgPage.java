package com.takeHomeTest.pages;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class NotificationMsgPage extends Page {

	public NotificationMsgPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By clickHereBtn = By.cssSelector("div.example a");
	private By msgDisplayed = By.cssSelector("div#flash");

	public void clickBtn() {
		((ProxyDriver) wd).click(clickHereBtn);
	}

	public String getMsg() {
		return ((ProxyDriver) wd).getText(msgDisplayed).replaceAll("×", "").trim();
	}

	// creating a list of all possible messages and comparing if message given from the list
	public boolean msgContaines(String message) {
		ArrayList<String> msgList = new ArrayList<String>(
				Arrays.asList("Action successful", "Action unsuccesful, please try again", "Action Unsuccessful"));
		return msgList.contains(message);

	}

}
