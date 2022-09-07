package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.NewTabPage;
import pages.utils;

import java.util.Iterator;
import java.util.Set;

public class NewTabTest {
    NewTabPage newTabPage;

    public NewTabTest() {
        newTabPage = new NewTabPage();
    }

    @Test
    public void newTabTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/windows");

        newTabPage.clickHereLink();

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iter = windowHandles.iterator();

        String parent = iter.next();
        String child = iter.next();

        driver.switchTo().window(child);
        String newWindowActualTitle = driver.getTitle();
        String newWindowExpectedTitle = "New Window";

        try {
            Assert.assertEquals(newWindowActualTitle, newWindowExpectedTitle);
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



