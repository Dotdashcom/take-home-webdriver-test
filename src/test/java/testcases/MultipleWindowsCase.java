package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MultipleWindowsPage;
import utils.ConfigReader;
import utils.Driver;

import java.util.Set;

public class MultipleWindowsCase {
    MultipleWindowsPage multipleWindowsPage = new MultipleWindowsPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "windows";
        Driver.getDriver().get(url);
    }

    @Test
    public void testSuccess() {
        multipleWindowsPage.clickHere.click();
        String currentWindowID = Driver.getDriver().getWindowHandle();
        Driver.getDriver().getWindowHandle();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        for(String windowID : windows) {
            if(!windowID.equals(currentWindowID))
                Driver.getDriver().switchTo().window(windowID);
        }
        Assert.assertTrue(Driver.getDriver().getTitle().equals("New Window"));
    }

    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}

