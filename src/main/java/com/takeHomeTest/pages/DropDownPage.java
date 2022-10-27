package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.takeHomeTest.Utils.ProxyDriver;

public class DropDownPage extends Page {

	public DropDownPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By dropDownBtn = By.cssSelector("select#dropdown");

	public void option1Selected() {
		((ProxyDriver) wd).DropDownSelect(dropDownBtn, "1");
	}

	public void option2Selected() {
		((ProxyDriver) wd).DropDownSelect(dropDownBtn, "2");
	}

	public String getSelectedText() {
		return ((ProxyDriver) wd).TextSelected(dropDownBtn);
	}

}
