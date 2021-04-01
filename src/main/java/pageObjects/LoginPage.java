package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page Objects for Login Success and Login Failure
public class LoginPage {
    WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    //Capture Username
    @FindBy(id="username")
    WebElement username;

    //Capture Password
    @FindBy(id="password")
    WebElement password;

    //Capture LoginPage button
    @FindBy(xpath="//i[contains(text(),'Login')]")
    WebElement login;

    //Capture login success msg
    @FindBy(id="flash")
    WebElement loginSuccessMsg;

    //Capture login failure msg
    @FindBy(xpath="//div[@id='flash' and @class='flash error']")
    WebElement loginFailureMsg;

    //Set username
    public void setUsername(String uname){
        username.sendKeys(uname);
    }

    //Set password
    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }

    //Click LoginPage
    public void clickLogin(){
        login.click();
    }

    //Return login success msg
    public String getLoginSuccessMsg(){
        return loginSuccessMsg.getText();
    }

    //Return login failure msg
    public String getLoginFailureMsg(){
        return loginFailureMsg.getText();
    }
}