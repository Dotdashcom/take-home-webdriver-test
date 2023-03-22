package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.util.Config;

public class DynamicLoadingPage {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.cssSelector("#loading");
    private By finishText = By.cssSelector("#finish h4");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("dynamicloading"));
    }

    public void clickStartButtonAndWait() {
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
    }

    public String getFinishText() {
        return driver.findElement(finishText).getText();
    }
}
