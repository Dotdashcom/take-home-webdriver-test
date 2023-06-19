package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.IFramePage;

import static org.testng.Assert.assertTrue;

public class IFrameTest extends BaseTest{
    @Test
    public void verifyIFrame() {
        HomePage homePage = new HomePage(driver);
        IFramePage iframe = homePage.clickFrame();
        String message = "type something here";
        iframe.enterTextInBox(message);
        assertTrue(iframe.verifyTextInBox().equals(message));
    }
}
