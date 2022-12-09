package com.test.localhost.tests;

import com.test.localhost.pages.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {

    @Test
    public void dragAndDropTest() throws InterruptedException {
        DragAndDropPage dragAndDropPage=new DragAndDropPage(driver);
        dragAndDropPage.clickDragAndDropButton();
        dragAndDropPage.dragAndDrop(driver);
        Thread.sleep(1000);
        Assert.assertEquals("B",dragAndDropPage.getTextBoxA());
    }

}
