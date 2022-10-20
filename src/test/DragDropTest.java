package src.test;
import org.testng.annotations.*;
import src.main.pages.*;
import src.main.utilities.Browser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class DragDropTest extends BaseTest {
    private DragDropPage dragdropPage;

    @Test
    public void dragDropTest() {
        dragdropPage = Browser.open(baseURL + "drag_and_drop", DragDropPage.class);
        assertEquals(dragdropPage.getFirstElementHeader(), "A");
        dragdropPage.dragAToB();
        assertEquals(dragdropPage.getFirstElementHeader(), "B");
    }

}
