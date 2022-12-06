package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;

public class LoginFailurePage extends TestBase{

    //Page Factory - OR:
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath="//div[@id='flash']")
    WebElement loginFailureMessage;

    //Initializing the Page Objects:
    public LoginFailurePage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public void login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
    }

    public String validateLoginFailure(){
        return loginFailureMessage.getText();
    }

}
