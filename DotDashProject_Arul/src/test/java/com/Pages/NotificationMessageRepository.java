package com.Pages;

import com.BaseTest.TestEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessageRepository extends TestEngine {

    //parameterized constructor
    public NotificationMessageRepository (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Click here']")
    public WebElement _clickHereForNotification;

    @FindBy(how = How.XPATH, using = "//div[@id='flash-messages']")
    public WebElement _notificationMsg;

    @FindBy(how = How.XPATH, using = "//div[@class='flash notice']")
    public WebElement _notificationMsgText;

    public  static String _notificationMsgTextContent;

    public void ClickForNotificationMsg(){
        _clickHereForNotification.click();
    }

    public boolean IsNotificationMsgDisplayed(){
        return _notificationMsg.isDisplayed();
    }
}
