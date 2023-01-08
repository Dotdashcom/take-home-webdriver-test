package tests;

import model.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class ContextMenuTest extends BaseTest {

    @Test
    public void testJSAlertIsDisplayed() {
        boolean actualResult = new ContextMenuPage(getDriver())
                .getContextMenuPage()
                .rightClickContextMenuArea()
                .isAlertPresent();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testContextMenuAlertText() {
        String expectedAlertMessageText = "You selected a context menu";

        String actualMessageText = new ContextMenuPage(getDriver())
                .getContextMenuPage()
                .rightClickContextMenuArea()
                .getAlertMessageText();

        Assert.assertEquals(actualMessageText, expectedAlertMessageText);
    }

    @Test
    public void testContextMenuAlertAccept() {
        boolean actualResult = new ContextMenuPage(getDriver())
                .getContextMenuPage()
                .rightClickContextMenuArea()
                .clickOkAlertMessage()
                .isHeaderDisplayed();

        Assert.assertTrue(actualResult);
    }
}