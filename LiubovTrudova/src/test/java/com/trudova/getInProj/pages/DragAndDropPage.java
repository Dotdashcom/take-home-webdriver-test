package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BasePage{
    public DragAndDropPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "column-a")
    public WebElement baxA;
    @FindBy(id = "column-b")
    public WebElement baxB;
}
