package com.internet.pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import com.internet.utilities.ConfigurationReader;
import com.internet.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    static Logger log = LogManager.getLogger(BasePage.class.getName());
    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(ConfigurationReader.getProperty("browser")), Duration.ofSeconds(150));
    protected WebDriver driver = Driver.getDriver(ConfigurationReader.getProperty("browser"));
    protected Actions action = new Actions(driver);
    protected FluentWait<WebDriver> waitFluent = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(3))
            .ignoring(NoSuchElementException.class);

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(ConfigurationReader.getProperty("browser")),this);
    }




}
