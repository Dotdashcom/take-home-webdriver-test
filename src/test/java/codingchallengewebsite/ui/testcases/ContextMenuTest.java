package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends UITest {

    public ContextMenuTest() { }

    @Test(description="Expected alert popup opens on right click over box")
    public void triggerPopupOnContextClick() {
        String expectedPopupText = "You selected a context menu";
        ContextMenuPage contextMenuPage = new ContextMenuPage(this);

        // Validate page loaded
        Assert.assertTrue(contextMenuPage.isPageOpen(), "Page not open");

        // Validate popup opens
        contextMenuPage.rightClickBox();
        String actualPopupText = contextMenuPage.getAlertPopupText();
        contextMenuPage.closeAlertPopup();
        Assert.assertEquals(actualPopupText, expectedPopupText);
    }
}