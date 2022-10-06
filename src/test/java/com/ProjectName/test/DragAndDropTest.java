package com.ProjectName.test;

import com.ProjectName.Base.BaseTest;
import com.ProjectName.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    @BeforeTest
    public void setupTest(){
        driver.get(BrowserUtils.getBaseUrl() + "/drag_and_drop");
    }

    @Test
    public void dragAndDropTest(){

        WebElement elementA = driver.findElement(By.id("column-a"));
        WebElement elementB = driver.findElement(By.id("column-b"));
        Actions action = new Actions(driver);
        action.dragAndDrop(elementA, elementB).build().perform();
        Assert.assertTrue(elementA.getText().equalsIgnoreCase("B"));
        Assert.assertTrue(elementB.getText().equalsIgnoreCase("A"));
        // for some reason drag and drop is not working
    }
}
