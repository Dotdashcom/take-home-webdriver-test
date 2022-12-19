package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.ContextMenuPage;

public class ContextMenuPageTests extends BaseTest{

    ContextMenuPage contextMenuPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToContextMenuPage();
        contextMenuPage = new ContextMenuPage();
        Thread.sleep(2000);
    }


    @Test(priority = 0)
    public void testPageLanding(){
        Assert.assertTrue(contextMenuPage.validatePageLanding(), "Context menu page not loaded");
    }
    @Test(priority = 1)
    public void testAlertText() throws InterruptedException {
        String alertText = "You selected a context menu";
        Assert.assertEquals(contextMenuPage.getAlertText(), alertText, "Alert text does not match");
    }
    @Test(priority = 2)
    public void testDismissAlert() throws InterruptedException {
        Assert.assertTrue(contextMenuPage.closeAlert(), "Unable to dismiss alert");
    }
}
