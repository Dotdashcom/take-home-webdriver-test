package com.rtr.testbase;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rtr.utils.ConfigsReader;
import com.rtr.utils.Constants;


public class BaseClass {
    public static WebDriver driver;
    /**
     * This method will create a driver and return it
     * 
     * @return WebDriver driver
     */
    
    public static WebDriver setUp(String endpoint) {

    	ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		if (ConfigsReader.getPropertyFromProp("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
		}
		PageInitializerr.initialize();
        driver.manage().window().maximize();
		driver.get(ConfigsReader.getPropertyFromProp("url") + endpoint);
		return driver;
	}
    
    /**
     * This method will quit the browser
     */
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}