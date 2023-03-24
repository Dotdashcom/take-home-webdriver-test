package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the Login page.
        if (!"Login Page".equals(driver.findElement(pageHeaderLocator).getText())) {
            throw new IllegalStateException("This is not the Login page");
        }
    }

    // locators
    By pageHeaderLocator = By.xpath("//*[@id='content']/div/h2");
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.xpath("//*[@id='login']/button");
    By logoutButton = By.xpath("//a[@href='/logout']");
    By errorMessageLocator = By.xpath("//*[@id='flash']");

    public void login(String login, String password) {
        driver.findElement(usernameLocator).sendKeys(login);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public boolean isLoggedIn() {
        return driver.findElements(logoutButton).size() == 1;
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessageLocator).getText();
    }

}
