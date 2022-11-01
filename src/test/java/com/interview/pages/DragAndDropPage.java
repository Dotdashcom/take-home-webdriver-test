package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {
    public DragAndDropPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="column-a")
    public WebElement columnA;
    @FindBy(id = "column-b")
    public WebElement columnB;
    @FindBy(xpath = "(//header)[1]")
    public WebElement headerB;
    @FindBy(xpath = "(//header)[2]")
    public WebElement headerA;

}
