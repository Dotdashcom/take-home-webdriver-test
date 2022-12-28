package com.test.localhost.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class    DynamicContentPage {

    public DynamicContentPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(linkText = "Dynamic Content")
    WebElement dynamicContentButton;

    public void clickDynamicContentButton(){
        dynamicContentButton.click();

    }
}
