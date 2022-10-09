package com.hawkeye.pages;

import com.hawkeye.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownPage {

    @FindBy(id="dropdown")
    public WebElement dropDownElement;

    public DropDownPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
