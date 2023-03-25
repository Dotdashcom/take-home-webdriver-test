package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTest extends TestConfiguration {
    @Test
    @Parameters({"baseUrl", "contextMenuUrl","contextMenuMessage"})
    public void contextMenu_Test(String baseUrl, String contextMenuUrl, String contextMenuMessage) {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.goToUrl(baseUrl , contextMenuUrl);

        contextMenuPage.rightClickOnContextMenu();
        Assert.assertTrue(contextMenuPage.getAlertText().equals(contextMenuMessage));
    }
}
