package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;



public class ContextMenuPage extends GeneralPage {
	private static final String PAGE_URL = "/context_menu";

	public ContextMenuPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By contextMenu = By.id("hot-spot");

	public void rightClickContextMenu() {
		((ProxyDriver) wd).contextClick(contextMenu);
	}

	public String textFromAlert() {
		return ((ProxyDriver) wd).textFromAlert();
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
