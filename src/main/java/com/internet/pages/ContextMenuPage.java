package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.internet.utils.ProxyDriver;

public class ContextMenuPage extends Page {
	private static final String PAGE_URL = "/context_menu";

	public ContextMenuPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By contextMenu = By.cssSelector("#hot-spot");

	public void rightClickContextMenu() {
		((ProxyDriver) driver).contextClick(contextMenu);
	}

	public String alertText() {
		return ((ProxyDriver) driver).alertText();
	}
}