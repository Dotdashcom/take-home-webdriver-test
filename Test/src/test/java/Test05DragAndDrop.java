

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObject.DragAndDropPage;

public class Test05DragAndDrop extends TestBase{


    @Test
    public void test05DragAndDrop() throws InterruptedException{
        DragAndDropPage dragAndDropPage = new DragAndDropPage(webDriver);

        //before DND, boxA has header A, boxB has header B
        Assert.assertEquals(dragAndDropPage.getBoxAHeader(), "A");
        Assert.assertEquals(dragAndDropPage.getBoxBHeader(), "B");
        dragAndDropPage.dragAndDrop();
        Thread.sleep(2000);
        //after DND, boxA has header B, boxB has header A
        Assert.assertEquals(dragAndDropPage.getBoxAHeader(), "B");
        Assert.assertEquals(dragAndDropPage.getBoxBHeader(), "A");
    }

}