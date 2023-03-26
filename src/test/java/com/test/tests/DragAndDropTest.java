package com.test.tests;

import org.junit.jupiter.api.Test;
import com.test.pages.DragAndDropPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragAndDropTest extends TestBase {

    @Test
    public void testDragAndDrop() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.dragColumnAToColumnB();

        String columnAText = dragAndDropPage.getColumnAText();
        String columnBText = dragAndDropPage.getColumnBText();
        assertEquals("B", columnAText);
        assertEquals("A", columnBText);
    }

}
