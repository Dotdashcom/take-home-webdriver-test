package org.ithaka.portico.demo.ui.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	
	ChromeDriver  driver = null;
	
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver 2");
		driver = new ChromeDriver();
		return driver;
	}
	
	
	public void closeDriver() {
		//Close current browser
		driver.close();
		
		//Close all the browsers
		driver.quit();
	}
	

}
