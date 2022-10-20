package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;
    @FindBy(xpath = "//div[contains(text(),'You logged into a secure area!')]")
    public WebElement loginSuccess;
    @FindBy(xpath = "//div[contains(text(),'Your password is invalid!')]")
    public WebElement loginFailed;

    public LoginPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
