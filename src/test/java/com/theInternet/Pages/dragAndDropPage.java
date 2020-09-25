package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dragAndDropPage extends basePage{

    @FindBy(id = "column-a")
    public WebElement boxA;

    @FindBy(id = "column-b")
    public WebElement boxB;

}
