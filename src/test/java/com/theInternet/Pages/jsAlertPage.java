package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class jsAlertPage extends basePage{

    @FindBy(xpath = "//*[@id='content']/div/ul/li[1]/button")
    public WebElement jsAlertButton;

    @FindBy(xpath = "//*[@id='content']/div/ul/li[2]/button")
    public WebElement jsConfirmButton;

    @FindBy(xpath = "//*[@id='content']/div/ul/li[3]/button")
    public WebElement jsPromptButton;

    @FindBy (id = "result")
    public WebElement message;
}
