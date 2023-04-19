package com.qa.dotdash.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dotdash.utils.Proxywrapper;

public class ContextMenuPage extends Page {
	private static final String PAGE_URL = "/context_menu";

	public ContextMenuPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By contextBox = By.cssSelector("#hot-spot");

	public void rightClickContextBox() {
		((Proxywrapper) driver).contextClick(contextBox);
	}

	public String alertText() {
		return ((Proxywrapper) driver).alertText();
	}

}
