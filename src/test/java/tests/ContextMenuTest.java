package tests;

import org.testng.annotations.Test;
import pages.ContextMenuPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class ContextMenuTest extends BaseTest{
    @Test
    public void verifyContextClick() {
        HomePage homepage = new HomePage(driver);
        ContextMenuPage contextMenuPage = homepage.clickContextMenu();
        contextMenuPage.clickOnContextMenu();
        assertTrue(contextMenuPage.getAlertMenuText().contains("You selected a context menu"));
    }
}
