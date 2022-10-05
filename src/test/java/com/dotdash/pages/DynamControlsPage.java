package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamControlsPage extends BasePage{



    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    public WebElement firstBtn;

    @FindBy(id = "message")
    public WebElement text1;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement secondBtn;

    @FindBy(xpath = "//form[@id='input-example']/button")
    public WebElement secondBtn2;
}
