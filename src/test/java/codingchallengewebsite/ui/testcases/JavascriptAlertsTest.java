package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.JavascriptAlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavascriptAlertsTest extends UITests {

    public JavascriptAlertsTest() {
    }

    @Test(description="Popups appear on button click")
    public void popupDisplay() {
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(this.driver, this);

        Assert.assertTrue(javascriptAlertsPage.isPageOpen(), "Page not open");
        Assert.assertTrue(javascriptAlertsPage.validatePopupsDisplay(true), "Popup(s) didn't appear as expected");
    }

    @Test(description="Popups messages are as expected")
    public void popupMessages() {
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(this.driver, this);

        Assert.assertTrue(javascriptAlertsPage.isPageOpen(), "Page not open");
        Assert.assertTrue(javascriptAlertsPage.validatePopupsDisplay(false), "Popup(s) aren't showing the expected messages");
    }

    @Test(description="Popup's input field works as expected")
    public void popupInputField() {
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(this.driver, this);

        Assert.assertTrue(javascriptAlertsPage.isPageOpen(), "Page not open");
        Assert.assertTrue(javascriptAlertsPage.validatePopupInputField(), "Input field is not working as expected");
    }
}
