package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage {
    public NotificationMessagePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[.='Click here']")
    public WebElement clickHereButton;
    @FindBy(xpath = "//div[@class='large-12 columns']/div")
    public WebElement messages;

}
