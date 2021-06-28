package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    public loginPage () {
        PageFactory.initElements(Driver.getDriver() , this );
    }

    @FindBy( id = "username")
    public WebElement userName;

    @FindBy( id = "password")
    public WebElement password;

    @FindBy( xpath = "/html/body/div[2]/div/div/form/button")
    public WebElement loginButton;

    @FindBy ( xpath = "//*[@id='flash']" )
    public WebElement expectedMessage;

}
