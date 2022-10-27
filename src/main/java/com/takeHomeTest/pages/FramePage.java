package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class FramePage extends Page {

	public FramePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By iFrameBtn = By.cssSelector("div#content ul li:last-of-type a");

	public IframePage clickiFrameBtn() {
		((ProxyDriver) wd).click(iFrameBtn);
		return new IframePage(wd, true);

	}

	

}
