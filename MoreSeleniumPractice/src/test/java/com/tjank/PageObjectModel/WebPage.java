package com.tjank.PageObjectModel;

import org.openqa.selenium.WebDriver;

public abstract class WebPage {

	protected String URL = "http://localhost:7080";
	protected static WebDriver driver;

	public void setup() {}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
