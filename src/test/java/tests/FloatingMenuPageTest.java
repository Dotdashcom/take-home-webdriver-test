package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;

public class FloatingMenuPageTest extends TestConfiguration {
    @Test
    @Parameters({"baseUrl", "floatingMenuUrl"})
    public void floating_Menu_Test(String baseUrl, String floatingMenuUrl) {
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        floatingMenuPage.goToUrl(baseUrl , floatingMenuUrl);

        floatingMenuPage.scrollDown();
        Assert.assertTrue(floatingMenuPage.menuDisplayed());
    }
}
