package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dynamicControlsPage {

    public dynamicControlsPage(){
        PageFactory.initElements(Driver.getDriver() , this );
    }

    @FindBy(xpath = "//form[@id='checkbox-example']/button")
    public WebElement removeButton;

    @FindBy(xpath = "//form[@id='checkbox-example']/button")
    public WebElement addButton;

    @FindBy(id = "message")
    public WebElement message1;

    @FindBy(id = "checkbox")
    public WebElement checkBox1;

    @FindBy(xpath = "//form[@id='input-example']/button")
    public WebElement enableButton;

    @FindBy(id = "message")
    public WebElement message2;

    @FindBy(xpath = "//form[@id='input-example']/button")
    public WebElement disableButton;

    @FindBy(id = "message")
    public WebElement message3;

    @FindBy(id = "message")
    public WebElement message4;










}
