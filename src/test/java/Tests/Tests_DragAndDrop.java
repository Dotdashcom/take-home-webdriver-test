package Tests;

import Baseclass.BaseClass;
import Pages.Context_Menu_Page;
import Pages.DragAndDrop_Page;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

public class Tests_DragAndDrop extends BaseClass {

    @Test
    public void T005_Drag_and_Drop_Testing() {
        DragAndDrop_Page dragAndDrop_page = new DragAndDrop_Page(driver);

        dragAndDrop_page.GoToDnDPage();
        dragAndDrop_page.MoveElements();
        dragAndDrop_page.AssertChange();



    }

}
