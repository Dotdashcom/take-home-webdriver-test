package com.project.pages;

import com.project.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {

    public IframePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "p")
    public WebElement text;



}
