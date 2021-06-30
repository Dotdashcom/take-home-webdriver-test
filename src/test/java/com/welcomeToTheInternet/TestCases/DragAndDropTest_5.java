package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest_5 extends BaseClass {

    @Test
    public void DragAndDropTest() {
        driver.get(baseURL);
        DragAndDropPage dragAndDrop = new DragAndDropPage(driver);

        dragAndDrop.clickDragAndDropLink();
        logger.info("Navigate to the Drag and Drop page");
        dragAndDrop.dragColumnAToColumnB();
        logger.info("Column A was dragged to the Column B");
        if (dragAndDrop.getTextA().equals("B")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }

        dragAndDrop.dragColumnBToColumnA();
        logger.info("Column B was dragged to the Column A");
        if (dragAndDrop.getTextB().equals("A")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }
    }
}
