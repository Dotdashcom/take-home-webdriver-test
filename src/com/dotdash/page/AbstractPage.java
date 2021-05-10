package com.dotdash.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

	protected static final int WAIT_TIME = 3;
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract void verifyPage();
}
