package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/drag_and_drop");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void dragAndDropTest1(){

        WebElement draggable = Driver.getDriver().findElement(By.id("column-a"));
        WebElement dropTarget = Driver.getDriver().findElement(By.id("column-b"));

        Actions action = new Actions(Driver.getDriver());// Creating action object that way we can use action class/methods
        action.dragAndDrop(draggable,dropTarget).perform();// here I can drag and drop box a to box b

        // After drag and drop box B becomes box A
        //checking after drag and drop boxes change or not
        Assert.assertEquals(draggable.getText(),("A"));

    }

    @Test
    public void dragAndDrop2(){

        WebElement draggable = Driver.getDriver().findElement(By.id("column-a"));
        WebElement dropTarget = Driver.getDriver().findElement(By.id("column-b"));

        Actions action = new Actions(Driver.getDriver());
        action.dragAndDrop(draggable,dropTarget).perform();

        // After drag and drop box A becomes box B
        //checking after drag and drop boxes change or not
        Assert.assertEquals(dropTarget.getText(),("B"));

    }
}
