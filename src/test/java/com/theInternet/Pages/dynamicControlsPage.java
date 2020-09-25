package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dynamicControlsPage extends basePage {

    @FindBy(xpath = "//*[.='Remove']")
    public WebElement removeButton;

    @FindBy(id = "checkbox")
    public WebElement checkbox;

    @FindBy(id = "message")
    public WebElement message;

    @FindBy(id = "checkbox-example")
    public WebElement addButton;

    @FindBy(xpath = "//*[@id='input-example']/button")
    public WebElement enableButton;

    @FindBy(xpath = "//*[@id='input-example']/input")
    public WebElement textBox;

    @FindBy(xpath = "//*[@id='input-example']/button")
    public WebElement disableButton;

}
