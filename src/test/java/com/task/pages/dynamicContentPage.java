package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dynamicContentPage {

    public dynamicContentPage(){
        PageFactory.initElements(Driver.getDriver() , this );
    }

    @FindBy(xpath = "//div[@id='content']/div[1]/div[2]" )
    public WebElement avatar1;

    @FindBy(xpath = "//div[@id='content']/div[2]/div[2]" )
    public WebElement avatar2;

    @FindBy(xpath = "//div[@id='content']/div[3]/div[2]" )
    public WebElement avatar3;
//
    @FindBy(xpath = "//div[@id='content']/div[1]/div[2]" )
    public WebElement avatar11;

    @FindBy(xpath = "//div[@id='content']/div[2]/div[2]" )
    public WebElement avatar22;

    @FindBy(xpath = "//div[@id='content']/div[3]/div[2]" )
    public WebElement avatar33;
//
    @FindBy(xpath = "//div[@id='content']/div[1]/div[2]" )
    public WebElement avatar111;

    @FindBy(xpath = "//div[@id='content']/div[2]/div[2]" )
    public WebElement avatar222;

    @FindBy(xpath = "//div[@id='content']/div[3]/div[2]" )
    public WebElement avatar333;
//
    @FindBy(xpath = "//div[@id='content']/div[1]/div[2]" )
    public WebElement avatar1111;

    @FindBy(xpath = "//div[@id='content']/div[2]/div[2]" )
    public WebElement avatar2222;

    @FindBy(xpath = "//div[@id='content']/div[3]/div[2]" )
    public WebElement avatar3333;



















}
