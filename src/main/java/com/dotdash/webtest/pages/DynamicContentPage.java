package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(12) > a")
    protected WebElement dynamicContentButton;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToDynamicContentPage() {
        dynamicContentButton.click();
    }
}
