package TakeHome.tests;

import TakeHome.pages.FloatingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingTest extends TestBase {

    @Test(groups = "Floating")
    public void TestingMenu(){
        FloatingPage page = new FloatingPage();
        Assert.assertTrue(page.verifyMenu(), "Floating menu is not displayed");

        String firstMenu = page.getFloatingMenuText();
        driver.navigate().refresh();
        String menuAfterRefresh = page.getFloatingMenuText();

        Assert.assertNotEquals(firstMenu, menuAfterRefresh, "Floating menu text did not change after refresh");
    }
}
