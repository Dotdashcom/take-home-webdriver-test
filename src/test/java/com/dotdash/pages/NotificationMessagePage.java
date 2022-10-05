package com.dotdash.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NotificationMessagePage extends BasePage{


    @FindBy(linkText = "Click here")
    public WebElement clickHere;

    @FindBy(css = "div.flash.notice")
    public WebElement flashNotice;
}
