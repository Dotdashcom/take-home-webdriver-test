package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends UITests {

    public ContextMenuTest() {
    }

    @Test(description="Expected alert popup opens on right click over box")
    public void alertPopupTriggered() {
        String expectedPopupText = "You selected a context menu";

        ContextMenuPage contextMenuPage = new ContextMenuPage(this.driver, this);
        Assert.assertTrue(contextMenuPage.isPageOpen(), "Page not open");
        contextMenuPage.rightClickBox();
        String actualPopupText = contextMenuPage.getAlertPopupText();
        contextMenuPage.closeAlertPopup();
        Assert.assertEquals(actualPopupText, expectedPopupText);

    }
}
