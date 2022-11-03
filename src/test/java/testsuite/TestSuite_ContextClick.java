package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ContextMenuPage;

public class TestSuite_ContextClick extends BaseTestClass {

    @Test(description = "Context Menu")
    public void TC_ContextClick_001_ValidateFunctionality_ContextClick() {
        ActionHelper.openUrl(Constants.CONTEXT_MENU_PAGE_URL);
        ContextMenuPage contextMenuPage = ContextMenuPage.getInstance();
        contextMenuPage.rightClickContextMenu();
        Assert.assertEquals(ActionHelper.getAlertText(), "You selected a context menu", "Validate Alert Text");
    }
}
