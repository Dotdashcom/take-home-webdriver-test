package com.dotdash.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoadingPage extends BasePage {

    @FindBy(partialLinkText = "Example 1: ")
    public WebElement linkOne;

    @FindBy(xpath = "//button[.='Start']")
    public WebElement start;

    @FindBy(xpath = "//h4[.='Hello World!']")
    public WebElement successMsg;
}
