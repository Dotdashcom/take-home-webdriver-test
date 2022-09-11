package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.DragAndDrop;

public class DragAndDropTest extends TestBase {

    @Test
    public void dragAndDropTest() throws InterruptedException {
        DragAndDrop dragAndDrop = new DragAndDrop(driver);
        dragAndDrop.dragAndDropA(driver);
    }
}
