package com.takehome.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPageObject {

    @FindBy(css = "#username")
    private WebElement usernameField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement loginButton;

    @FindBy(css = ".flash.error")
    private WebElement flashMessagesBanner;

    @Step
    public LoginPage fillUsername(String usrName) {
        this.usernameField.sendKeys(usrName);
        return this;
    }

    @Step
    public LoginPage fillPassword(String usrName) {
        this.passwordField.sendKeys(usrName);
        return this;
    }

    @Step
    public LoginPage clickLogin() {
        this.loginButton.click();
        return this;
    }

    @Step
    public boolean isLoginErrorBannerDisplayed() {
        return isElementDisplayed(flashMessagesBanner);
    }
}
