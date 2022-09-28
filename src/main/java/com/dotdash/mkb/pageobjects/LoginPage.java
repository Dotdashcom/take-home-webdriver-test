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

    public String successLogin() {
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();

        return successFlashText.getText();
    }

    public String failLogin() {
        username.sendKeys("tomsmith");
        password.sendKeys("adsfasdf!");
        loginButton.click();

        return failFlashText.getText();
    }
}
