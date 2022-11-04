package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

public class DragAndDropPage extends GeneralPage {
	private static final String PAGE_URL = "/drag_and_drop ";

	public DragAndDropPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By ABox = By.id("column-a");
	private By BBox = By.id("column-b");

	public void dragAndDrop() {
		((ProxyDriver) wd).dragAndDrop(ABox, BBox);
	}

	public String getTextA() {
		return ((ProxyDriver) wd).getText(ABox);
	}

	public String getTextB() {
		return ((ProxyDriver) wd).getText(BBox);
	}

	public boolean isTextExchanged() {

		if (getTextA().equals("B") && getTextB().equals("A")) {
			return true;
		}
		return false;
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