package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class javaScriptAlertsPage {


    public javaScriptAlertsPage(){
        PageFactory.initElements(Driver.getDriver() ,this );
    }


    @FindBy(xpath = "//*[@id='content']/div/ul/li[1]/button")
    public WebElement jsAlertButton;

    @FindBy(xpath = "//*[@id='content']/div/ul/li[2]/button")
    public WebElement jsConfirmButton;

    @FindBy(xpath = "//*[@id='content']/div/ul/li[3]/button")
    public WebElement jsPromptButton;


}
