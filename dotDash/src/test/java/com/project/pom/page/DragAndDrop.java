package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop extends Base {

    By content = By.id("content");
    By columnA = By.id("column-a");
    By columnB = By.id("column-b");

    public DragAndDrop(WebDriver driver) {
        super(driver);
    }

    public void dragAndDrop() {
        if (isDisplayed(content)) {
            WebElement ColumnA = driver.findElement(By.id("column-a"));
            WebElement ColumnB = driver.findElement(By.id("column-b"));
            Actions actions = new Actions(driver);
            actions.dragAndDrop(ColumnA,ColumnB).perform();
        }else {
            System.out.println("Drag And drop page was no found");
        }
    }

    public String switchedA(){
        return getText(columnA);
    }

    public String switchedB(){
        return getText(columnB);
    }
}
