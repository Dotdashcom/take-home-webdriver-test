package com.new_york_remote.pages;

import com.new_york_remote.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewTabPage {
    public OpenNewTabPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@target='_blank']")
    public WebElement clickHere;

    @FindBy(xpath = "//h3")
    public WebElement newWindowText;

}
