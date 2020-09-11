package com.pages;

import com.testbase.BaseClass;
import com.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(how = How.ID, using = "username")
    WebElement _userName;

    @FindBy(how = How.NAME, using = "password")
    WebElement _password;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement _loginButton;

    @FindBy(how = How.CSS, using = "i[class*='signout']")
    public WebElement _logoutButton;

    @FindBy(how = How.XPATH, using = "//h4[text()='Welcome to the Secure Area. When you are done click logout below.']")
    WebElement _secureAreaMessage;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Your username is invalid!')]")
    WebElement _invalidUsernameMessage;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Your password is invalid!')]")
    WebElement _invalidPasswordMessage;


    public void TypeUserName(String userID){
        _userName.clear();
        _userName.sendKeys(userID);
    }

    public void TypePassword(String password){
        _password.clear();
        _password.sendKeys(password);
    }

    public void ClickLoginButton(){
        _loginButton.click();

    }

    public void ClickLogoutButton(){
        _logoutButton.click();

    }

    public void WaitTillInvisiblityofLoginButton(){

        CommonMethods.WaitTillElementIsInvisible(_loginButton);
    }

    public void WaitTillvisiblityofLoginButton(){

        CommonMethods.WaitTillElementIsClickable(_loginButton);
    }

    public void WaitTillVisibityofLogoutButton(){
        CommonMethods.WaitTillElementIsClickable(_logoutButton);

    }

    public boolean SecureAreaNavigation(){
        return _secureAreaMessage.isDisplayed();
    }

    public boolean VerifyinvalidusernameMessage(){
        return _invalidUsernameMessage.isDisplayed();
    }
    public boolean VerifyinvalidPasswordMessage(){
        return _invalidPasswordMessage.isDisplayed();
    }

}
