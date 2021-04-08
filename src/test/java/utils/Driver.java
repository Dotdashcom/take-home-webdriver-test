package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static String propertyPath = "src/test/resources/config/configuration.properties";
    private static WebDriver driver;

    /**
     * This method is used to get instance of a WebDriver object. If it is null, new instance will be created.
     * @return will return WebDriver object
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.readProperty("browser", propertyPath)) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Invalid browser type");
            }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }

    /**
     * This method will close all open browsers of current WebDriver object and initialize it as null
     */
    public static void quitDriver(){
        getDriver().quit();
        driver = null;
    }
}
