package com.BostonBragg.TakeHomeWebDriverTest.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverLogLevel;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class DriverUtils {
    public static WebDriver initializeDriver() throws Exception {
        String operatingSystem = System.getProperty("os.name").toLowerCase();
        boolean isWindows = (operatingSystem.contains("win"));
        boolean isUnix = (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.indexOf("aix") > 0);

        if(isUnix) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        } else if(isWindows) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        } else {
            throw new Exception("Operating system not supported, please use Windows or Unix");
        }

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setLogLevel(ChromeDriverLogLevel.OFF);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        return new ChromeDriver(chromeOptions);
    }

    public static void teardownDriver(WebDriver driver) {
        driver.quit();
    }

    public static void openPage(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static WebElement findElementWithWait(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static Alert findAlertWithWait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
