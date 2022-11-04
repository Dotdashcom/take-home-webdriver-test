package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

public class CheckBoxesPage extends GeneralPage {

	public CheckBoxesPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	private static final String PAGE_URL = "/checkboxes";
	private By checkBox1 = By.cssSelector("input[type=checkbox]:nth-child(1)");
	private By checkBox2 = By.cssSelector("input[type=checkbox]:nth-of-type(2)");

	public void clickCheckBox1() {
		((ProxyDriver) wd).click(checkBox1);
	}

	public void clickCheckBox2() {
		((ProxyDriver) wd).click(checkBox2);
	}

	public boolean isCheckBox1Selected() {
		return ((ProxyDriver) wd).isSelected(checkBox1);
	}

	public boolean isCheckBox2Selected() {
		return ((ProxyDriver) wd).isSelected(checkBox2);
	}

	public boolean isCheckBoxesSelected() {
		if (isCheckBox1Selected() && isCheckBox2Selected()) {    // method for testing if all check boxes selected 
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