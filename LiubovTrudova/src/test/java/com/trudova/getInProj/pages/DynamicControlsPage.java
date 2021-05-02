package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage extends BasePage{
    public DynamicControlsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//form[@id='checkbox-example']/button")
    public WebElement removeAddBtn;
    @FindBy(xpath = "//form[@id='input-example']/button")
    public WebElement enableBtn;
    @FindBy(xpath = "//div[@id='checkbox']/input")
    public WebElement checkBoxInp;
    @FindBy(id = "message")
    public WebElement dMessage;
    @FindBy(xpath = "//input[@id='checkbox']")
    public WebElement checkBoxInpUp;
}
