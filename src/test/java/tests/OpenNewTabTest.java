package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OpenNewTab;

public class OpenNewTabTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/windows");
        OpenNewTab tab = new OpenNewTab(driver);
        Assert.assertEquals(tab.newWindow(driver), "New Window");
    }

}
