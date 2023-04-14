package drag_and_drop_test;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.drag_and_drop_page.DragAndDropPage;

import static org.testng.Assert.assertEquals;

public class DragAndDropTest extends Base {

    @Test
    public void testDragAndDropUsingJavascriptExecutor() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage();
        dragAndDropPage.dragAndDropUsingJavascriptExecutor();
        assertEquals(DragAndDropPage.boxAHeader.getText(),"B");

    }

}
