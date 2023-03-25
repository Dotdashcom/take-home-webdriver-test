package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;

public class DynamicControlsPageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "dynamicControlsUrl","dynamicControlsRemoveMessage","dynamicControlsAddMessage","dynamicControlsEnableMessage","dynamicControlsDisableMessage"})
    public void dynamic_Controls_Test(String baseUrl, String dynamicControlsUrl, String dynamicControlsRemoveMessage, String dynamicControlsAddMessage, String dynamicControlsEnableMessage, String dynamicControlsDisableMessage) {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.goToUrl(baseUrl , dynamicControlsUrl);

        dynamicControlsPage.clickRemoveAddButton();
        Assert.assertTrue(dynamicControlsPage.getMessage().equals(dynamicControlsRemoveMessage));

        dynamicControlsPage.clickRemoveAddButton();
        Assert.assertTrue(dynamicControlsPage.getMessage().equals(dynamicControlsAddMessage));
        Assert.assertTrue(dynamicControlsPage.isCheckboxEnabled());

        dynamicControlsPage.clickEnableDisableButton();
        Assert.assertTrue(dynamicControlsPage.getMessage().equals(dynamicControlsEnableMessage));
        Assert.assertTrue(dynamicControlsPage.isInputFieldEnabled());

        dynamicControlsPage.clickEnableDisableButton();
        Assert.assertTrue(dynamicControlsPage.getMessage().equals(dynamicControlsDisableMessage));
        Assert.assertFalse(dynamicControlsPage.isInputFieldEnabled());
    }
}
