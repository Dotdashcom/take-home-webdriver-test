package com.dotdash.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSErrorPage extends BasePage{

    @FindBy(tagName = "p")
    public WebElement jsErrorMsg;


}
