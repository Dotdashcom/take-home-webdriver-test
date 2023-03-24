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

    protected DynamicLoadingPage dynamicLoadingPage;

    protected FileDownloadPage fileDownloadPage;

    protected FileUploadPage fileUploadPage;

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

    @Test(priority = 7)
    public void dynamicLoadingTest() {
        dynamicLoadingPage = landingPage.getPageObject("dynamic_loading/1", DynamicLoadingPage.class);
        dynamicLoadingPage.startDynamicLoading();
        Assert.assertEquals(dynamicLoadingPage.getLoadingTextMessage(), "Hello World!");
    }

    @Test(priority = 8)
    public void fileDownloadTest() {
        fileDownloadPage = landingPage.getPageObject("download", FileDownloadPage.class);
        fileDownloadPage.downloadFile();
        Assert.assertTrue(fileDownloadPage.isFileDownloaded());
    }

    @Test(priority = 9)
    public void fileUploadTests() {
        fileUploadPage = landingPage.getPageObject("upload", FileUploadPage.class);
        fileUploadPage.uploadFile();
        Assert.assertTrue(fileUploadPage.getUploadedFileName().contains("sample.pdf"));
    }
}
