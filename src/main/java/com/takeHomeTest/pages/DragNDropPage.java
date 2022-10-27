package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class DragNDropPage extends Page {

	public DragNDropPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By boxA = By.cssSelector("div#column-a");
	private By boxB = By.cssSelector("div#column-b");

	public void dragNdrop() {
		((ProxyDriver) wd).dragAndDrop(boxA, boxB);

	}

	public String getTextFromBoxA() {
		return ((ProxyDriver) wd).getText(boxA);
	}

	public String getTextFromBoxB() {
		return ((ProxyDriver) wd).getText(boxB);
	}
	
	public boolean isTextExchanged() {
		if(getTextFromBoxA().equals("B") && getTextFromBoxB().equals("A")) {
			return true;
		} else
			return false;
	}

}
