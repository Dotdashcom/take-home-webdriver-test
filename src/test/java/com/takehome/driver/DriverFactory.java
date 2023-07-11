package com.takehome.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static com.takehome.config.ConfigurationManager.configuration;
import static com.takehome.driver.BrowserFactory.valueOf;

public class DriverFactory {

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    public WebDriver createInstance() {
        return valueOf(configuration().browser().toUpperCase()).createLocalDriver();
    }

}
