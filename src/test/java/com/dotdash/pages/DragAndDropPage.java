package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BasePage{

    public DragAndDropPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "column-a")
    public WebElement figureA;

    @FindBy(id = "column-b")
    public WebElement figureB;

    @FindBy(xpath = "//header[.='A']")
    public WebElement text;

}
