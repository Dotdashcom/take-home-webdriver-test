package com.framework.testcases;

import com.framework.pages.DragAndDropPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropPageTest extends TestBase {
    DragAndDropPage dragAndDropPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }

    @AfterTest
    public void teardown() {
        super.cleanup();
    }

    @Test(priority = 1, description = "User is on the drag and drop page")
    public void user_is_on_drag_and_drop_page() {
        dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.navigate();
        String actualURL = dragAndDropPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/drag_and_drop";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "User can perform drag and drop")
    public void user_can_perform_drag_and_drop() throws Exception {
        dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.navigate();
        Boolean canDragAndDrop = dragAndDropPage.dragAndDropAOverB().verifyDragAndDrop();
        Assert.assertTrue(canDragAndDrop);
    }
}
