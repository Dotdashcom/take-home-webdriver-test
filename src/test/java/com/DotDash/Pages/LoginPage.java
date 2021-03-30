package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "username")
    WebElement txtusername;

    @FindBy(id = "password")
    WebElement txtpassword;

    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement btnLogin;

    @FindBy(xpath = "//div[@id='flash']")
    WebElement msgLogin;

    public void setTxtusername(String uname) {

        txtusername.sendKeys(uname);
    }

    public void setTxtpassword(String pwd) {

        txtpassword.sendKeys(pwd);
    }

    public void clkbtnLogin() {
        btnLogin.click();
    }

    public String txtmsgLogin() {
        return msgLogin.getText();
    }


}
