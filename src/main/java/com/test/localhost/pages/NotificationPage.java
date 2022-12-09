package com.test.localhost.pages;

import com.test.localhost.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage {
    public NotificationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Notification Messages")
    WebElement notificationButton;

    @FindBy(linkText = "Click here")
    WebElement clickHereButton;
    @FindBy(xpath = "//div[@class='flash notice']")
    WebElement message;

    public void clickButton(){
        notificationButton.click();
    }
    public void clickHere(){
        clickHereButton.click();
    }
    public String validateMessage(){
        return BrowserUtils.getText(message);
    }
}
