package com.example.demo;

import pages.DragDropPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class T05DragAndDrop extends TestMain {
    DragDropPage dragDropPage;

    @Test
    public void testDragAndDrop(){
        dragDropPage = new DragDropPage(driver);
        String oldElementAtext = dragDropPage.elementAtext();
        String oldElementBtext = dragDropPage.elementBtext();
        dragDropPage.dragAndDrop();
        Assert.assertEquals(dragDropPage.elementAtext(),oldElementBtext);
        Assert.assertEquals(dragDropPage.elementBtext(),oldElementAtext);


    }
}
