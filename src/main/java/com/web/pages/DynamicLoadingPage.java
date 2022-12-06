package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;


public class DynamicLoadingPage extends TestBase{

    @FindBy(xpath = "//*[@id='start']/button")
    WebElement startBtn;

    @FindBy(xpath = "//*[@id='finish']/h4")
    WebElement displayedText;


    public DynamicLoadingPage(){
        PageFactory.initElements(driver, this);
    }

    public void btnClick()
    {
        startBtn.click();
    }

    public WebElement element(){
       return displayedText;
    }
}