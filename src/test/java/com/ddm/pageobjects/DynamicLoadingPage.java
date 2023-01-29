package com.ddm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DynamicLoadingPage extends WebPage {

    @FindBy(css = "div[id = start] > button")
    protected WebElement startButton;

    @FindBy(css = "div#finish > h4")
    protected WebElement helloWorldText;

    public DynamicLoadingPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public void startDynamicLoadAndWait() {
        startButton.click();

        //Wait untild loading is finished. Max of 10 seconds
        waitUntilLoadedByCss("div#finish > h4");
    }

    public String getLoadedText() {
        return helloWorldText.getText();
    }




}
