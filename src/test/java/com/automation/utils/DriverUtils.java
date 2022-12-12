package com.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverUtils {
    public static final String USERNAME = ConfigReader.getProperty("bs.username");
    public static final String AUTOMATE_KEY = ConfigReader.getProperty("bs.key");
    public static final String URL = String.format(ConfigReader.getProperty("bs.url"),USERNAME,AUTOMATE_KEY);
    static WebDriver driver;


    public static void createDriver()  {
        // Desire capabilities is what type of session we want
        // We can copy-paste below capabilities from Browser Stack website
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("osVersion", "12.0");
        browserstackOptions.put("deviceName", "Samsung Galaxy S22 Ultra");
        browserstackOptions.put("realMobile", "true");
        browserstackOptions.put("local", "false");
        capabilities.setCapability("bstack:options", browserstackOptions);

        switch (ConfigReader.getProperty("browser")) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "remote":
                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(ConfigReader.getProperty("app.baseurl"));
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
