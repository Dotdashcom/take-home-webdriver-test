package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.FloatingMenuPage;

public class FloatingMenuPageTests extends BaseTest {
    FloatingMenuPage floatingMenuPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToFloatingMenuPage();
        floatingMenuPage = new FloatingMenuPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testPageLanding(){
        Assert.assertTrue(floatingMenuPage.validatePageLanding(), "Floating menu page not loaded");
    }

    @Test(priority = 1)
    public void testFloatingMenu() throws InterruptedException {
        floatingMenuPage.scrollPage();
        Assert.assertTrue(floatingMenuPage.isNavVisible(), "Failed to find Nav");
    }
}
