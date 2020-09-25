package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dropDownPage extends basePage {

    @FindBy (id = "dropdown")
    public WebElement options;

}
