package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.IframePage;
import pages.utils;

public class IframeTest {
    IframePage iframePage;

    public IframeTest() {
        iframePage = new IframePage();
    }

    @Test
    public void iframeTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/iframe");

        driver.switchTo().frame(iframePage.getiFrame());
        utils.visibleElementWait(iframePage.getTextBox());
        iframePage.getTextBox().clear();
        iframePage.getTextBox().sendKeys("iFrame Test");

        String expectedText = "iFrame Test";
        String actualText = iframePage.getTextBox().getText();

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



