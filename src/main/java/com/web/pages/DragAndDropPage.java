package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;

public class DragAndDropPage extends TestBase{

    //Page Factory - OR:
    @FindBy(xpath="//div[@id='column-a']")
    WebElement dragDropBoxA;

    @FindBy(xpath="//div[@id='column-b']")
    WebElement dragDropBoxB;

    public DragAndDropPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public WebElement getdragDropBoxAElement(){
        return dragDropBoxA;
    }
    public WebElement getdragDropBoxBElement(){
        return dragDropBoxB;
    }
}
