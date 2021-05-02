package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {
    public DynamicLoadingPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h4[.='Hello World!']")
    public WebElement helloWorldMsg;
    @FindBy(xpath = "//button[.='Start']")
    public WebElement startBtn;
}
