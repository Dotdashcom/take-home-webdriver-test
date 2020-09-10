package com.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BaseClass {

	public static WebDriver driver;

    private static String BaseUrl = "http://localhost:7080";

    public static void setUp(String endPoint) {
        System.setProperty("webdriver.chrome.driver", "/Users/andrii/eclipse-workspace/Task/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get(BaseUrl + "/" + endPoint);
        PageInitializer.initialize();
        
        


    }

    public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}
