package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DynamicContentPage {

    WebDriver localDriver;
    public DynamicContentPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/dynamic_content']")
    @CacheLookup
    WebElement linkDynamicContent;

    @FindBy(xpath = "//*[@id='content']/div[1]/div[2]")
    @CacheLookup
    WebElement dynamicContentText1;

    @FindBy(xpath = "//*[@id='content']/div[2]/div[2]")
    @CacheLookup
    WebElement dynamicContentText2;

    @FindBy(xpath = "//*[@id='content']/div[3]/div[2]")
    @CacheLookup
    WebElement dynamicContentText3;

    public void clickDynamicContentLink() {
        linkDynamicContent.click();
    }

    public void checkText1() {
        localDriver.navigate().refresh();
    }

    public void checkText2() {
        localDriver.navigate().refresh();
    }

    public void checkText3() {
        localDriver.navigate().refresh();
    }
}
