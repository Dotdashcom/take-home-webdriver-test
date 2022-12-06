package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;

public class MouseHoverPage extends TestBase{

    @FindBy(xpath = "//*[@id='content']/div/div[1]/img")
    WebElement img1;

    @FindBy(xpath = "//*[@id='content']/div/div[2]/img")
    WebElement img2;

    @FindBy(xpath = "//*[@id='content']/div/div[3]/img")
    WebElement img3;

    @FindBy(xpath = "//*[@id='content']/div/div[1]/div")
    WebElement img1TextBox;

    @FindBy(xpath = "//*[@id='content']/div/div[2]/div")
    WebElement img2TextBox;

    @FindBy(xpath = "//*[@id='content']/div/div[3]/div")
    WebElement img3TextBox;


    public MouseHoverPage(){
        PageFactory.initElements(driver, this);
    }

    public WebElement getImg1Hover()
    {
        return img1;
    }

    public WebElement getImg2Hover()
    {
        return img2;
    }

    public WebElement getImg3Hover()
    {
        return img3;
    }

    public String getImg1Text()
    {
        return img1TextBox.getText();
    }

    public String getImg2Text()
    {
        return img2TextBox.getText();
    }

    public String getImg3Text()
    {
        return img3TextBox.getText();
    }
}