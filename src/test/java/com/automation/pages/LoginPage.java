package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id="username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "//button[@class='radius']")
    public WebElement loginButton;

    @FindBy(css="#flash")
    public WebElement loginMessage;
}
