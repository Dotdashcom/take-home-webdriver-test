package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage{
    @FindBy (id = "column-a")
    public WebElement columnA;

    @FindBy (css = ".column:last-child")
    public WebElement columnB;

    @FindBy (css = ".column:first-child > header" )
    public WebElement ColumnAHeader;
}
