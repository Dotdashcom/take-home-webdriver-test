package Tests;

import Baseclass.BaseClass;
import Pages.DragAndDropPage;
import org.testng.annotations.Test;

public class TestsDragAndDrop extends BaseClass {

    @Test
    public void T005_Drag_and_Drop_Testing() {
        DragAndDropPage dragAndDrop_page = new DragAndDropPage(driver);

        dragAndDrop_page.GoToDnDPage();
        dragAndDrop_page.MoveElements();
        dragAndDrop_page.AssertChange();



    }

}
