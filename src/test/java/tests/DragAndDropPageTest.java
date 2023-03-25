package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropPageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "dragAndDropUrl","boxAText","boxBText"})
    public void drag_and_Drop_Test(String baseUrl, String dragAndDropUrl, String boxAText, String boxBText) throws Exception {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.goToUrl(baseUrl , dragAndDropUrl);

        dragAndDropPage.dragAndDrop();
        Assert.assertTrue(dragAndDropPage.getColumnAText().equals(boxAText));
        Assert.assertTrue(dragAndDropPage.getColumnBText().equals(boxBText));
    }
}
