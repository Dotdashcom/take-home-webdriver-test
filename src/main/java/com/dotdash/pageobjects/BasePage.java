package com.dotdash.pageobjects;

import com.dotdash.utils.commons.PropertiesManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static final String BASEURL = PropertiesManager.getInstance().getProperty("baseurl");
    protected WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.CSS,using = "#flash")
    protected WebElement alertElement;


    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForVisibilityOf(WebElement element) {
        wait.until(webDriver -> element.isDisplayed());
        return element;
    }


    public WebElement waitForClickabilityOf(WebElement element) {
        wait.until(driverLambda -> element.isDisplayed() && element.isEnabled());
        return element;
    }

    public WebElement waitForAvailabilityOfFrame(WebElement element) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        return element;
    }


    public Select selectFromDropdown(WebElement element) {
        return new Select(element);
    }

    public Alert waitForAlertAvailability() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public List<WebElement> waitForClickabilityOf(List<WebElement> elements) {
        elements.forEach(element -> wait.until(driverLambda -> element.isDisplayed() && element.isEnabled()));
        return elements;
    }

    public WebElement waitForClickabilityOf(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        return driver.findElement(elementBy);
    }

    public WebElement waitForVisibilityOf(By elementBy) {
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
        return driver.findElement(elementBy);
    }
}