package scripts;

import org.junit.Assert;
import org.junit.Test;
import pages.*;
import utilities.BrowserUtils;

import java.io.IOException;
import java.util.List;;

public class TestPage
    extends  BasePage{
        LoginPage logInSuccess = new LoginPage();
        CheckboxPage checkboxesPage = new CheckboxPage();
        ContextMenuPage contextMenuPage = new ContextMenuPage();
        DragAndDropPage dragAndDropPage = new DragAndDropPage();
        DropdownPage dropdownPage = new DropdownPage();
        DynamicContentPage dynamicContentPage = new DynamicContentPage();
        DynamicControlsPage dynamicControlsPages = new DynamicControlsPage();
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        FileDownloadPage fileDownloadPage = new FileDownloadPage();
        FileUploadPage fileUploadPage = new FileUploadPage();
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage();
        iFramePage iframePage = new iFramePage();
        MouseHoverPage mouseHoverPage = new MouseHoverPage();
        JavascriptAlertsPage javaScriptAlertsPage = new JavascriptAlertsPage();
        JavascriptErrorPage javaScriptErrorPage = new JavascriptErrorPage();
       MultipleWindowsPage openInNewTabPage = new MultipleWindowsPage();
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage();

    @Test
    public void LoginSuccess() {
        logInSuccess.LogIn();
    }

    @Test
    public void LoginSuccessWrongCredentials() {
        logInSuccess.LogIn("BlaBla", "LaLA");

    }

    @Test
    public void Checkboxes() {
        checkboxesPage.logInCheckboxPage();
        checkboxesPage.verifyCheckBoxes();
    }

    @Test
    public void ContextMenu() {
        contextMenuPage.getConnection("ContextMenu");
        contextMenuPage.clickOnWindow();
        contextMenuPage.getText();
    }

    @Test
    public void DragAndDrop() {
        dragAndDropPage.getConnection("DragAndDrop");
        dragAndDropPage.dragAndDrop();
        Assert.assertTrue(dragAndDropPage.elementsLocationsDifference() > 0);

    }

    @Test
    public void Dropdown() {
        dropdownPage.getConnection("Dropdown");
        dropdownPage.setSelectOptions();
    }

    @Test
    public void DynamicContent() {
        dynamicContentPage.getConnection("DynamicContent");
        List<String> firstListOfMessages = dynamicContentPage.getMessagesText();
        BrowserUtils.refreshPage();
        List<String> secondListOfMessages = dynamicContentPage.getMessagesText();
        Assert.assertNotEquals(firstListOfMessages, secondListOfMessages);

    }

    @Test
    public void DynamicControls() {
        dynamicControlsPages.getConnection("DynamicControls");
        dynamicControlsPages.checkBoxChecking();
        dynamicControlsPages.checkEnabledButton();

    }

    @Test
    public void DynamicLoading() {
        dynamicLoadingPage.getConnection("DynamicLoading");
        dynamicLoadingPage.checkLoadingFunctionality();

    }

    @Test
    public void FileDownload() throws IOException {
        fileDownloadPage.getConnection("FileDownload");
        fileDownloadPage.downloadFile();
        int fileName = BrowserUtils.getFileName("some-file.txt");
        Assert.assertEquals(1, fileName);

    }

    @Test
    public void FileUpload() {
        fileUploadPage.getConnection("FileUpload");
        fileUploadPage.uploadFile();

    }

    @Test
    public void FloatingMenu() {
        floatingMenuPage.getConnection("FloatingMenu");
        floatingMenuPage.scrollAndCheck();

    }

    @Test
    public void Iframe(){
        iframePage.getConnection("Iframe");
        iframePage.checkFrame();
    }
    @Test
    public void MouseHover(){
        mouseHoverPage.getConnection("MouseHover");
        mouseHoverPage.hoverOver();

    }

    @Test
    public void JavaScriptAlerts(){
        javaScriptAlertsPage.getConnection("JavaScriptAlerts");
        javaScriptAlertsPage.clickAlert();
        javaScriptAlertsPage.clickToConfirm();
        javaScriptAlertsPage.clickPrompt();

    }

    @Test
    public void JavaScriptError(){
        javaScriptErrorPage.getConnection("JavaScriptError");

    }

    @Test
    public void OpenInNewTab(){
        openInNewTabPage.getConnection("OpenInNewTab");
        openInNewTabPage.checkNewWindow();

    }
    @Test
    public void NotificationMessage(){
        notificationMessagePage.getConnection("NotificationMessage");
        notificationMessagePage.click();

    }
}
