package com.dotdash.pages;

import com.dotdash.utillities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    public Login_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Below here I have locators for web elements on login page.

    @FindBy(id ="username")
    public WebElement usernameBox;

    @FindBy(id ="password")
    public WebElement passwordBox;

    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    public WebElement loginButton;

    @FindBy(id="flash")
    public  WebElement loginSuccessful;

    @FindBy(xpath="//i[@class='icon-2x icon-signout']")
    public WebElement logoutButton;

    @FindBy(id="flash")
    public  WebElement logoutSuccess;

    @FindBy(id="flash")
    public  WebElement invalidUsernameWarning;

    @FindBy(id="flash")
    public  WebElement invalidPasswordWarning;

}
