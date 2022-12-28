package com.test.localhost.pages;

import com.test.localhost.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(text(),'Form Authentication')]")
    WebElement formAuthentication;

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(tagName = "i")
    WebElement loginButton;

    @FindBy(tagName = "h4")
    WebElement validMessage;

    @FindBy(xpath = "//i[contains(text(), 'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//div[@id='flash']")
    WebElement errorMessage;

    public void login(String username, String password){
        formAuthentication.click();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String validateMessage(){
        return BrowserUtils.getText(validMessage);
    }
    public void clickLogout(){
        logoutButton.click();
    }
    public String validateErrorMessage(){
        return BrowserUtils.getText(errorMessage);
    }







}
