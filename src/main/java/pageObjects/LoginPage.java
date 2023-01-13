package pageObjects;

import baseClasses.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.constant.Constable;

public class LoginPage extends Base {
    WebDriver driver;

    String user = readValue("loginPage.usernameXp");
    String pass = readValue("loginPage.passwordXp");
    By usernameInput = By.xpath(readValue("loginPage.usernameInputXp"));
    By passwordInput = By.xpath(readValue("loginPage.passwordInputXp"));
    By loginButton = By.xpath(readValue("loginPage.loginButtonXp"));
    By dataAlert = By.xpath(readValue("loginPage.dataAlertXp"));

    public void validLogin() {
        driver.findElement(usernameInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public void failedLogin() {
        driver.findElement(usernameInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys("invalid pass");
        driver.findElement(loginButton).click();
    }

    public String dataAlert() {
        return driver.findElement(dataAlert).getText();
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}