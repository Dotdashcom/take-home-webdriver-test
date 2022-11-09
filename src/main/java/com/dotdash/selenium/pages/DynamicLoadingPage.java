package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage extends BasePage {
    @FindBy(css="a[href*=\"2\"]")
    WebElement link2;

    @FindBy(css="div[id=\"start\"] button")
    WebElement startButton;

    @FindBy(id="finish")
    WebElement message;


    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void start(){
        link2.click();
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(message));
    }

    public String getMessage(){
        return message.getText();
    }

}
