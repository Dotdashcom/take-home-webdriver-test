package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginRepository extends TestEngine {

    //parameterized constructor
    public LoginRepository (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='username']")
    public WebElement _userNameField;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    public WebElement _passWordField;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement _loginButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'success')]")
    public WebElement _loginSuccessTitle;

    @FindBy(how = How.XPATH, using = "//a[contains(@href,'logout')]")
    public WebElement _logoutButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'error') and contains(text(),'invalid')]")
    public WebElement _errorMsg;

    public void EnterUserName(String _userName){
        SeleniumCommonMethods.TextFieldClear(_userNameField);
        _userNameField.sendKeys(_userName);
    }

    public void EnterPassWord(String _passWord){
        SeleniumCommonMethods.TextFieldClear(_passWordField);
        _passWordField.sendKeys(_passWord);
    }

    public void ClickLogin(){
        _loginButton.click();
    }

    public void ClickLogout(){
        _logoutButton.click();
    }

    public boolean LogInSuccessIsDisplayed(){
        return _loginSuccessTitle.isDisplayed();
    }

    public boolean LogOutButtonIsDisplayed(){
        return _logoutButton.isDisplayed();
    }

    public boolean ErrorMessageIsDisplayed(){
        return _errorMsg.isDisplayed();
    }

    //Login via invalid credentials
    public void LoginViaInvalidCredentials(String _userName, String _passWord){
        SeleniumCommonMethods.TextFieldClear(_userNameField);
        _userNameField.sendKeys(_userName);
        SeleniumCommonMethods.TextFieldClear(_passWordField);
        _passWordField.sendKeys(_passWord);
        _loginButton.click();
     //   SeleniumCommonMethods.WaitUntilElementAppears(_logoutButton);
    }
}
