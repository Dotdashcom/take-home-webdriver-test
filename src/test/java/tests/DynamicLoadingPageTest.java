package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

public class DynamicLoadingPageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "dynamicLoadingUrl", "dynamicLoadingMessage"})
    public void dynamic_Loading_Test(String baseUrl, String dynamicLoadingUrl, String dynamicLoadingMessage) {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.goToUrl(baseUrl , dynamicLoadingUrl);

        dynamicLoadingPage.clickStartButton();
        Assert.assertTrue(dynamicLoadingPage.getMessage().equals(dynamicLoadingMessage));
    }
}
