package com.BostonBragg.TakeHomeWebDriverTest.pom;

import com.BostonBragg.TakeHomeWebDriverTest.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.tagName("button");
    By successMessage = By.className("success");
    By errorMessage = By.className("error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        DriverUtils.findElementWithWait(driver, usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        DriverUtils.findElementWithWait(driver, passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        DriverUtils.findElementWithWait(driver, loginButton).click();
    }

    public boolean successMessageIsVisible() {
        return DriverUtils.findElementWithWait(driver, successMessage).isDisplayed();
    }

    public boolean errorMessageIsVisible() {
        return DriverUtils.findElementWithWait(driver, errorMessage).isDisplayed();
    }
}
