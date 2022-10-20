package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {

    @FindBy(xpath = "//input[@id='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//form[@id='input-example']//input[@type='text']")
    public WebElement input;

    @FindBy(xpath = "//form[@id='input-example']//input[@type='text'][@disabled]")
    public WebElement inputDisabled;

    @FindBy(xpath = "//button[text()='Add']")
    public WebElement add;

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement remove;

    @FindBy(xpath = "//button[text()='Enable']")
    public WebElement enable;

    @FindBy(xpath = "//button[text()='Disable']")
    public WebElement disable;

    public DynamicControlsPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
