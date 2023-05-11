package com.dotDash.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy (id = "username")
    WebElement username;
    @FindBy (id = "password")
    WebElement password;
    @FindBy(id = "flash")
    WebElement message;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getMessage() {
        return message;
    }

    public void loginOnPage(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password, Keys.ENTER);
    }
}
