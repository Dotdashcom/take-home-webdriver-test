package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.DynamicLoadingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends UITest {

    public DynamicLoadingTest() { }

    @Test(description="Start button loads a message")
    public void loadMessage() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(this);
        String expectedMessage = "Hello World!";
        String actualMessage;

        // Validate page loaded
        Assert.assertTrue(dynamicLoadingPage.isPageOpen(), "Page not open");

        // Validate the dynamically loaded element
        dynamicLoadingPage.startMessageRequest();
        actualMessage = dynamicLoadingPage.getSuccessMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}