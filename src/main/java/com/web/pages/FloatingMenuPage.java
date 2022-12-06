package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;

public class FloatingMenuPage extends TestBase{

    @FindBy(xpath = "//*[@id='menu']")
    WebElement floatingMenu;


    public FloatingMenuPage(){
        PageFactory.initElements(driver, this);
    }

    public WebElement fMenu()
    {
        return floatingMenu;
    }


}