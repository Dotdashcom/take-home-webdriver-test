package com.dotdash.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Webdriver {

    private WebDriver driver = null;

    public Webdriver() {
        String path = System.getProperty("user.dir");
        String chrome_driver_path = path + "/resources/drivers/chromedriver";
        String download_folder_path = path + "/downloads";
        System.setProperty("webdriver.chrome.driver", chrome_driver_path);
        Map<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", download_folder_path);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public WebDriver get_chrome_driver() {
        return driver;
    }

    public void open_page(String path) {
        driver.get("https://the-internet.herokuapp.com/");
    }
}
