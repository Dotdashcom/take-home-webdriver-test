package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage {

    WebDriver localDriver;
    public DynamicLoadingPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/dynamic_loading']")
    @CacheLookup
    WebElement linkDynamicLoading;

    @FindBy(css = "a[href='/dynamic_loading/1']")
    @CacheLookup
    WebElement linkElementHidden;

    @FindBy(xpath = "//button[contains(text(),'Start')]")
    @CacheLookup
    WebElement elementHiddenButton;

    @FindBy(xpath = "//h4[contains(text(),'Hello World!')]")
    @CacheLookup
    WebElement elementHiddenText;

    @FindBy(css = "a[href='/dynamic_loading/2']")
    @CacheLookup
    WebElement linkElementRendered;

    @FindBy(xpath = "//button[contains(text(),'Start')]")
    @CacheLookup
    WebElement elementRenderedButton;

    @FindBy(xpath = "//h4[contains(text(),'Hello World!')]")
    @CacheLookup
    WebElement elementRenderedText;

    public void clickDynamicLoadingLink() {
        linkDynamicLoading.click();
    }

    public void clickLinkElementHidden() {
        linkElementHidden.click();
    }

    public void clickHiddenButton() {
        elementHiddenButton.click();
    }

    public void clickLinkElementRendered() {
        linkElementRendered.click();
    }

    public void clickRenderedButton() {
        elementRenderedButton.click();
    }

}
