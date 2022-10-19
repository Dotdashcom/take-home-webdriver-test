package com.dotdash.tests;

import com.dotdash.pages.DynamicControlsPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test08_DynamicControls {

    /**
     * Test clicks on the Remove Button and uses explicit wait.
     * Test asserts that the checkbox is gone.
     * Test clicks on Add Button and uses explicit wait.
     * Test asserts that the checkbox is present.
     * Test clicks on the Enable Button and uses explicit wait.
     * Test asserts that the text box is enabled.
     * Test clicks on the Disable Button and uses explicit wait.
     * Test asserts that the text box is disabled.
     */

    @Test
    public void dynamicControlsCheckboxTest() {

        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

        String url = ConfigurationReader.getProperty("base.url") + "/dynamic_controls";
        Driver.getDriver().get(url);

        Assert.assertTrue(dynamicControlsPage.checkbox.isDisplayed());

        dynamicControlsPage.removeAndAddBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loading));

        Assert.assertEquals(dynamicControlsPage.message.getText(), "It's gone!");

        dynamicControlsPage.removeAndAddBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loading));

        Assert.assertTrue(dynamicControlsPage.checkbox.isDisplayed());
        Assert.assertEquals(dynamicControlsPage.message.getText(), "It's back!");

        Driver.closeDriver();
    }

    @Test
    public void dynamicControlsTextboxTest() {

        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

        String url = ConfigurationReader.getProperty("base.url") + "/dynamic_controls";
        Driver.getDriver().get(url);

        Assert.assertFalse(dynamicControlsPage.textBox.isEnabled());

        dynamicControlsPage.enableAndDisableBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loading));

        Assert.assertEquals(dynamicControlsPage.message.getText(), "It's enabled!");
        Assert.assertTrue(dynamicControlsPage.textBox.isEnabled());

        dynamicControlsPage.enableAndDisableBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loading));

        Assert.assertFalse(dynamicControlsPage.textBox.isEnabled());
        Assert.assertEquals(dynamicControlsPage.message.getText(), "It's disabled!");

        Driver.closeDriver();
    }

}
