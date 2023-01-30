package com.nparede.project.pagefactory;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final FluentWait<WebDriver> wait;

    public BasePage(WebDriver driver){
        this.driver  = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
        PageFactory.initElements(this.driver,this);
    }

    protected void waitFor(ExpectedCondition<?> waitCondition) {
        wait.until(waitCondition);
    }

    protected void explicitWaitForVisibilityElement(WebElement element) {
        waitFor(ExpectedConditions.visibilityOf(element));
    }
}
