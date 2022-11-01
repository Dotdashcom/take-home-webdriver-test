package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {
    public DynamicLoadingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button")
    public WebElement button;
    @FindBy(xpath = "//h4[.='Hello World!']")
    public WebElement helloWorld;
}
