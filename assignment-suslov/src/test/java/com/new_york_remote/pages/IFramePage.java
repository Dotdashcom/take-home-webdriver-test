package com.new_york_remote.pages;

import com.new_york_remote.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage {
    public IFramePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//iframe")
    public WebElement textBox;
    @FindBy(xpath = "//div[@class='tox-icon']")
    public WebElement alertXButton;
    @FindBy(xpath = "//p")
    public WebElement yourTextGoesHere;
}
