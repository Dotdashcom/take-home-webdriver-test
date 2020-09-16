package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class Driver {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver(){

    }

    public static WebDriver get() {
        if (driverPool.get() == null) {
            System.out.println("Creating driver!");
            String browserParamFromEnv = System.getProperty("browser");
            String browser = browserParamFromEnv == null ? ConfigurationReader.getProperty("browser") : browserParamFromEnv;
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();

                    HashMap<String, Object> chromePrefs = new HashMap();
                    chromePrefs.put("profile.default_content_settings.popups", 0);
                    chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"/target/downloads");
                    driverPool.set(new ChromeDriver(new ChromeOptions().setExperimentalOption("prefs", chromePrefs)));
                    break;

                case "chrome_headless":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                default:
                    throw new RuntimeException("Invalid browser name!");
            }
        }
        return driverPool.get();
    }

    public static void close() {
        driverPool.get().quit();
        driverPool.remove();
    }
}
