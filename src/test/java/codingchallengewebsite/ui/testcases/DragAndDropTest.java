package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends UITest {

    public DragAndDropTest() { }

    @Test(description="Drags box A over box B")
    public void dragLeftToRight() {
        String boxOneLetter = "A", boxTwoLetter = "B";
        DragAndDropPage dragAndDropPage = new DragAndDropPage(this);

        // Validate page loaded
        Assert.assertTrue(dragAndDropPage.isPageOpen(), "Page not open");

        // Validate initial settings
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxOne"), boxOneLetter);
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxTwo"), boxTwoLetter);

        // Drag left box over right box
        dragAndDropPage.dragAndDropBox("boxA", "boxB");

        // Validate expected outcome
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxOne"), boxTwoLetter);
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxTwo"), boxOneLetter);
    }

    @Test(description="Drags box B over box A")
    public void dragRightToLeft() {
        String boxOneLetter = "A";
        String boxTwoLetter = "B";
        DragAndDropPage dragAndDropPage = new DragAndDropPage(this);

        // Validate page loaded
        Assert.assertTrue(dragAndDropPage.isPageOpen(), "Page not open");

        // Validate initial settings
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxOne"), boxOneLetter);
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxTwo"), boxTwoLetter);

        // Drag left box over right box
        dragAndDropPage.dragAndDropBox("boxB", "boxA");

        // Validate expected outcome
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxOne"), boxTwoLetter);
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxTwo"), boxOneLetter);
    }

    @Test(description="Drags box A over box B, then box B over box A")
    public void dragBothWays() {
        String boxOneLetter = "A";
        String boxTwoLetter = "B";
        DragAndDropPage dragAndDropPage = new DragAndDropPage(this);

        // Validate page loaded
        Assert.assertTrue(dragAndDropPage.isPageOpen(), "Page not open");

        // Validate initial settings
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxOne"), boxOneLetter);
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxTwo"), boxTwoLetter);

        // Drag left box over right box
        dragAndDropPage.dragAndDropBox("boxA", "boxB");

        // Validate expected outcome
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxOne"), boxTwoLetter);
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxTwo"), boxOneLetter);

        // Drag right box over left box
        dragAndDropPage.dragAndDropBox("boxB", "boxA");

        // Validate expected outcome
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxOne"), boxOneLetter);
        Assert.assertEquals(dragAndDropPage.getBoxLetter("boxTwo"), boxTwoLetter);
    }
}
