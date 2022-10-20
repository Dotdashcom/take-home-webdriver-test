package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class MouseHoverPage extends Page {
	private static final String PAGE_URL = "/hovers";

	public MouseHoverPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By firstImage = By.cssSelector("div.example div.figure:first-of-type img");
	private By secondImage = By.cssSelector("div.example div.figure:nth-of-type(2) img");
	private By thirdImage = By.cssSelector("div.example div.figure:last-of-type img");
	private By firstHeader = By.cssSelector("div.example div.figure:first-of-type h5");
	private By secondHeader = By.cssSelector("div.example div.figure:nth-of-type(2) h5");
	private By thirdHeader = By.cssSelector("div.example div.figure:last-of-type h5");

	public void mouseHoverFirstImage() {
		((ProxyDriver) driver).mouseHoverElement(firstImage);
	}

	public void mouseHoverSecondImage() {
		((ProxyDriver) driver).mouseHoverElement(secondImage);
	}

	public void mouseHoverThirdImage() {
		((ProxyDriver) driver).mouseHoverElement(thirdImage);
	}

	public boolean firstHeaderIsDisplayed() {
		return ((ProxyDriver) driver).isDisplayed(firstHeader);
	}

	public boolean secondHeaderIsDisplayed() {
		return ((ProxyDriver) driver).isDisplayed(secondHeader);
	}

	public boolean thirdHeaderIsDisplayed() {
		return ((ProxyDriver) driver).isDisplayed(thirdHeader);
	}
}