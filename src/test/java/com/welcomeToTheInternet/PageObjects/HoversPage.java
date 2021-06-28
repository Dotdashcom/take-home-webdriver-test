package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HoversPage {

    WebDriver localDriver;
    public HoversPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/hovers']")
    @CacheLookup
    WebElement linkHoversPage;

    @FindBy(xpath = "//*[@id='content']/div/div[1]")
    @CacheLookup
    WebElement imageHover1;

    @FindBy(xpath = "//h5[contains(text(),'user1')]")
    @CacheLookup
    WebElement text1;

    @FindBy(xpath = "//*[@id='content']/div/div[2]")
    @CacheLookup
    WebElement imageHover2;

    @FindBy(xpath = "//h5[contains(text(),'user2')]")
    @CacheLookup
    WebElement text2;

    @FindBy(xpath = "//*[@id='content']/div/div[3]")
    @CacheLookup
    WebElement imageHover3;

    @FindBy(xpath = "//h5[contains(text(),'user3')]")
    @CacheLookup
    WebElement text3;

    public void clickHoversPageLink() {
        linkHoversPage.click();
    }

    public void hoverOnImage1() {
        Actions builder = new Actions(localDriver);
        builder.moveToElement(imageHover1).perform();
    }

    public void checkText1() {
        boolean isDisplayed = text1.isDisplayed();
        if (isDisplayed) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    public void hoverOnImage2() {
        Actions builder = new Actions(localDriver);
        builder.moveToElement(imageHover2).perform();
    }

    public void checkText2() {
        boolean isDisplayed = text2.isDisplayed();
        if (isDisplayed) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    public void hoverOnImage3() {
        Actions builder = new Actions(localDriver);
        builder.moveToElement(imageHover3).perform();
    }

    public void checkTex3() {
        boolean isDisplayed = text3.isDisplayed();
        if (isDisplayed) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
}


