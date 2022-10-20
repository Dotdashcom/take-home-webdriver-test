package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.DynamicLoadingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends UITests {

    public DynamicLoadingTest() {
    }

    @Test(description="Start button loads a message")
    public void loadMessage() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(this.driver, this);
        Assert.assertTrue(dynamicLoadingPage.isPageOpen(), "Page not open");
        String expectedMessage = "Hello World!";
        String actualMessage;

        dynamicLoadingPage.startMessageRequest();

        // Validate the dynamically loaded element
        actualMessage = dynamicLoadingPage.getSuccessMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
