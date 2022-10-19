package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends BasePage{

    @FindBy(id = "checkbox")
    public WebElement checkbox;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement removeAndAddBtn;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement textBox;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement enableAndDisableBtn;

    @FindBy(id = "loading")
    public WebElement loading;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement message;

}
