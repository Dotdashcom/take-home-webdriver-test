package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlPage {
    public DynamicControlPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//button)[1]")
    public WebElement RemoveAddButton;
    @FindBy(xpath = "(//button)[2]")
    public WebElement EnableDisableButton;
    @FindBy(xpath = "//p[@id='message']")
    public WebElement itIsGoneMessage;
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;
    @FindBy(xpath = "//p[@id='message']")
    public WebElement itIsEnabledDisabledMessage;


}
