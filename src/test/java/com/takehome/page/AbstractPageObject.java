package com.takehome.page;

import com.takehome.driver.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.takehome.config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

public class AbstractPageObject {

    protected WebDriver driver = DriverManager.getDriver();
    protected WebDriverWait wait;

    protected AbstractPageObject() {
        initElements(new AjaxElementLocatorFactory(driver, configuration().timeout()), this);
        wait = new WebDriverWait(driver, Duration.of(configuration().timeout(), ChronoUnit.SECONDS));
    }

    protected boolean isElementDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ignore) {
            return false;
        }
    }
}
