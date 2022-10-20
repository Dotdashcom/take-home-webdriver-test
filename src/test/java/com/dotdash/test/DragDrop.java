package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.CommonMethods;
import org.testng.annotations.Test;

public class DragDrop extends TestBase {

    @Test(testName = "Perform Drag and Drop")
    public void dragAndDrop() {
        CommonMethods.navigateTo("drag_and_drop");
        CommonMethods.dragAndDropInHtml5(dragDropPage.dragBox, dragDropPage.dropBox);
        CommonMethods.threadWait(1000);
        CommonMethods.isDisplayed(dragDropPage.displayBox);
    }
}
