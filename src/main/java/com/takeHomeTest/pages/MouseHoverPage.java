package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class MouseHoverPage extends Page {

	public MouseHoverPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By imageOne = By.cssSelector("div.example div.figure:nth-of-type(1) img");
	private By imageTwo = By.cssSelector("div.example div.figure:nth-of-type(2) img");
	private By imageThird = By.cssSelector("div.example div.figure:nth-of-type(3) img");

	private By firstImageInfo = By.cssSelector("div.example div.figure:nth-of-type(1) h5");
	private By secondImageInfo = By.cssSelector("div.example div.figure:nth-of-type(2) h5");
	private By thirdImageInfo = By.cssSelector("div.example div.figure:nth-of-type(3) h5");

	public void hoverOverImageOne() {
		((ProxyDriver) wd).mouseHoverElement(imageOne);
	}

	public void hoverOverImageTwo() {
		((ProxyDriver) wd).mouseHoverElement(imageTwo);
	}

	public void hoverOverImageThird() {
		((ProxyDriver) wd).mouseHoverElement(imageThird);
	}

	public boolean IsfirstHeaderDisplayed() {
		return ((ProxyDriver) wd).isDisplayed(firstImageInfo);
	}

	public boolean IsSecondHeaderDisplayed() {
		return ((ProxyDriver) wd).isDisplayed(secondImageInfo);
	}

	public boolean IsThirdHeaderDisplayed() {
		return ((ProxyDriver) wd).isDisplayed(thirdImageInfo);
	}

}
