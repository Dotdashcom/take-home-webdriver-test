package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.DynamicControlsPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

public class TestDynamicControls {
    DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "dynamic_controls";
        Driver.getDriver().get(url);
    }

    @Test
    public void testRemoveAdd() {
        dynamicControlsPage.removeBtn.click();
        BrowserUtils.highlightElement(dynamicControlsPage.removeBtn);
        BrowserUtils.waitForVisibility(dynamicControlsPage.message1);
        Assert.assertEquals("It's gone!", dynamicControlsPage.message1.getText());

        dynamicControlsPage.addBtn.click();
        BrowserUtils.highlightElement(dynamicControlsPage.addBtn);
        BrowserUtils.waitForVisibility(dynamicControlsPage.message1);
        Assert.assertTrue(dynamicControlsPage.checkBox.isDisplayed());
        Assert.assertEquals("It's back!", dynamicControlsPage.message1.getText());
    }
    @Test
    public void testEnableDisable() {
        dynamicControlsPage.enableBtn.click();
        BrowserUtils.highlightElement(dynamicControlsPage.enableBtn);
        BrowserUtils.waitForVisibility(dynamicControlsPage.message2);
        Assert.assertEquals("It's enabled!", dynamicControlsPage.message2.getText());

        dynamicControlsPage.disableBtn.click();
        BrowserUtils.highlightElement(dynamicControlsPage.disableBtn);
        BrowserUtils.waitForVisibility(dynamicControlsPage.message2);
        Assert.assertEquals("It's disabled!", dynamicControlsPage.message2.getText());
    }
    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
