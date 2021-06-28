package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage {

    WebDriver localDriver;
    public CheckboxPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/checkboxes']")
    @CacheLookup
    WebElement linkCheboxes;

    @FindBy(xpath = "//*[@id='checkboxes']/input[1]")
    @CacheLookup
    WebElement checkbox1;

    @FindBy(xpath = "//*[@id='checkboxes']/input[2]")
    @CacheLookup
    WebElement checkbox2;

    public void clickCheckboxLink() {
        linkCheboxes.click();
    }

    public void clickCheckbox1() {
        checkbox1.click();
    }

    public void clickCheckbox2() {
        checkbox2.click();
    }
}
