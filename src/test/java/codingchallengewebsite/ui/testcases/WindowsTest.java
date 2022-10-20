package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.JavascriptErrorPage;
import codingchallengewebsite.ui.pageobjects.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTest extends UITests {

    public WindowsTest() {
    }

    @Test(description = "Click on link; see a new tab with the expected message")
    public void validateNewTab() {
        WindowsPage windowsPage = new WindowsPage(this.driver, this);
        Assert.assertTrue(windowsPage.isPageOpen(), "Page not open");

        Assert.assertTrue(windowsPage.validateNewTab(), "Couldn't validate the new message and/or the new tab");
    }

}
