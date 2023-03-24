package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class DotDashAssignmentTest extends BasePageTest {

    protected CheckBoxPage checkBoxPage;

    protected ContextMenuPage contextMenuPage;

    protected DragAndDropPage dragAndDropPage;

    protected DropDownPage dropDownPage;

    protected DynamicContentPage dynamicContentPage;

    protected DynamicControlsPage dynamicControlsPage;

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

    @Test(priority = 3)
    public void dragAndDropTest() {
        dragAndDropPage = landingPage.getPageObject("drag_and_drop", DragAndDropPage.class);
        dragAndDropPage.performDragAndDrop();
        Assert.assertEquals(dragAndDropPage.columnAText(), "B");
        Assert.assertEquals(dragAndDropPage.columnBText(), "A");
    }

    @Test(priority = 4)
    public void dropDownTest() {
        dropDownPage = landingPage.getPageObject("dropdown", DropDownPage.class);
        dropDownPage.selectOption("Option 1");
        Assert.assertEquals(dropDownPage.currentSelectedOption(), "Option 1");
        dropDownPage.selectOption("Option 2");
        Assert.assertEquals(dropDownPage.currentSelectedOption(), "Option 2");
    }

    @Test(priority = 5)
    public void dynamicContentTest() {
        dynamicContentPage = landingPage.getPageObject("dynamic_content", DynamicContentPage.class);
        dynamicContentPage.refreshPage();
        Assert.assertFalse(dynamicContentPage.isDynamicContentSame());
    }

    @Test(priority = 6)
    public void dynamicControlTest() {
        dynamicControlsPage = landingPage.getPageObject("dynamic_controls", DynamicControlsPage.class);
        SoftAssert softAssert = new SoftAssert();
        dynamicControlsPage.removeCheckBox();
        softAssert.assertEquals(dynamicControlsPage.getMessage(), "It's gone!");
        softAssert.assertTrue(dynamicControlsPage.addCheckBox());
        softAssert.assertEquals(dynamicControlsPage.getMessage(), "It's back!");
        softAssert.assertTrue(dynamicControlsPage.enableButtonClick());
        softAssert.assertEquals(dynamicControlsPage.getMessage(), "It's enabled!");
        softAssert.assertFalse(dynamicControlsPage.disableButtonClick());
        softAssert.assertEquals(dynamicControlsPage.getMessage(), "It's disabled!");
    }
}
