package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class newTabPage extends basePage {

    @FindBy(xpath = "//*[@id='content']/div/a")
    public WebElement clickHerebttn;

}
