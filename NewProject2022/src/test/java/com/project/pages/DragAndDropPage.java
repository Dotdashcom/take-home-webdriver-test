package com.project.pages;

import com.project.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {


    public  DragAndDropPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//header[.='A']")
    public WebElement FirstColumn;

    @FindBy(xpath="//header[.='B']")
    public WebElement SecondColumn;
}
