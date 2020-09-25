package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mouseHoverPage extends basePage{

    @FindBy(xpath = "//*[@id='content']/div/div[1]/img")
    public WebElement firstImage;

    @FindBy(partialLinkText = "profile")
    public WebElement text;

    @FindBy(xpath = "//*[@id='content']/div/div[2]/img")
    public WebElement secondImage;

    @FindBy(xpath = "//*[@id='content']/div/div[3]/img")
    public WebElement thirdImage;

}
