package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage {

    @FindBy(xpath = "//a[contains(text(),'Click here')]")
    public WebElement clickHere;

    @FindBy(xpath = "//div[@id='flash']")
    public WebElement message;

    public NotificationPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
