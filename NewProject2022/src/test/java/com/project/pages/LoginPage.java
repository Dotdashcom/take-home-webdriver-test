package com.project.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import static com.project.utility.Driver.getDriver;


public class LoginPage {

    public LoginPage(){
       PageFactory.initElements(getDriver(),this);}

    @FindBy(id="username")
    public WebElement UserName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(tagName = "button")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='flash-messages']")
    public WebElement messages;

    }

