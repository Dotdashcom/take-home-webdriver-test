package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;
public class OpenInNewTabPage extends TestBase{

    @FindBy(linkText = "Click Here")
    WebElement linktext;

    public OpenInNewTabPage(){
        PageFactory.initElements(driver, this);
    }

    public WebElement getLinkText(){
        return linktext;
    }
}
