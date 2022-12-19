package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.DynamicLoadingPage;
import theinternet.pages.FileDownloadPage;

public class DynamicLoadingPageTests extends BaseTest{
    DynamicLoadingPage dynamicLoadingPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToDynamicLoadingPage();
        dynamicLoadingPage = new DynamicLoadingPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testPageLanding(){
        Assert.assertTrue(dynamicLoadingPage.validatePageLanding());
    }

    @Test(priority = 1)
    public void testDynamicLoading(){
        dynamicLoadingPage.clickOnButton("Start");
        Assert.assertTrue(dynamicLoadingPage.hiddenTextIsDisplayed(), "Element rendered is not displayed");
    }
}
