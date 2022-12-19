package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.DynamicLoadingPage;
import theinternet.pages.MouseHoverPage;

public class MouseHoverPageTests extends BaseTest{
    MouseHoverPage mouseHoverPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToMouseHoverPage();
        mouseHoverPage = new MouseHoverPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testPageLanding(){
        Assert.assertTrue(mouseHoverPage.validatePageLanding(), "Mouse hover page not loaded");
    }

    @Test(priority = 1)
    public void testMouseHover() throws InterruptedException {
        Assert.assertTrue(mouseHoverPage.mouseHover("1"), "Mouse hover over image 1 for additional information failed");
        Assert.assertTrue(mouseHoverPage.mouseHover("2"), "Mouse hover over image 2 for additional information failed");
        Assert.assertTrue(mouseHoverPage.mouseHover("3"), "Mouse hover over image 3 for additional information failed");
    }
}
