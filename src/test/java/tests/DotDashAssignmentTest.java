package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class DotDashAssignmentTest extends BasePageTest{

    protected CheckBoxPage checkBoxPage;
    protected ContextMenuPage contextMenuPage;
    protected DragAndDropPage dragAndDropPage;
    protected DropDownPage dropDownPage;
    protected DynamicContentPage dynamicContentPage;
    protected DynamicControlsPage dynamicControlsPage;
    protected DynamicLoadingPage dynamicLoadingPage;
    protected FileDownloadPage fileDownloadPage;
    protected FileUploadPage fileUploadPage;
    protected FloatingMenuPage floatingMenuPage;
    protected IframePage iframePage;
    protected MouseHoverPage mouseHoverPage;
    protected JavaScriptAlertPage javaScriptAlertPage;
    protected JavaScriptErrorPage javaScriptErrorPage;
    protected OpenNewTabPage openNewTabPage;
    protected NotificationMessagePage notificationMessagePage;

    @Test(priority = 0)
    public void isSelectedCheckBoxTest(){
        checkBoxPage = landingPage.getPageObject("checkboxes", CheckBoxPage.class);
        Assert.assertTrue(checkBoxPage.selectCheckBox(0));
    }

    @Test(priority = 1)
    public void isUnselectedCheckBoxTest(){
        checkBoxPage = landingPage.getPageObject("checkboxes", CheckBoxPage.class);
        Assert.assertFalse(checkBoxPage.selectCheckBox(1));
    }

    @Test(priority = 2)
    public void contextMenuTest(){
        contextMenuPage = landingPage.getPageObject("context_menu", ContextMenuPage.class);
        Assert.assertEquals(contextMenuPage.rightClickAndText(), "You selected a context menu");
    }

    @Test(priority = 3)
    public void dragAndDropTest(){
        dragAndDropPage = landingPage.getPageObject("drag_and_drop", DragAndDropPage.class);
        dragAndDropPage.performDragAndDrop();
        Assert.assertEquals(dragAndDropPage.columnAText(), "B");
        Assert.assertEquals(dragAndDropPage.columnBText(), "A");
    }

    @Test(priority = 4)
    public void dropDownTest(){
        dropDownPage = landingPage.getPageObject("dropdown", DropDownPage.class);
        dropDownPage.selectOption("Option 1");
        Assert.assertEquals(dropDownPage.currentSelectedOption(), "Option 1");
        dropDownPage.selectOption("Option 2");
        Assert.assertEquals(dropDownPage.currentSelectedOption(), "Option 2");
    }

    @Test(priority = 5)
    public void dynamicContentTest(){
        dynamicContentPage = landingPage.getPageObject("dynamic_content", DynamicContentPage.class);
        dynamicContentPage.refreshPage();
        Assert.assertFalse(dynamicContentPage.isDynamicContentSame());
    }

    @Test(priority = 6)
    public void dynamicControlTest(){
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
    public void dynamicLoadingTest(){
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
        Assert.assertTrue(fileUploadPage.getUploadedFileName().contains("Upload-Sample.pdf"));
    }

    @Test(priority = 10)
    public void floatingMenuTest(){
        floatingMenuPage = landingPage.getPageObject("floating_menu", FloatingMenuPage.class);
        floatingMenuPage.scrollDownTwoPages();
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());
    }

    @Test(priority = 11)
    public void iFrameTest(){
        iframePage = landingPage.getPageObject("iframe", IframePage.class);
        iframePage.typeInsideIFrame();
        Assert.assertEquals(iframePage.getIframeText(), "Iam inside the iFrame");
    }

    @Test(priority = 12)
    public void mouseHoverTest(){
        mouseHoverPage = landingPage.getPageObject("hovers", MouseHoverPage.class);
        mouseHoverPage.mouseHoverProfile(0);
        Assert.assertTrue(mouseHoverPage.isProfileDisplayed(0));
        mouseHoverPage.mouseHoverProfile(1);
        Assert.assertTrue(mouseHoverPage.isProfileDisplayed(1));
        mouseHoverPage.mouseHoverProfile(2);
        Assert.assertTrue(mouseHoverPage.isProfileDisplayed(2));
    }

    @Test(priority = 13)
    public void javaScriptAlertTest(){
        javaScriptAlertPage = landingPage.getPageObject("javascript_alerts", JavaScriptAlertPage.class);
        javaScriptAlertPage.clickOnAlert();
        Assert.assertEquals(javaScriptAlertPage.getClickOnAlertSuccessMessage(), "You successfuly clicked an alert");
        javaScriptAlertPage.clickJSconfirm();
        Assert.assertEquals(javaScriptAlertPage.getClickOnAlertSuccessMessage(), "You clicked: Ok");
        javaScriptAlertPage.clickJSprompt();
        Assert.assertEquals(javaScriptAlertPage.getClickOnAlertSuccessMessage(),"You entered: Sending keys to alert prompt.");
    }

    @Test(priority = 14)
    public void javaScriptErrorTest(){
        javaScriptErrorPage = landingPage.getPageObject("javascript_error", JavaScriptErrorPage.class);
        Assert.assertTrue(javaScriptErrorPage.javaScriptErrorMessage());
    }

    @Test(priority = 15)
    public void newTabTest(){
        openNewTabPage = landingPage.getPageObject("windows", OpenNewTabPage.class);
        openNewTabPage.openNewTabAndSwitch();
        Assert.assertEquals(openNewTabPage.getNewWindowText(), "New Window");
    }

    @Test(priority = 16)
    public void notificationMessageTest(){
        notificationMessagePage = landingPage.getPageObject("notification_message_rendered", NotificationMessagePage.class);
        Assert.assertTrue(notificationMessagePage.notificationMessage());
    }
}
