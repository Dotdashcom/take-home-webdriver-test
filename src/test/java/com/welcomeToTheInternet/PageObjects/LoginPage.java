package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver localDriver;
    public LoginPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/login']")
    @CacheLookup
    WebElement linkLogin;

    @FindBy(id = "username")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(id = "password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    WebElement btnSubmit;

    public void clickLoginLink() {
        linkLogin.click();
    }
    public void setUserName(String username) {
        txtUserName.sendKeys(username);
    }

    public void setUserPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickSubmit() {
        btnSubmit.click();

    }
}
