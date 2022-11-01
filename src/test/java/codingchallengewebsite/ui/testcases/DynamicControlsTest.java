package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.DynamicControlsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends UITest {

    public DynamicControlsTest() { }

    @Test(description="Removes and adds a checkbox")
    public void checkboxTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(this);
        int testAttempts = 3;

        // Validate page loaded
        Assert.assertTrue(dynamicControlsPage.isPageOpen(), "Page not open");

        // Validates checkbox add/remove behaviour
        while (testAttempts > 0) {
            // Remove checkbox
            dynamicControlsPage.removeCheckboxButton();
            // Validate removed checkbox
            Assert.assertFalse(dynamicControlsPage.isCheckboxEnabled(), "Checkbox is enabled");
            // Add checkbox
            dynamicControlsPage.addCheckboxButton();
            // Validate added checkbox
            Assert.assertTrue(dynamicControlsPage.isCheckboxEnabled(), "Checkbox is disabled");
            testAttempts--;
        }

        // Same as above but reloading the page
        testAttempts = 2;
        while (testAttempts > 0) {
            // Remove checkbox
            dynamicControlsPage.removeCheckboxButton();
            // Validate removed checkbox
            Assert.assertFalse(dynamicControlsPage.isCheckboxEnabled(), "Checkbox is enabled");
            // Add checkbox
            dynamicControlsPage.addCheckboxButton();
            // Validate added checkbox
            Assert.assertTrue(dynamicControlsPage.isCheckboxEnabled(), "Checkbox is disabled");
            // Reload the page
            dynamicControlsPage.reloadPage();
            testAttempts--;
        }
    }

    @Test(description = "Toggles the checkbox on and off")
    public void toggleCheckbox() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(this);

        // Validate page loaded
        Assert.assertTrue(dynamicControlsPage.isPageOpen(), "Page not open");
        // Validate checkbox toggle behaviour
        Boolean currentState = dynamicControlsPage.isCheckboxSelected();
        dynamicControlsPage.clickCheckbox();
        Assert.assertEquals(dynamicControlsPage.isCheckboxSelected(), !currentState);
        dynamicControlsPage.clickCheckbox();
        Assert.assertEquals(dynamicControlsPage.isCheckboxSelected(), currentState);
    }

    @Test(description = "Enables and disables the textbox")
    public void textboxTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(this);

        // Validate page loaded
        Assert.assertTrue(dynamicControlsPage.isPageOpen(), "Page not open");
        // Validate textbox enabled
        dynamicControlsPage.enableTextBox();
        Assert.assertTrue(dynamicControlsPage.isTextboxEnabled(), "Textbox is disabled");
        // Validate textbox disabled
        dynamicControlsPage.disableTextBox();
        Assert.assertFalse(dynamicControlsPage.isTextboxEnabled(), "Textbox is enabled");
    }
}