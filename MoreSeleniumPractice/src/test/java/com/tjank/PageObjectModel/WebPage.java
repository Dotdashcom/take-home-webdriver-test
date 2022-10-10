package com.tjank.PageObjectModel;

import org.openqa.selenium.WebDriver;

public abstract class WebPage {

	protected String URL = "http://localhost:7080";
	protected static WebDriver driver;

	public void setup() {
		String url = this.getUrl();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		assertEquals(driver.getCurrentUrl(),url);
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
