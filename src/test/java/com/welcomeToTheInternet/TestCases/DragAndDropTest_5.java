package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DragAndDropPage;
import org.testng.annotations.Test;

public class DragAndDropTest_5 extends BaseClass {

    @Test
    public void DragAndDropTest() throws InterruptedException {
        driver.get(baseURL);
        DragAndDropPage dragAndDrop = new DragAndDropPage(driver);

        dragAndDrop.clickDragAndDropLink();
        dragAndDrop.makeDragAndDrop();
        Thread.sleep(4000);
        // need assertion
    }
}
