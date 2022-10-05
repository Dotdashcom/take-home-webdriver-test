package com.dotdash.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(css = "button.radius")
    public WebElement loginBtn;

    @FindBy(css = "div.flash.success")
    public WebElement successMsg;

    @FindBy(css = "div.flash.error")
    public WebElement errorMsg;

}
