package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mouseHoverOverPage {


    public mouseHoverOverPage(){
        PageFactory.initElements(Driver.getDriver() ,this );
    }


    @FindBy(xpath = "//div[@id='content']/div/div[1]/img")
    public WebElement image1;

    @FindBy(xpath = "//*[@id='content']/div/div[1]/div")
    public WebElement additionalContent1;

    @FindBy(xpath = "//div[@id='content']/div/div[2]/img")
    public WebElement image2;

    @FindBy(xpath = "//*[@id='content']/div/div[2]/div")
    public WebElement additionalContent2;

    @FindBy(xpath = "//div[@id='content']/div/div[3]/img")
    public WebElement image3;

    @FindBy(xpath = "//*[@id='content']/div/div[3]/div")
    public WebElement additionalContent3;







}
