package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import pages.utils;


public class ContextMenuTest {
    ContextMenuPage contextMenuPage;

    public ContextMenuTest() {
        contextMenuPage = new ContextMenuPage();
    }

    @Test
    public void contextMenuTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/context_menu");

        contextMenuPage.rightClick();

        String actualAlertText = contextMenuPage.handleAlert();
        String expectedAlertTest = "You selected a context menu";

        try {
            Assert.assertEquals(actualAlertText, expectedAlertTest);
            System.out.println(actualAlertText + " - passed");
        } catch (AssertionError e) {
            System.out.println(expectedAlertTest + " - failed");
            throw e;
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



