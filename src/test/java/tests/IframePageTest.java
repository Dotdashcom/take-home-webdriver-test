package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IframePage;

public class IframePageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "iframeUrl", "iframeText"})
    public void iframe_Test(String baseUrl, String iframeUrl, String iframeText) {
        IframePage iframePage = new IframePage(driver);
        iframePage.goToUrl(baseUrl , iframeUrl);

        iframePage.switchIframe();
        iframePage.clearText();
        iframePage.typeText(iframeText);
        Assert.assertTrue(iframePage.getText().equals(iframeText));
    }
}
