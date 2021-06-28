package utilities;

import com.sun.tools.internal.jxc.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {


        if (driver == null) {
            switch (ReadConfig.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
        }


        return driver;
    }
    /**
     * This method will close all open browsers of current WebDriver object and initialize it as null
     */
    public static void quitDriver(){
        getDriver().quit();
        driver = null;

}}
