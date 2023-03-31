package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenu;

public class ContextMenuTest extends TestBase {
    @Test
    public void test1() {
        driver.get("http://localhost:7080/context_menu");
        ContextMenu contextTest = new ContextMenu(driver);
        contextTest.rightClick(driver);
        Assert.assertEquals("You selected a context menu", contextTest.getAlertMessage(driver));
        contextTest.alertClick(driver);
    }
}
