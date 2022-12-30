package com.takehome.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverScript {

	public WebDriver driver;
	public  Properties prop;

	public DriverScript() {
		// TODO Auto-generated constructor stub

		try {

			// Create a object of Properties class and Pass fis as argument

			File src = new File("./config/Config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			initialization();

		} catch (Exception e) {

			System.out.println("File not found" + e.getMessage());
		}

	}

	public void initialization() {
		// TODO Auto-generated method stub
		try {
			String browser = prop.getProperty("Browser");
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Browser/chromedriver 4");
				driver = new ChromeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			System.out.println("Unable to Load URL" + e.getMessage());
		}

	}
	
	public WebDriver getDriver()
	{
		return this.driver;
	}
	
	public String getBaseURL()
	{
		return prop.getProperty("BASEURL");
	}

}
