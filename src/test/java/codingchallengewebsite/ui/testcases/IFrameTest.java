package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.IFramePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends UITests {

    public IFrameTest() {
    }

    @Test(description = "Switches between contexts and performs operations")
    public void testContextSwitching() {
        IFramePage iFramePage = new IFramePage(this.driver, this);
        String textBucket = "Test in progress...", tmp;
        Assert.assertTrue(iFramePage.isPageOpen(), "Page not open");

        // Write to the textarea inside the iframe
        driver = iFramePage.switchTo("iframe");
        tmp = iFramePage.getIFrameTextAreaText().toString();
        iFramePage.writeIFrameTextAreaText(textBucket);
        Assert.assertEquals(iFramePage.getIFrameTextAreaText(), new StringBuilder(tmp).append(textBucket).toString(), "Actual text doesn't match expected text");

        // Access the main page's title
        tmp = driver.toString();
        this.driver = iFramePage.switchTo("main");
        textBucket = iFramePage.getPageTitle();
        Assert.assertEquals(iFramePage.getPageTitle(), textBucket, "Page title doesn't match the previous value");
        Assert.assertEquals(tmp, this.driver.toString(), "Context didn't change");

        // Write to the textarea
        tmp = this.driver.toString();
        this.driver = iFramePage.switchTo("iframe");
        iFramePage.clearIFrameTextAreaText();
        iFramePage.writeIFrameTextAreaText(textBucket);
        Assert.assertEquals(iFramePage.getIFrameTextAreaText(), textBucket, "Textarea text doesn't match the expected text");
        Assert.assertEquals(tmp, this.driver.toString(), "Context didn't change");

        // Clear the textarea
        iFramePage.clearIFrameTextAreaText();
        Assert.assertTrue(iFramePage.getIFrameTextAreaText().toString().isEmpty(), "Textarea should be empty");

        // Write to the textarea
        textBucket = iFramePage.getIFrameTextAreaText();
        textBucket = new StringBuilder(textBucket).reverse().toString();
        iFramePage.writeIFrameTextAreaText(textBucket);
        Assert.assertEquals(iFramePage.getIFrameTextAreaText(), textBucket, "Textarea text doesn't match the expected text");
    }
}
