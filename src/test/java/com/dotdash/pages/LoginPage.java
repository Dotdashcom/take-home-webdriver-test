package com.dotdash.pages;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

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
