package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class MultipleWindowPage extends Page {

	public MultipleWindowPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By newTabBtn = By.cssSelector("div.example a");

	public NewWindowPage clicknewTabBtn() {
		((ProxyDriver) wd).click(newTabBtn);
		return new NewWindowPage(wd, true);
	}

}
