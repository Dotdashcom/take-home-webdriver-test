package com.ddm.testcases;

import com.ddm.pageobjects.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends BaseTestClass {

    protected DragAndDropPage dragAndDropPage;

    @BeforeMethod
    public void setUpMethodDragAndDrop() {
        dragAndDropPage = landingPage.goTo("/drag_and_drop", DragAndDropPage.class);
    }

    @Test
    public void dragAndDropTest() {
        dragAndDropPage.dragAIntoBWithJS();
        Assert.assertEquals(dragAndDropPage.getColumnAText(), "B", "Drag and Drop is NOT successful.");
    }
}
