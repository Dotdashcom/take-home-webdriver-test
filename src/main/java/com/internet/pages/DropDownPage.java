package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.ProxyDriver;

public class DropDownPage extends Page {
	private static final String PAGE_URL = "/dropdown";

	public DropDownPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By dropdownMenu = By.cssSelector("#content select");

	public void selectOption1() {
		((ProxyDriver) driver).selectFromDropDown(dropdownMenu, "1");
	}

	public void selectOption2() {
		((ProxyDriver) driver).selectFromDropDown(dropdownMenu, "2");
	}

	public String getSelectedOptions() {
		return ((ProxyDriver) driver).getselectedText(dropdownMenu);
	}
}