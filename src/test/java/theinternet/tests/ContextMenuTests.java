package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.ContextMenuPage;
import theinternet.pages.Navigation;

public class ContextMenuTests extends BaseTest{

    private ContextMenuPage contextMenuPage;
    private Navigation navigation;

    @BeforeClass
    private void initialize(){
        contextMenuPage = new ContextMenuPage();
        navigation = new Navigation();
    }

    @Test(priority = 0)
    public void navigateToContextMenuPage(){
        Assert.assertTrue(navigation.navigateToContextMenuPage());
    }

    @Test(priority = 1)
    public void validatePageLanding(){
        Assert.assertTrue(contextMenuPage.validatePageLanding());
    }
    @Test(priority = 2)
    public void confirmAlertText() throws InterruptedException {
        Assert.assertEquals(contextMenuPage.alertTest(), "You selected a context menu", "Alert box text does not match");
    }

    @Test(priority = 3)
    public void dismissAlert() throws InterruptedException {
        Assert.assertTrue(contextMenuPage.closeAlert());
    }
}
