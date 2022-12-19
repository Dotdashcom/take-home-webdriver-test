package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.DynamicControlsPage;

public class DynamicControlsPageTests extends BaseTest{
    DynamicControlsPage dynamicControlsPages;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToDynamicControlsPage();
        dynamicControlsPages= new DynamicControlsPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testPageLanding(){
        Assert.assertTrue(dynamicControlsPages.validatePageLanding(), "Checkbox page not loaded");
    }

    @Test(priority = 1)
    public void testCheckBox(){
        dynamicControlsPages.clickOnButton("Remove");
        Assert.assertFalse(dynamicControlsPages.checkBoxIsDisplayed(), "Checkbox is still displayed");
        dynamicControlsPages.clickOnButton("Add");
        Assert.assertTrue(dynamicControlsPages.checkBoxIsDisplayed(), "Checkbox is not displayed");
    }

    @Test(priority = 2)
    public void testTextBox(){
        dynamicControlsPages.clickOnButton("Enable");
        Assert.assertTrue(dynamicControlsPages.textBoxIsEnabled(), "TextBox is not enabled");
        dynamicControlsPages.clickOnButton("Disable");
        Assert.assertFalse(dynamicControlsPages.textBoxIsEnabled(), "TextBox is enabled");
    }
}
