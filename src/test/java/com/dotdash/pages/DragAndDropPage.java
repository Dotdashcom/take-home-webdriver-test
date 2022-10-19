package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage{

    @FindBy (id = "column-a")
    public WebElement elementA;

    @FindBy (id = "column-b")
    public WebElement elementB;

}
