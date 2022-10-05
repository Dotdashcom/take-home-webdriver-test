package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import com.dotdash.pages.DragAndDropPage;


public class Test_05_DragAndDrop extends TestBase {
    @Test
    public void drag_and_drop_test() {

        DragAndDropPage dragAndDropPage = new DragAndDropPage();
        dragAndDropPage.navigatePages("Drag and Drop");

        Actions actions = new Actions(DriverUtils.getDriver());

        actions.dragAndDrop(dragAndDropPage.figureA, dragAndDropPage.figureB).perform();

        Assertions.assertEquals("A", dragAndDropPage.text.getText());

    }
}
