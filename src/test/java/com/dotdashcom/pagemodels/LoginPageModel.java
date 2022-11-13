package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageModel extends PageObject {

    public static final String PAGE_URL = "/login";
    private static final String USERNAME = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";
    private static final String WRONG_USERNAME = "WrongUsername";
    private static final String WRONG_PASSWORD = "Wrong#But.Secure*Password!";
    public static final String INVALID_USERNAME_MESSAGE = "Your username is invalid!";
    public static final String INVALID_PASSWORD_MESSAGE = "Your password is invalid!";

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement message;

    public LoginPageModel(WebDriver driver) {
        super(driver);
    }

    public void enterUsername() {
        this.usernameInput.sendKeys(USERNAME);
    }

    public void enterPassword() {
        this.passwordInput.sendKeys(PASSWORD);
    }

    public void enterWrongUsername() {
        this.usernameInput.sendKeys(WRONG_USERNAME);
    }

    public void enterWrongPassword() {
        this.passwordInput.sendKeys(WRONG_PASSWORD);
    }

    public void pressLoginButton() {
        this.loginButton.click();
    }

    public String getMessageText() {
        return message.getText();
    }
}
