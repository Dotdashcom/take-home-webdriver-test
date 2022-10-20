package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownPage {
    @FindBy(xpath = "//select[@id='dropdown']")
    public WebElement dropDown;
    @FindBy(xpath = "//option[text()='Option 2']")
    public WebElement dropDownAssert;

    public DropDownPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
