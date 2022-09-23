package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends BasePage {

    public DynamicLoadingPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(partialLinkText = "Example 1: ")
    public WebElement linkOne;

    @FindBy(xpath = "//button[.='Start']")
    public WebElement start;

    @FindBy(xpath = "//h4[.='Hello World!']")
    public WebElement successMsg;
}
