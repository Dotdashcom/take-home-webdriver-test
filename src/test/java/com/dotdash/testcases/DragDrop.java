package com.dotdash.testcases;

import com.dotdash.pageObject.DragDropPage;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class DragDrop extends Setup{
    DragDropPage dragDropPage;

    public DragDrop(){
        this.dragDropPage= MyTestClasses.getObject(DragDropPage.class);

    }

    @Test(testName = "Perform Drag and Drop")
    public void dragAndDrop(){
        navigateTo("drag_and_drop");
        dragDropPage.performDragAndDrop();
        dragDropPage.assertDragAndDrop("A");
    }
}
