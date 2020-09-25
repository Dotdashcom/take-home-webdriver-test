package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class notificationMessagePage extends basePage{

    @FindBy(partialLinkText = "Click")
    public WebElement clickHere;
}
