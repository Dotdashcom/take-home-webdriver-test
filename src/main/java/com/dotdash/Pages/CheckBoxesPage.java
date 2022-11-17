package com.dotdash.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ProxyDriver;

public class CheckBoxesPage extends Page {
	private static final String PAGE_URL = "/checkboxes";

	public CheckBoxesPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By checkBox1 = By.cssSelector("#checkboxes input:first-of-type");
	private By checkBox2 = By.cssSelector("#checkboxes input:last-of-type");


	public void selectCheckBox1() {
		((ProxyDriver) driver).click(checkBox1);
	}

	public void selectCheckBox2() {
		((ProxyDriver) driver).click(checkBox2);
	}

	public boolean isCheckBox1Selected() {
		return ((ProxyDriver) driver).isSelected(checkBox1);
	}

	public boolean isCheckBox2Selected() {
		return ((ProxyDriver) driver).isSelected(checkBox2);
	}

	public boolean isCheckBoxesSelected() {
		if (isCheckBox1Selected() && isCheckBox2Selected()) {
			return true;
		}
		return false;
	}

}
