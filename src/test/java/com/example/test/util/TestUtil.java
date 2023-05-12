package com.example.test.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	 String driverName;
	 String driverPath;

	public TestUtil() {
		Properties properties = new Properties();

		try {
			InputStream input = new FileInputStream("driver.properties");
			// Load the properties file
			properties.load(input);

			// Access the properties
			 driverName = properties.getProperty("driverName");
			 driverPath = properties.getProperty("driverPath");

			// Use the properties in your code
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  String getDriverName() {
		return driverName;
	}
	
	public  String getDriverPath() {
		return driverPath;
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		if (null != driverName && driverName.contains("chrome")) {
		return new ChromeDriver();	
		}
		return null;
	}
}
