package TakeHome.tests;

import TakeHome.pages.ContextPage;
import TakeHome.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextTest extends TestBase {

    @Test(groups = {"Context"})
    public void verifyAlertTest(){
        ContextPage contextPage = new ContextPage();
        BrowserUtils.waitForPageToLoad(5);

        contextPage.contextClick();
        Assert.assertEquals(contextPage.getAlertText(),"You selected a context menu", "Correct alert message did not display");

        contextPage.acceptMessage();
        Assert.assertFalse(contextPage.verifyAlertDisplayed(), "Context menu alert should have been disappeared but is not");
    }
}
