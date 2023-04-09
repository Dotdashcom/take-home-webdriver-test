package com.internet.pages;

import com.internet.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage{


    @FindBy(id = "column-a")
    private WebElement pointA;

    @FindBy(id = "column-b")
    private WebElement pointB;

    public void dragAndDrop(){
        BrowserUtils.dragAndDrop(pointA,pointB);
    }
    public boolean confirmIfSwitched(){
        return pointA.getText().equals("B") && pointB.getText().equals("A");
    }




}
