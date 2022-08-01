package com.BostonBragg.TakeHomeWebDriverTest.pom;

import com.BostonBragg.TakeHomeWebDriverTest.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage {
    WebDriver driver;
    By checkboxButton = By.xpath("//*[@id=\"checkbox-example\"]/button");
    By inputButton = By.xpath("//*[@id=\"input-example\"]/button");
    By checkbox = By.id("checkbox");
    By input = By.xpath("//*[@id=\"input-example\"]/input");
    By waitingCheckbox = By.xpath("//form[1]/div[@id=\"loading\"]");
    By waitingInput = By.xpath("//form[2]/div[@id=\"loading\"]");

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckboxButton() {
        driver.findElement(checkboxButton).click();
    }

    public void clickInputButton() {
        driver.findElement(inputButton).click();
    }

    public boolean checkIfCheckboxIsPresent() {
        try {
            return DriverUtils.findElementWithWait(driver, checkbox).isDisplayed();
        } catch(NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean checkIfInputIsEnabled() {
        return DriverUtils.findElementWithWait(driver, input).isEnabled();
    }

    public void waitUntilCheckboxLoadingIsDone() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(waitingCheckbox));
    }

    public void waitUntilInputLoadingIsDone() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // This try-catch block is necessary because the waitingInput element has a tendency to not disappear when it should
        // If the element does not disappear, this function essentially just waits for 5 seconds
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(waitingInput));
        } catch(TimeoutException ignored) {}
    }
}
