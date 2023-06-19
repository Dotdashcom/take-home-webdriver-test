package tests;

import org.testng.annotations.Test;
import pages.DragAndDropPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class DragAndDropTest extends BaseTest{
    @Test
    public void dragAndDrop() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        DragAndDropPage dragDrop = homePage.clickDragAndDrop();
        dragDrop.dragAndDrop();
        assertTrue(dragDrop.getTextFromFieldB().equals("A"));
    }
}
