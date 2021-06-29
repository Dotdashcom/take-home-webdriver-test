package com.new_york_remote.pages;

import com.new_york_remote.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownPage {
    public DropdownPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="dropdown")
    public WebElement dropDownBox;
    @FindBy(xpath = "//option[2]")
    public WebElement option1;
    @FindBy(xpath = "//option[3]")
    public WebElement option2;
}
