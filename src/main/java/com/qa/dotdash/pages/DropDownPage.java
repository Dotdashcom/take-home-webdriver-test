package com.qa.dotdash.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dotdash.utils.Proxywrapper;

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

	public String getTextOfSelectedOption() {
		return ((Proxywrapper) driver).getselectedText(dropdownMenu);
	}

}
