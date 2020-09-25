package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class floatingMenuPage extends basePage{

    @FindBy (xpath = "//*[@id='menu']/ul/li[1]/a")
    public WebElement home;

    @FindBy (xpath = "//*[@id='menu']/ul/li[2]/a")
    public WebElement news;

    @FindBy (xpath = "//*[@id='menu']/ul/li[3]/a")
    public WebElement contact;

    @FindBy (xpath = "//*[@id='menu']/ul/li[4]/a")
    public WebElement about;

    @FindBy(partialLinkText = "Powered by")
    public WebElement bottom;

}
