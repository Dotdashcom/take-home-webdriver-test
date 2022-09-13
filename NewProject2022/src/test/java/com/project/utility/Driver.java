package com.project.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver obj;


    private Driver(){
    }

    /*
    We make WebDriver private because we want to close access outside of the class
    We make it static because we will use it in a static method
     */

    private static WebDriver driver;

    /*
    Create a re-usable utility method which will return same driver instance when we call it
       */

    public static WebDriver getDriver(){

        if(driver == null){
            /*
            We read our browserType from configuration.properties.
            This way,we can control which browser is opened from  outside our code,from configuration.properties
             */

            String browserType = ConfigReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }

        }

        return driver;
    }

    /*
    This method will make sure our driver value is always null after using quit() method
    */

    public static void closeDriver(){
        if(driver !=null){
            driver.quit(); //this line will terminate the existing session. value will not even be null
            driver = null;
        }
    }

    /**
     * Quitting the browser and setting the value of
     * WebDriver instance to null because you can re-use already quitted driver
     */
    public static void closeBrowser(){
        /**check if we have WebDriver instance or not
        *basically checking if obj is null or not
        *if not null
        *quit the browser
        *make it null, because once quit it can not be used
         */

        if(obj!=null){
            obj.quit();
            obj = null;
        }

    }




}
