package tests;

import model.FloatingMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class FloatingMenuTest extends BaseTest {

    @Test
    public void testMenuItemsVisibilityScrolledToBottom() {
        boolean actualResult = new FloatingMenuPage(getDriver())
                .getFloatingMenuPage()
                .scrollToBottom()
                .areMenuItemsVisible();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testMenuItemsVisibilityScrolledByIncrements() {
        boolean actualResult = new FloatingMenuPage(getDriver())
                .getFloatingMenuPage()
                .isVisibleWhenScrollingInIncrements();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testMenuItemsVisibilityAtLoading() {
        boolean actualResult = new FloatingMenuPage(getDriver())
                .getFloatingMenuPage()
                .areMenuItemsVisible();

        Assert.assertTrue(actualResult);
    }
}