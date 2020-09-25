package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dynamicLoadingPage extends basePage{

    @FindBy(xpath = "//*[@id='start']/button")
    public WebElement startButton;

    @FindBy(xpath = "//*[@id='finish']/h4")
    public WebElement message;
}
