package com.academy.techcenture;

import com.academy.techcenture.pages.DragAndDropPage;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseClassTest {

    @Test (enabled = false)
    public void dragAndDropTest() throws InterruptedException {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver, softAssert);
        dragAndDropPage.navigateTo("/drag_and_drop");
        dragAndDropPage.dragAndDrop();
    }

}
