package com.ddm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends WebPage {

    @FindBy(id = "username")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(css = "#flash")
    protected WebElement statusTextField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        userNameField.clear();
        userNameField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getStatusText() {
        return statusTextField.getText();
    }
}
