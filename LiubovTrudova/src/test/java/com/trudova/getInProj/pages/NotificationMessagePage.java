package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage extends BasePage {
    public NotificationMessagePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "flash")
    public WebElement resultMessage;

    @FindBy(linkText = "Click here")
    public WebElement clickHereLink;
}
