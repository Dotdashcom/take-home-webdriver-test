package com.dotdash.app.pageobjects;

import com.dotdash.core.helpers.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DragAndDropPage extends BasePage {
    @FindBy(id="column-a")
    WebElement columnA;

    @FindBy(id="column-b")
    WebElement columnB;

    @FindBy(css="div[id=\"columns\"] div header")
    List<WebElement> columnHeader;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void dragColumnAtoColumnB(){
        Actions action = new Actions(driver);
        action.dragAndDrop(columnA, columnB).perform();
    }

    public String getFirstColumnHeaderText(){
        return columnHeader.get(0).getText();
    }

    public String getSecondColumnHeaderText(){
        return columnHeader.get(1).getText();
    }
}
