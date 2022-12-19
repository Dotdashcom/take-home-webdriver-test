package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.NewWindowsPage;

public class NewWindowsPageTests extends BaseTest{
    NewWindowsPage newWindowsPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToNewWindowsPage();
        newWindowsPage = new NewWindowsPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testPageLanding(){
        Assert.assertTrue(newWindowsPage.validatePageLanding(), "Open new windows page not loaded");
    }

    @Test(priority = 1)
    public void testMouseHover() throws InterruptedException {
        Assert.assertTrue(newWindowsPage.openNewWindow(), "New window not found");
    }
}
