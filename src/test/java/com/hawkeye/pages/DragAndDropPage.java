package com.hawkeye.pages;

import com.hawkeye.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {

    @FindBy(xpath="//header[.='A']")
    public WebElement FirstColumn;

    @FindBy(xpath="//header[.='B']")
    public WebElement SecondColumn;

    public  DragAndDropPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
