package com.academy.techcenture.driver;

import com.academy.techcenture.configReader.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){
        String browser = ConfigReader.getProperty("browser").trim().toLowerCase();

        int pageLoadTime = Integer.parseInt(ConfigReader.getProperty("pageLoadTime"));
        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicitWait"));
        int scriptTimeout = Integer.parseInt(ConfigReader.getProperty("scriptTimeout"));

        switch (browser) {
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                Map<String,Object> prefs = new HashMap<String, Object>();
                prefs.put("autofill.profile_enabled", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.default_content_setting_values.notifications", 2);
                options.setExperimentalOption("prefs",prefs);
                driver = new ChromeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Driver not found");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptTimeout));
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver(){
        if(driver != null) {
            driver.quit();
        }
    }



}
