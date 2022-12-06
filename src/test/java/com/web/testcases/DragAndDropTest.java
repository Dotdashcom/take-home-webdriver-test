package com.web.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.DragAndDropPage;


public class DragAndDropTest  extends TestBase{

    DragAndDropPage dragAndDropPage;

    public DragAndDropTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/drag_and_drop");
        dragAndDropPage = new DragAndDropPage();
    }

    @Test()
    public void verifyDragAndDrop() {
        Actions builder = new Actions(driver);
        builder.dragAndDrop(dragAndDropPage.getdragDropBoxAElement(),dragAndDropPage.getdragDropBoxBElement()).build().perform();
        String textTo = dragAndDropPage.getdragDropBoxBElement().getText();

        Assert.assertEquals(textTo,"B");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
