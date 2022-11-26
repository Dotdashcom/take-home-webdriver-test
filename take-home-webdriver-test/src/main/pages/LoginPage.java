package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageObjectBase {
    @FindBy(xpath = "//input[@id='username']")
    private WebElement userInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    private String failedMessageXPath = "//div[@id='flash' and @class='flash error']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/login");
        return this;
    }

    public SecurePage login(String userName, String password) {
        userInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new SecurePage(driver);
    }

    public String validateFailedMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(failedMessageXPath)));
        return driver.findElement(By.xpath(failedMessageXPath)).getText();
    }
}

