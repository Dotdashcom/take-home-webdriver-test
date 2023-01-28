package com.anaris.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy (id = "username")
    public WebElement inputUsername;

    @FindBy (id = "password")
    public WebElement inputPassword;

    @FindBy (css = "button[type='submit']")
    public WebElement submit;

    @FindBy (xpath = "//div/div/div")
    public WebElement actualLoggedMsg;

    public void login(String userName, String passWord){
        inputUsername.sendKeys(userName);
        inputPassword.sendKeys(passWord);
        submit.click();
    }



}
