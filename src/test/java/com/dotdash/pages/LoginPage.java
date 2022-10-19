package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy (id = "username")
    public WebElement username;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy (className = "radius")
    public WebElement loginBtn;

    @FindBy (id = "flash")
    public WebElement resultMsg;

}
