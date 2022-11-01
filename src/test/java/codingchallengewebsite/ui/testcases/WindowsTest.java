package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTest extends UITest {

    public WindowsTest() { }

    @Test(description = "Click on link; see a new tab with the expected message")
    public void validateNewTab() {
        WindowsPage windowsPage = new WindowsPage(this);
        // Validate page loaded
        Assert.assertTrue(windowsPage.isPageOpen(), "Page not open");
        // Validate expected message in new tab
        Assert.assertTrue(windowsPage.validateNewTab(), "Couldn't validate the new message and/or the new tab");
    }

}
