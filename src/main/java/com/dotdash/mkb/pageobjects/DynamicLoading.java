package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DynamicLoading extends BasePage {

    @FindBy(css = "#start > button")
    private WebElement startBtn;

    @FindBy(id = "finish")
    private WebElement helloText;

    public DynamicLoading(WebDriver driver) {
        super(driver);
    }

    public void clickStartButtonAndWaitUntilLoadFinish(){
        clickButtonAndWaitUntilFinish(startBtn);
    }

    public String getLoadedText(){
        return helloText.getText();
    }
}