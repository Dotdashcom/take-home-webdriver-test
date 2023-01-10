package tests;

import model.DynamicLoadingPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class DynamicLoadingTest extends BaseTest {

    @Test
    public void testResultMessageText() {
        String expectedResult = "Hello World!";

        String actualResult = new DynamicLoadingPage(getDriver())
                .getDynamicLoadingPage()
                .clickAndWaitStartButton()
                .getResultMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testStartButtonText() {
        String expectedResult = "Start";

        String actualResult = new DynamicLoadingPage(getDriver())
                .getDynamicLoadingPage()
                .getStartButtonText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testWaitbarImageDisplayed() {
        boolean actualResult = new DynamicLoadingPage(getDriver())
                .getDynamicLoadingPage()
                .clickStartButton()
                .isWaitbarImageDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testWaitbarImageNotDisplayed() {
        boolean actualResult = new DynamicLoadingPage(getDriver())
                .getDynamicLoadingPage()
                .clickAndWaitStartButton()
                .isWaitbarImageDisplayed();

        Assert.assertFalse(actualResult);
    }

    @Test
    public void testLoadingMessageDisplayed() {
        boolean actualResult = new DynamicLoadingPage(getDriver())
                .getDynamicLoadingPage()
                .clickStartButton()
                .isLoadingMessageDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testLoadingMessageNotDisplayed() {
        boolean actualResult = new DynamicLoadingPage(getDriver())
                .getDynamicLoadingPage()
                .clickAndWaitStartButton()
                .isLoadingMessageDisplayed();

        Assert.assertFalse(actualResult);
    }

    @Test
    public void testLoadingMessageText() {
        String expectedResult = "Loading...";

        String actualResult = new DynamicLoadingPage(getDriver())
                .getDynamicLoadingPage()
                .clickStartButton()
                .getLoadingMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testResultMessageDisplayed() {
        boolean actualResult = new DynamicLoadingPage(getDriver())
                .getDynamicLoadingPage()
                .clickAndWaitStartButton()
                .isResultMessageDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testResultMessageNotDisplayed() {
        boolean actualResult = new DynamicLoadingPage(getDriver())
                .getDynamicLoadingPage()
                .clickStartButton()
                .isResultMessageNotDisplayed();

        Assert.assertTrue(actualResult);
    }
}