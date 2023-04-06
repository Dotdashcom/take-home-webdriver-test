package com.internet.pages;

import com.internet.utilities.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    private WebElement loginButton;

    @FindBy(css = "#flash")
    private WebElement flashMessage;


    public void enterUserName() {
        waitforVisibilityandClickable(userName);
        userName.sendKeys(ConfigurationReader.getProperty("username"));
    }

    public void enterPassword(){
        waitforVisibilityandClickable(password);
        password.sendKeys(ConfigurationReader.getProperty("password"));
    }

    public void clickLogin(){
        waitforVisibilityandClickable(loginButton);
        loginButton.click();
    }

    public String displayedFlashMessage(){
        wait.until(ExpectedConditions.visibilityOf(flashMessage));
        System.out.println(flashMessage.getText().trim());
        return flashMessage.getText().trim();
    }

    public void pageLogin() {
        enterUserName();
        enterPassword();
        clickLogin();
    }

    public void pageLogin(String username,String password){
        waitforVisibilityandClickable(this.userName);
        this.userName.sendKeys(username);
        waitforVisibilityandClickable(this.password);
        this.password.sendKeys(password);
        clickLogin();
    }




}
