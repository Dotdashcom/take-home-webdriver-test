package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

import java.util.List;

@Url("/drag_and_drop")
public class DragAndDrop extends WebPage {

    @FindBy(className = "column")
    private List<WebElement> columns;

    public DragAndDrop dragAndDropFirstBoxToRight() {
        dragAndDrop(columns.get(0), columns.get(1));
        return this;
    }

    public DragAndDrop dragAndDropSecondBoxToLeft() {
        dragAndDrop(columns.get(1), columns.get(0));
        return this;
    }

    public String getBoxName(int position) {
        return getText(columns.get(position));
    }
}
