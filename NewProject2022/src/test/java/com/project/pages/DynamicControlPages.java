package com.project.pages;

import com.project.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlPages {

    public DynamicControlPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeButton;

    @FindBy(xpath = "(//input)[1]")
    public WebElement checkBoxButton;

    @FindBy(xpath="//button[.='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement enableText;

    @FindBy(xpath = "//button[.='Disable']")
    public WebElement disableButton;



}
