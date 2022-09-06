package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;
import pages.utils;


public class FloatingMenuTest {
    FloatingMenuPage floatingMenuPage;

    public FloatingMenuTest() {
        floatingMenuPage = new FloatingMenuPage();
    }

    @Test
    public void floatingMenuTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/floating_menu");
        Actions actions = new Actions(TestBase.getInstance().getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        try {
            Assert.assertTrue(floatingMenuPage.floatingMenu().isDisplayed());
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



