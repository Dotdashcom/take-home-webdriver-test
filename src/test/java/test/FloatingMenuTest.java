package test;

import methods.FloatingMenuMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FloatingMenuTest extends FloatingMenuMethod {
    @Test
    public void floatingMenuTest() {
        startFloatingMenuTest();
        assertTrue(isMenuDisplayed(), "menu is not displayed");
    }
}
