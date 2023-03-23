package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class DotDashAssignmentTest extends BasePageTest {

    protected CheckBoxPage checkBoxPage;

    protected ContextMenuPage contextMenuPage;

    @Test(priority = 1)
    public void checkBoxTests() {
        checkBoxPage = landingPage.getPageObject("checkboxes", CheckBoxPage.class);
        Assert.assertTrue(checkBoxPage.selectCheckBox(0));
        Assert.assertFalse(checkBoxPage.selectCheckBox(1));
    }

    @Test(priority = 2)
    public void contextMenuTest() {
        contextMenuPage = landingPage.getPageObject("context_menu", ContextMenuPage.class);
        Assert.assertEquals(contextMenuPage.rightClickAndText(), "You selected a context menu");
    }
}
