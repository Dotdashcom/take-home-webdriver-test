package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {

    WebDriver localDriver;
    public DragAndDropPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/drag_and_drop']")
    @CacheLookup
    WebElement linkDragAndDrop;

    @FindBy(id = "column-a")
    @CacheLookup
    WebElement columnA;

    @FindBy(id = "column-b")
    @CacheLookup
    WebElement columnB;

    public void clickDragAndDropLink() {
        linkDragAndDrop.click();
    }

    public void makeDragAndDrop() {
        Actions actions = new Actions(localDriver);
        actions.dragAndDrop(columnA, columnB).build().perform();
    }
}
