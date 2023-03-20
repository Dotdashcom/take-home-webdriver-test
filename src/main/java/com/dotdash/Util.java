package com.dotdash;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Util {
	
	protected static WebDriver driver;
	public static Properties prop;

	public Util(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/jitender.yadav1/eclipse-workspace/test/src/main/resources/configs/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        return driver;
    }
    
    public void teardown(){
        driver.quit();
    }
}
