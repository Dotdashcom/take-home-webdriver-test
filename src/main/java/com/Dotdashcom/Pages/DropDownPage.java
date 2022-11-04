package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;


public class DropDownPage extends GeneralPage {
	private static final String PAGE_URL = "/dropdown";

	public DropDownPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By dropdownMenu = By.id("dropdown");

	public void selectOption1() {
		((ProxyDriver) wd).selectFromDropDown(dropdownMenu, "1");
	}

	public void selectOption2() {
		((ProxyDriver) wd).selectFromDropDown(dropdownMenu, "2");
	}

	public String getSelectedOptionsText() {
		return ((ProxyDriver) wd).getselectedText(dropdownMenu);
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
