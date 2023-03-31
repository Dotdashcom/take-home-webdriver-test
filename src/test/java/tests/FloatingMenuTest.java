package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FloatingMenu;

public class FloatingMenuTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/floating_menu");
        FloatingMenu scroll = new FloatingMenu(driver);
        scroll.scroll(driver);
        Assert.assertTrue(scroll.isMenuDisplayed());
    }
}
