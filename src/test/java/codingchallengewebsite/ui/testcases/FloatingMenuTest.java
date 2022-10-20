package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.FloatingMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuTest extends UITests {

    public FloatingMenuTest() {
    }

    @Test(description = "Scrolls down the page and the menu is still there")
    public void scrollTest() {
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(this.driver, this);
        Assert.assertTrue(floatingMenuPage.isPageOpen(), "Page not open");

        String initialPosition = floatingMenuPage.getMenuPosition();
        floatingMenuPage.scrollToBottom();
        String finalPosition = floatingMenuPage.getMenuPosition();

        Assert.assertNotEquals(initialPosition, finalPosition, "Menu position didn't change");
        Assert.assertTrue(floatingMenuPage.validateMenuVisibility(), "Menu not showing");
    }
}
