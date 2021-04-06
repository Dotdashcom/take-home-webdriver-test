package TakeHome.tests;

import TakeHome.pages.HoverPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends TestBase {

    @Test(groups = "Hover")
    public void hoverTest() {
        HoverPage page = new HoverPage();
        for (int i = 1; i <=3 ; i++) {
            page.hoverOverUser(i);
            Assert.assertTrue(page.verifyUserInfoDisplayed(i), "User info for user " + i + " is not displayed after hover over but should");
        }
    }
}
