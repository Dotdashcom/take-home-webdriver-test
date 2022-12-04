package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.utils.DriverFactory;

public class SecureAreaPage {
	
	private By title = By.cssSelector("#content h2");

	public By getTitle() {
		return title;
	}
}
