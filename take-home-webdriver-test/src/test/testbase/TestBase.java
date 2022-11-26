package com.framework.testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestBase {

    protected ChromeDriver driver;

    protected WebDriver getDriver() {
        return this.driver;
    }

    protected void setup() {
        launchApp();
    }

    protected void cleanup() {
        this.driver.quit();
    }

    private static boolean isCurrentOSUnixBased() {
        String OS = System.getProperty("os.name").toLowerCase();
        boolean isUnix = (OS.contains("ix") || OS.contains("ux") || OS.contains("freebsd"));
        return isUnix;
    }

    private static ChromeOptions getHeadlessChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        return options;
    }

    private ChromeOptions setDownloadPath(ChromeOptions o) {
        Map<String, Object> p = new HashMap<String, Object>();
        p.put("download.default_directory", System.getProperty("user.dir") + File.separator + "downloadedFiles");
        o.setExperimentalOption("prefs", p);
        return o;
    }

    public void launchApp() {
        WebDriverManager.chromedriver().setup();
        if (isCurrentOSUnixBased()) {
            this.driver = new ChromeDriver(setDownloadPath(getHeadlessChromeOptions()));
        } else {
            ChromeOptions o = new ChromeOptions();
            this.driver = new ChromeDriver(setDownloadPath(o));
        }
        driver.manage().window().maximize();
        long pageLoadTimeout = 60;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(pageLoadTimeout));
    }
}

