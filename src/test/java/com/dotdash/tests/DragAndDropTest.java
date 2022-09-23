package com.dotdash.tests;

import com.dotdash.pages.DragAndDropPage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest extends TestBase {


    @Test
    public void dragAndDropTest() {

        DragAndDropPage dragAndDropPage = new DragAndDropPage();
        dragAndDropPage.navigatePages("Drag and Drop");

        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(dragAndDropPage.figureA, dragAndDropPage.figureB).perform();

        Assertions.assertEquals("A", dragAndDropPage.text.getText());

    }
}
