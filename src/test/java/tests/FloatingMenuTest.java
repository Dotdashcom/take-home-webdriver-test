package tests;

import org.testng.annotations.Test;
import pages.FloatingMenuPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class FloatingMenuTest extends BaseTest{
    @Test
    public void verifyFloatingMenu() {
        HomePage homePage = new HomePage(driver);
        FloatingMenuPage floatingMenu = homePage.clickFloatMenu();
        assertTrue(floatingMenu.checkFloatingMenuExists());
    }
}
