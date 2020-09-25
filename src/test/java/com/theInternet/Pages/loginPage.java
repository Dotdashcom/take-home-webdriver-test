package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {

    @FindBy(id = "username")
    public WebElement userNameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id='login']/button/i")
    public WebElement loginButton;

    @FindBy(id = "flash")
    public WebElement message;


}
