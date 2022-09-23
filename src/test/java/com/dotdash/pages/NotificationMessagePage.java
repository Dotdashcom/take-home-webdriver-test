package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage extends BasePage{


    public NotificationMessagePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Click here")
    public WebElement clickHere;

    @FindBy(css = "div.flash.notice")
    public WebElement flashNotice;
}
