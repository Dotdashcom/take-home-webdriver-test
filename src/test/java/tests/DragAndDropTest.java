package tests;

import model.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class DragAndDropTest extends BaseTest {

    @Test
    public void testDragElementAOnElementB() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(getDriver())
                .getDragAndDropPage();
        String originalElementIdOnLeft = dragAndDropPage.getDraggableElementOnLeftText();

        String newElementIdOnLeft = dragAndDropPage
                .dragAndDropLeftElementOnRightElement()
                .getDraggableElementOnLeftText();

        Assert.assertNotEquals(newElementIdOnLeft, originalElementIdOnLeft);
    }

    @Test
    public void testDragElementBOnElementA() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(getDriver())
                .getDragAndDropPage();
        String originalElementIdOnLeft = dragAndDropPage.getDraggableElementOnLeftText();

        String newElementIdOnLeft = dragAndDropPage
                .dragAndDropLeftElementOnRightElement()
                .getDraggableElementOnLeftText();

        Assert.assertNotEquals(newElementIdOnLeft, originalElementIdOnLeft);
    }
}