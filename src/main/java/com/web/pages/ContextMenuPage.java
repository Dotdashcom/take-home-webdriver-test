package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;


public class ContextMenuPage extends TestBase{

    @FindBy(xpath="//*[@id='hot-spot']")
    WebElement contextMenuBox;


    public ContextMenuPage(){

        PageFactory.initElements(driver, this);
    }

    public WebElement contextMenuClick(){
        return contextMenuBox;
    }

}
