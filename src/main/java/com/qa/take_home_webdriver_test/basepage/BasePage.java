package com.qa.take_home_webdriver_test.basepage;

import com.qa.take_home_webdriver_test.constants.Paths;
import com.qa.take_home_webdriver_test.utils.ConfigReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log;
    protected static Properties prop;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Paths.WEB_DRIVER_WAIT_TIMEOUT));
        log = Logger.getLogger(BasePage.class.getName());
        prop = ConfigReader.initiateProperties();
    }

    public void navigateToPage(String pageUrl) {
        log.info("User navigates on the " + pageUrl + " page. ");
        driver.navigate().to(pageUrl);
    }
}
