package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.ContextMenuPage;
import theinternet.pages.DragAndDropPage;

public class DragAndDropPageTests extends BaseTest{
    DragAndDropPage dragAndDropPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToDragAndDropPage();
        dragAndDropPage = new DragAndDropPage();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void validatePageLanding() throws InterruptedException {
        Assert.assertTrue(dragAndDropPage.validatePageLanding());
    }

    @Test(priority = 2)
    public void testDragBoxAtoB() throws InterruptedException {
        Assert.assertEquals(dragAndDropPage.getBox1Text(), "A","Box text is not expected value");
        Assert.assertEquals(dragAndDropPage.getBox2Text(), "B","Box text is not expected value");
        dragAndDropPage.dragBox1toBox2();
        Assert.assertEquals(dragAndDropPage.getBox1Text(), "B","Box text is not expected value");
        Assert.assertEquals(dragAndDropPage.getBox2Text(), "A","Box text is not expected value");
    }
}
