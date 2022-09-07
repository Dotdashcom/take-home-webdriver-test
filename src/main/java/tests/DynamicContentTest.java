package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.DynamicContentPage;
import pages.utils;


public class DynamicContentTest {
    DynamicContentPage dynamicContentPage;

    public DynamicContentTest() {
        dynamicContentPage = new DynamicContentPage();
    }

    @Test
    public void dynamicContentTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/dynamic_content");

        int refreshTimes = 5;
        String beforeRefresh = dynamicContentPage.dynamicContent();
        for (int i = 0; i < refreshTimes; i++) {
            dynamicContentPage.refreshContent();
        }
        String afterRefresh = dynamicContentPage.dynamicContent();

        try {
            Assert.assertNotEquals(beforeRefresh, afterRefresh);
            System.out.println(" passed");
        } catch (AssertionError e) {
            System.out.println(" failed");
            throw e;
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



