package com.hawkeye.pages;

import com.hawkeye.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {

    @FindBy(tagName = "p")
    public WebElement text;

    public IframePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
