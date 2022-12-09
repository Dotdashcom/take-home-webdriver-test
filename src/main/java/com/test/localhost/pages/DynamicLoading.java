package com.test.localhost.pages;

import com.test.localhost.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DynamicLoading {

    public DynamicLoading(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Dynamic Loading")
    WebElement dynamicLoadingButton;

    @FindBy(partialLinkText = "that is hidden")
    WebElement example1Button;
    @FindBy(tagName = "button")
    WebElement startButton;

    @FindBy(xpath = "//h4[.='Hello World!']")
    WebElement message;


    public void clickButtons(){
        dynamicLoadingButton.click();
        example1Button.click();
        startButton.click();
    }

    public String getMessage(WebDriver driver){
        BrowserUtils.waitForVisibility(driver,message);
        return BrowserUtils.getText(message);
    }
}
