package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;

public class DropDownPage extends Page {
	private static final String PAGE_URL = "/dropdown";

	public DropDownPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By dropdownMenu = By.cssSelector("#content select");

	public void selectOption1() {
		((Proxywrapper) driver).selectFromDropDown(dropdownMenu, "1");
	}

	public void selectOption2() {
		((Proxywrapper) driver).selectFromDropDown(dropdownMenu, "2");
	}

	public String getSelectedOptionsText() {
		return ((Proxywrapper) driver).getselectedText(dropdownMenu);
	}
}
