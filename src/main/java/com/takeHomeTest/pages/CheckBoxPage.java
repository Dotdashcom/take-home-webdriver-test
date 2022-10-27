package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class CheckBoxPage extends Page {

	public CheckBoxPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By checkBox1 = By.cssSelector("form#checkboxes input:first-of-type");
	private By checkBox2 = By.cssSelector("form#checkboxes input:last-of-type");

	public void clickcheckBox1() {
		((ProxyDriver) wd).click(checkBox1);
	}

	public void clickcheckBox2() {
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

}
