package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends BasePage{

    @FindBy (xpath = "//button[.='Start']")
    public WebElement startBtn;

    @FindBy (id = "loading")
    public WebElement loading;

    @FindBy (id = "finish")
    public WebElement displayedText;

}
