package com.hawkeye.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hawkeye.utilities.Driver.getDriver;

public class NotificationPage {

    @FindBy(xpath = "//a[.='Click here']")
    public WebElement clickButton;

    @FindBy(xpath = "//div[@class='flash notice']")
    public WebElement Message;

    public NotificationPage(){
        PageFactory.initElements(getDriver(),this);


    }

}
