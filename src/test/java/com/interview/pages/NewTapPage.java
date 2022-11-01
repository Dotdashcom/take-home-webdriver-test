package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTapPage {
    public NewTapPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@target='_blank']")
    public WebElement ClickHere;

    @FindBy(xpath = "//h3")
    public WebElement newWindowText;

}
