package TakeHome.tests;

import TakeHome.pages.BasePage;
import TakeHome.pages.DragAndDropPage;
import TakeHome.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class DragAndDropPageTest extends TestBase {

    @Test(groups = {"DragDrop"})
    public void Drag_AtoB() throws AWTException {
        BrowserUtils.waitForPageToLoad(3);
        DragAndDropPage drag = new DragAndDropPage();
        drag.dragAtoB();

        Assert.assertEquals(drag.getColumnAText(), "B", "Since 'A' is dragged to 'B', the first column should be 'B' but was not");
    }

    @Test(groups = {"DragDrop"})
    public void Drag_BtoA(){
        BrowserUtils.waitForPageToLoad(3);
        DragAndDropPage drag = new DragAndDropPage();
        drag.dragBtoA();

        Assert.assertEquals(drag.getColumnAText(), "B", "Since 'B' is dragged to 'A', the first column should be 'B' but was not");
    }
}
