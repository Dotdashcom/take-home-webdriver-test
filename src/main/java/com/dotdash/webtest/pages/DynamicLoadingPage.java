package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(14) > a")
    protected WebElement dynamicLoadingButton;

    @FindBy(css = "#content > div > a:nth-child(5)")
    protected WebElement example1Button;

    @FindBy(css = "div[id = start] > button")
    protected WebElement startButton;

    @FindBy(css = "div#finish > h4")
    protected WebElement example1Message;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToDynamicLoadingPage() {
        dynamicLoadingButton.click();
    }

    public void startDynamicLoading() {
        example1Button.click();
        startButton.click();
    }

    public String getExample1Message() {
        webDriverWait.until(ExpectedConditions.visibilityOf(example1Message));
        return example1Message.getText();
    }
}
