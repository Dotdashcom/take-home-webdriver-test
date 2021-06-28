package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dropdownPage {

    public dropdownPage(){
        PageFactory.initElements(Driver.getDriver() , this );
    }

    @FindBy(xpath = "//select[@id='dropdown']" )
    public WebElement option1;

    @FindBy(xpath = "//select[@id='dropdown']" )
    public WebElement option2;
}
