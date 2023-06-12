package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.OpenNewTabPage;

import static org.testng.Assert.assertEquals;

public class OpenNewTabTest extends BaseTest{
    @Test
    public void opinNewTab() {
        HomePage homePage = new HomePage(driver);
        OpenNewTabPage newTabs = homePage.clickOpenNewTab();
        assertEquals(newTabs.switchToTabs(), "New Window");
    }
}
