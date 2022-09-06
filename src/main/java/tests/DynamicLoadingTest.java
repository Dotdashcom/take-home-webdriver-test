package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.utils;


public class DynamicLoadingTest {
    DynamicLoadingPage dynamicLoadingPage;

    public DynamicLoadingTest() {
        dynamicLoadingPage = new DynamicLoadingPage();
    }

    @Test
    public void dynamicLoadingTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/dynamic_loading/2");

        String expectedText = "Hello World!";
        dynamicLoadingPage.clickOnStartBtn();
        String actualText = dynamicLoadingPage.getFinishText();

        try {
            Assert.assertEquals(actualText, expectedText);
            System.out.println("passed");
        } catch (AssertionError e) {
            System.out.println("failed");
            throw e;
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



