package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn_page {
    public LogIn_page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id ="username" )
    public WebElement emailInput;
    @FindBy(id ="password" )
    public WebElement passwordInput;
    @FindBy(xpath ="//button[@class='radius']")
    public WebElement logInButton;
    @FindBy(className = "subheader")
    public WebElement successMessage;
    @FindBy(id = "flash")
    public WebElement errorMessage;

}
