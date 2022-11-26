package com.framework.testcases;
import com.framework.pages.ContextMenuPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenuTest extends TestBase {
    ContextMenuPage contextMenuPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }


    @Test(priority = 1, description = "User is on the context menu page")
    public void user_is_on_context_menu_page() {
        contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.navigate();
        String actualURL = contextMenuPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/context_menu";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "Alert is displayed upon right clicking on hotspot")
    public void user_can_right_click_and_alert_displayed() {
        contextMenuPage = new ContextMenuPage(driver);
        String actualAlertMessage = contextMenuPage.navigate().rightClickHotSpotBox().getAlertMessage();
        String expectedAlertMessage = "You selected a context menu";
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
    }
	
    @AfterTest
    public void teardown() {
        super.cleanup();
    }
}
