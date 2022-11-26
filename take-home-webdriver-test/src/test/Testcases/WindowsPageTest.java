package com.framework.testcases;
import com.framework.pages.WindowsPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowsPageTest extends TestBase {
    WindowsPage windowsPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }
    @Test(priority = 1, description = "User is on the windows page")
    public void user_is_on_windows_page() {
        windowsPage = new WindowsPage(driver);
        windowsPage.navigate();
        String actualURL = windowsPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/windows";
        Assert.assertEquals(actualURL, expectedURL);
    }
    @Test(priority = 2, description = "User is on the new windows page")
    public void user_is_on_new_windows_page() {
        windowsPage = new WindowsPage(driver);
        windowsPage.navigate();
        String actualMessage = windowsPage.switchToNewTab().getNewWindowMessage();
        String expectedMessage = "New Window";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @AfterTest
    public void teardown() {
        super.cleanup();
    }

}
