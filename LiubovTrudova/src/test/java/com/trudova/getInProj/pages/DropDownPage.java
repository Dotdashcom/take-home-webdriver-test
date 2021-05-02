package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownPage extends BasePage{
    public DropDownPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "dropdown")
    public WebElement dropdownSelect;
}
