package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = "button.radius")
    private WebElement loginButton;

    @FindBy(css = "div[class='flash success']")
    private WebElement successFlashText;

    @FindBy(css = "div[class='flash error']")
    private WebElement failFlashText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String successLogin(String username, String password) {
        doLogin(username, password);

        return successFlashText.getText();
    }

    public String failLogin(String username, String password) {
        doLogin(username, password);

        return failFlashText.getText();
    }
    
    private void doLogin(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
