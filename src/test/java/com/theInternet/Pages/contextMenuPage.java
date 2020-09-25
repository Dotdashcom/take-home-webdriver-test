package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contextMenuPage extends basePage {

    @FindBy(xpath = "//*[.='Context Menu']")
    public WebElement contextMenuHeader;

    @FindBy(xpath = "//*[@id='hot-spot']")
    public WebElement box;

}
