package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.JavascriptErrorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavascriptErrorTest extends UITests {

    public JavascriptErrorTest() {
    }

    @Test(description = "We see the page with the right error message")
    public void validateErrorMessage() {
        JavascriptErrorPage javascriptErrorPage = new JavascriptErrorPage(this.driver, this);
        Assert.assertTrue(javascriptErrorPage.isPageOpen(), "Page not open");

        Assert.assertTrue(javascriptErrorPage.validateErrorMessage(), "Message was not as expected");
    }
}
