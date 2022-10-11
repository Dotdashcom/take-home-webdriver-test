package assessment;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import util.Driver;
import util.UI_Util;

public class DragAndDrop extends Driver{

    DragAndDropPage page = new DragAndDropPage(Driver.getDriver());

    @Test
    public void drag_and_drop_test() throws InterruptedException {
        Driver.getDriver().get("http://localhost:7080/drag_and_drop");

        // drag and drop using the actions class was not functioning correctly
//        Driver.getActions().dragAndDrop(page.boxA, page.boxB).build().perform();

//        String originalTextA = page.boxA.getText();
        String originalTextB = page.boxB.getText();
//
        // found javascript executor approach to drag and drop
        UI_Util.move_elements(page.boxA , page.boxB);
//
        String newTextA = page.boxA.getText();
//        String newTextB = page.boxB.getText();

        Assert.assertEquals(newTextA , originalTextB , "drag and drop failed");
//        Assert.assertEquals(newTextB , originalTextA);
    }
}
