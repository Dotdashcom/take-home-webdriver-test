package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/login
public class LoginPage {


    @FindBy(id = "username")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//button")
    public WebElement buttonLogin;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement linkLogout;

    @FindBy(css = "div[id='flash']")
    public WebElement divFlash;

    @FindBy(css = "h4[class='subheader']")
    public WebElement h4WelcomeTheSecureArea;

    @FindBy(xpath = "//*[@id='flash']")
    public WebElement loginFailedMsg;
    





    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
