package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;

public class DynamicContentPage extends TestBase{

    @FindBy(xpath="//*[@id='content']/div/p[2]/a")
    WebElement linkText;


    @FindBy(xpath="//*[@id='content']/div[3]/div[2]")
    WebElement dynamicText;

    public DynamicContentPage(){

        PageFactory.initElements(driver, this);
    }

    public void clickLinkText(){
        linkText.click();
    }

    public WebElement getDynamicTextElement(){
        return dynamicText;
    }
}
