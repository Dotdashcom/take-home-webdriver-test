package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="username")
    public WebElement usernameInputBox;
    @FindBy(id="password")
    public WebElement passwordInputBox;
    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='flash success']")
    public WebElement loginSuccessMessage;
    @FindBy(xpath = "//div[@class='flash error']")
    public WebElement loginFailedMessage;






}
