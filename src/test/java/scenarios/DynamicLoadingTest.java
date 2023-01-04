package scenarios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DynamicLoadingPage;


public class DynamicLoadingTest extends BaseTest {
    private DynamicLoadingPage dynamicLoadingPage;

    @BeforeMethod
    public void setup() {
        dynamicLoadingPage = homePage.gotoDynamicLoadingPage();
    }

    @Test
    public void headerTextIsDisplayedTest() {
        String headerText = dynamicLoadingPage.clickStartButton()
                .getHeaderText();
        Assert.assertEquals(headerText, "Hello World!");
    }
}