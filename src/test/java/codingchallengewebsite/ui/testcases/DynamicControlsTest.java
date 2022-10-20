package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.DynamicControlsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends UITests {

    public DynamicControlsTest() {
    }

    @Test(description="Removes and adds a checkbox")
    public void checkboxTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(this.driver, this);
        Assert.assertTrue(dynamicControlsPage.isPageOpen(), "Page not open");
        int attempts = 3;

        while (attempts > 0) {
            // Remove checkbox
            dynamicControlsPage.removeCheckboxButton();
            Assert.assertFalse(dynamicControlsPage.isCheckboxEnabled(), "Checkbox is enabled");

            // Add checkbox
            dynamicControlsPage.addCheckboxButton();
            Assert.assertTrue(dynamicControlsPage.isCheckboxEnabled(), "Checkbox is disabled");

            attempts--;
        }

        attempts = 2;

        // Same as above but reloading the page
        while (attempts > 0) {
            // Remove checkbox
            dynamicControlsPage.removeCheckboxButton();
            Assert.assertFalse(dynamicControlsPage.isCheckboxEnabled(), "Checkbox is enabled");

            // Add checkbox
            dynamicControlsPage.addCheckboxButton();
            Assert.assertTrue(dynamicControlsPage.isCheckboxEnabled(), "Checkbox is disabled");

            // Reloads the page
            dynamicControlsPage.reloadPage();

            attempts--;
        }
    }

    @Test(description = "Toggles the checkbox on and off")
    public void toggleCheckbox() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(this.driver, this);
        Assert.assertTrue(dynamicControlsPage.isPageOpen(), "Page not open");
        boolean currentState = dynamicControlsPage.isCheckboxSelected();

        dynamicControlsPage.clickCheckbox();
        Assert.assertEquals(dynamicControlsPage.isCheckboxSelected(), !currentState);
        dynamicControlsPage.clickCheckbox();
        Assert.assertEquals(dynamicControlsPage.isCheckboxSelected(), currentState);
    }

    @Test(description = "Enables and disables the textbox")
    public void textboxTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(this.driver, this);
        Assert.assertTrue(dynamicControlsPage.isPageOpen(), "Page not open");

        // Enable textbox
        dynamicControlsPage.enableTextBox();
        Assert.assertTrue(dynamicControlsPage.isTextboxEnabled(), "Textbox is disabled");

        // Disable textbox
        dynamicControlsPage.disableTextBox();
        Assert.assertFalse(dynamicControlsPage.isTextboxEnabled(), "Textbox is enabled");
    }
}
