package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(10) > a")
    protected WebElement dragAndDropButton;

    @FindBy(id = "column-a")
    protected WebElement boxA;

    @FindBy(id = "column-b")
    protected WebElement boxB;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToDragAndDropPage() {
        dragAndDropButton.click();
    }

    public void dragAndDrop() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(boxB).moveToElement(boxA).release().build().perform();
    }

    public String getTextBoxA() {
        return boxA.getText();
    }
}
