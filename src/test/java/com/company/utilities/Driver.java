package com.company.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    // Creating a private constructor, we are closing access to the
    // object of this class from outside the class
    private Driver() {
    }

    // We make WebDriver private, because we want to close access from outside of class
    // We make it static, because we will use it inside static method
    //
     //private static WebDriver driver; // value is null by default

     final static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    // Create a re-usable utility method which will return same driver instance when we call it
    public static WebDriver getDriver() {

       // it will check if driver is null and if it is we will set up browser inside if statement
        // is you already set up driver and using it again for following line of codes, it will return to same driver
        if (driverPool.get() == null) {

        // We read browserType from configuration.properties with
            // help of ConfigurationReader class' getProperty() method
        String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }

                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }
            }

        }

        return driverPool.get();

    }

    // This method will make sure our driver value is always null after using quit() method
    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit(); // this line will terminate the existing driver session. with using this driver will not be even null
            driverPool.remove();  //driver = null
        }

    }
}