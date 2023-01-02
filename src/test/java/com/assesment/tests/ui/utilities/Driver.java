package com.assesment.tests.ui.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    /* getDriver() method is used:
        1. SetUp driver
        2. Create driver
        3. return driver
        driver ------->>>> Driver.getDriver()
     */
    public static WebDriver getDriver(){
        if(driver ==null){ //if driver is not pointing anywhere, then instantiate the driver
            switch(ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void closeDriver(){//if driver is pointing somewhere at if driver is being used.
        if(driver !=null){
            driver.quit(); //close the driver
            driver=null; // and make the driver null so that we can
        }
    }

}
