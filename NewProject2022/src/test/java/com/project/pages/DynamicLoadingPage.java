package com.project.pages;

import com.project.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {


    public DynamicLoadingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "button")
    public WebElement startButton;

    @FindBy(id = "finish")
    public WebElement HelloWorld;



}
