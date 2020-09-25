package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dynamicContentPage extends basePage{

    @FindBy(xpath = "//*[@id='content']/div[1]/div[2]")
    public WebElement firstText;

    @FindBy(xpath = "//*[@id='content']/div[2]/div[2]")
    public WebElement secondText;

    @FindBy(xpath = "//*[@id='content']/div[3]/div[2]")
    public WebElement thirdText;

}
