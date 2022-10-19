package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;

public class HoversPage extends Page {
	private static final String PAGE_URL = "/hovers";

	public HoversPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By firstImage = By.cssSelector("div.example div.figure:first-of-type img");
	private By secondImage = By.cssSelector("div.example div.figure:nth-of-type(2) img");
	private By thirdImage = By.cssSelector("div.example div.figure:last-of-type img");
	private By firstHeader = By.cssSelector("div.example div.figure:first-of-type h5");
	private By secondHeader = By.cssSelector("div.example div.figure:nth-of-type(2) h5");
	private By thirdHeader = By.cssSelector("div.example div.figure:last-of-type h5");

	public void mouseHoverFirstImage() {
		((Proxywrapper) driver).mouseHoverElement(firstImage);
	}

	public void mouseHoverSecondImage() {
		((Proxywrapper) driver).mouseHoverElement(secondImage);
	}

	public void mouseHoverThirdImage() {
		((Proxywrapper) driver).mouseHoverElement(thirdImage);
	}

	public boolean firstHeaderIsDisplayed() {
		return ((Proxywrapper) driver).isDisplayed(firstHeader);
	}

	public boolean secondHeaderIsDisplayed() {
		return ((Proxywrapper) driver).isDisplayed(secondHeader);
	}

	public boolean thirdHeaderIsDisplayed() {
		return ((Proxywrapper) driver).isDisplayed(thirdHeader);
	}
}
