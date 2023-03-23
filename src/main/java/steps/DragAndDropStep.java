package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.DragAndDropPage;

public class DragAndDropStep {

    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Step("Drag element A to element B")
    public void switchElements (){
        dragAndDropPage.dragElements(dragAndDropPage.elementA, dragAndDropPage.elementB);
    }

    @Step("Check that the text on element A and B are switched")
    public void checkElementsText(){
        Assert.assertEquals(dragAndDropPage.getElementText(dragAndDropPage.elementA), "B");
        Assert.assertEquals(dragAndDropPage.getElementText(dragAndDropPage.elementB), "A");
    }
}
