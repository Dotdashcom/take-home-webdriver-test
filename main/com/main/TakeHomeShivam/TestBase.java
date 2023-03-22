package com.main.TakeHomeShivam;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;


public abstract class TestBase {
	
	ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public static String baseURL = "http://localhost:7080/";
	
	public WebDriver getDriver() {
		DriverUtils tl =  DriverUtils.getInstance();
		return tl.getDriver();
	}
	
	protected void browser(String browserName) {
		DriverUtils tl =  DriverUtils.getInstance();
	    tl.setDriver(browserName);
	}
	
	public void init()
	{
		// This method can be used as common for base urls
		browser("chrome");
		getDriver().get(baseURL);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void init(String webPageName)
	{
		// This method can be used to directly load any redirect pages related to the base urls
		browser("chrome");
		getDriver().get(baseURL+webPageName);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
}
