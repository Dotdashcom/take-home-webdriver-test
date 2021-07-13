package com.selenium.entity;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class DataSingleton {

	final static Logger logger = Logger.getLogger(DataSingleton.class);
	private static DataSingleton instance = new DataSingleton();

	private WebDriver webDriver;
	

	private DataSingleton() {
		// hide default constructor
	}

	public static DataSingleton getInstance() {

		if (instance == null) {

			instance = new DataSingleton();
		}

		return instance;
	}
	

	public void setWebDriver(WebDriver driver) {
		this.webDriver = driver;
	}

	public WebDriver getWebDriver() {
		return this.webDriver;
	}
	
		
}
