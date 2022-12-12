package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class DragAndDropPage extends BasePage {

    @FindBy(xpath = "//a[@href='/drag_and_drop']")
    WebElement dragAndDropLink;

    @FindBy(id = "column-a")
    WebElement columnA;

    @FindBy(id = "column-b")
    WebElement columnB;



    public void clickOnLink() {
        dragAndDropLink.click();
    }

    public void dragAndDrop() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(columnA).moveToElement(columnB).build().perform();
        WebElement header = columnA.findElement(By.xpath("./header"));
        Assert.assertTrue(header.getText().equals("A"));
    }
}
