package TakeHome.tests;

import TakeHome.pages.IFramePage;
import TakeHome.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends TestBase {

    @Test(groups = "Iframes")
    public void TestFrames(){
        IFramePage page = new IFramePage();
        page.switchFrameAndSendText();
        Assert.assertEquals(page.getTextInIframe(), "Hello There!!!", "The text in the box in iframe is not as expected");
        BrowserUtils.waitFor(3);
    }
}
