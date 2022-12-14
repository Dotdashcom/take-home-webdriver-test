package com.company.pages;

import com.company.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//*[@id='username']")
    public WebElement inputUserName;

    @FindBy(xpath="//*[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath="//*[@id='login']/button")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[contains(.,'secure area!')]")
    public WebElement validCredentialsMsg;

    @FindBy(xpath = "//*[contains(.,'Your username is invalid!')]")
    // //div[@class='flash error']/text()[1]
    public WebElement invalidUsernameMsg;

//    @FindBy(xpath= "//*[@id='flash']/text()[1]")
//    @FindBy(xpath = "//div[@class='flash error']/text()[1]")
    @FindBy(xpath = "//*[contains(text(),'Your password is invalid!')]")
    public WebElement invalidPasswordMsg;

    public void login(String username,String password){
        inputUserName.sendKeys(username);
        inputPassword.sendKeys(password);
        loginBtn.click();
    }




}
