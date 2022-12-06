package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;

public class IframePage extends TestBase{

    @FindBy(xpath="//body[@id='tinymce']/p")
    WebElement iframeText;

    @FindBy(xpath="//iframe[@id='mce_0_ifr']")
    WebElement getIframe;


    @FindBy(xpath="//*[@id='tinymce']/p")
    WebElement getNewIframeText;

    public IframePage(){

        PageFactory.initElements(driver, this);
    }

    public WebElement switchToIframe(){
        return getIframe;
    }

    public void validateSendText(){
        iframeText.clear();
        iframeText.sendKeys("validation!");
    }

    public String validateNewIframeText(){
        return getNewIframeText.getText();
    }
}