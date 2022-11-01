package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {
    public IframePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//iframe")
    public WebElement textBox;
    @FindBy(xpath = "//div[@class='tox-icon']")
    public WebElement alertXButton;
    @FindBy(xpath = "//p")
    public WebElement yourTextGoesHere;
}
