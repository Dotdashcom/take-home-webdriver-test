package com.dotdash.pages;

import annotations.NotVisible;
import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

@Url("/login")
public class Login extends WebPage {

    @NotVisible
    @FindBy(css = ".error")
    private WebElement invalidCredentialsLabel;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    public Login enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public Login enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public LoginSuccess login() {
        click(loginButton);
        return new LoginSuccess();
    }

    public Login loginInvalid() {
        click(loginButton);
        return this;
    }

    public String getInvalidCredentialsMessage() {
        return invalidCredentialsLabel.getText();
    }
}
