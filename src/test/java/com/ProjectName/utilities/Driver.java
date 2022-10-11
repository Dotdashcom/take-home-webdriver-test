package com.ProjectName.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}// private constructor so we close access so outside this class nobody can make objects of it

    private static WebDriver driver; // value is null by default

    public static WebDriver getDriver(){

        if(driver == null){
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver != null){ // making sure that the value is null after closing the driver
            driver.quit(); // this line will terminate the session if the driver is not null
            driver = null; // this line will make driver null
        }
    }
}
