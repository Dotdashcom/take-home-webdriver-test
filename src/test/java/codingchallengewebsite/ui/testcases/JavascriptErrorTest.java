package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.JavascriptErrorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavascriptErrorTest extends UITest {

    public JavascriptErrorTest() { }

    @Test(description = "We see the page with the right error message")
    public void validateErrorMessage() {
        JavascriptErrorPage javascriptErrorPage = new JavascriptErrorPage(this);

        // Validate page loaded
        Assert.assertTrue(javascriptErrorPage.isPageOpen(), "Page not open");

        // Validate expected error message
        Assert.assertTrue(javascriptErrorPage.validateErrorMessage(), "Message was not expected");
    }
}