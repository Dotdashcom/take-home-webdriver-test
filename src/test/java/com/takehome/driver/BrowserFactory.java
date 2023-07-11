package com.takehome.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import java.util.HashMap;
import java.util.Map;

import static com.takehome.config.ConfigurationManager.configuration;

public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver createLocalDriver() {
            WebDriverManager.chromedriver().setup();

            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            String downloadDir = System.getProperty("user.dir") + "/src";
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.default_directory", downloadDir);
            var chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.setExperimentalOption("prefs", prefs);
            if (configuration().headless()) chromeOptions.addArguments("--headless=new");

            return chromeOptions;
        }
    };

    /**
     * Used to run local tests where the WebDriverManager will take care of the driver
     *
     * @return a new WebDriver instance based on the browser set
     */
    public abstract WebDriver createLocalDriver();

    /**
     * @return a new AbstractDriverOptions instance based on the browser set
     */
    public abstract AbstractDriverOptions<?> getOptions();
}
