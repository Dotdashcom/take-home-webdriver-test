package com.dotdash.pages;

import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Securepage extends BasePage{
    public Securepage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
