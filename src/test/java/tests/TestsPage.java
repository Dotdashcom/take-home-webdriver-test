package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.*;
import utilities.BrowserUtils;

import java.io.IOException;
import java.util.List;

public class TestsPage extends AbstractTestBase {
    LoginSuccessPage logInSuccess = new LoginSuccessPage();
    CheckboxesPage checkboxesPage = new CheckboxesPage();
    ContextMenuPage contextMenuPage=new ContextMenuPage();
    DragAndDropPage dragAndDropPage = new DragAndDropPage();
    DropdownPage dropdownPage = new DropdownPage();
    DynamicContentPage dynamicContentPage = new DynamicContentPage();
    DynamicControlsPages dynamicControlsPages = new DynamicControlsPages();
    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
    FileDownloadPage fileDownloadPage = new FileDownloadPage();
    FileUploadPage fileUploadPage = new FileUploadPage();


    @Test
    public void LoginSuccess() {
        logInSuccess.LogIn();
    }

    @Test
    public void LoginSuccessWrongCredentials() {
        logInSuccess.LogIn("BlaBla", "LaLA");

    }
    @Test
    public void Checkboxes(){
        checkboxesPage.logInCheckboxPage();
        checkboxesPage.verifyCheckBoxes();
    }

    @Test
    public void ContextMenu(){
        contextMenuPage.getConnection("ContextMenu");
        contextMenuPage.clickOnWindow();
        contextMenuPage.getText();
    }

    @Test
    public void DragAndDrop(){
        dragAndDropPage.getConnection("DragAndDrop");
        dragAndDropPage.dragAndDrop();
        Assert.assertTrue(dragAndDropPage.elementsLocationsDifference()>0);

    }

    @Test
    public void Dropdown(){
        dropdownPage.getConnection("Dropdown");
        dropdownPage.setSelectOptions();
    }
    @Test
    public void DynamicContent(){
        dynamicContentPage.getConnection("DynamicContent");
        List<String> firstListOfMessages = dynamicContentPage.getMessagesText();
        BrowserUtils.refreshPage();
        List<String> secondListOfMessages = dynamicContentPage.getMessagesText();
        Assert.assertNotEquals(firstListOfMessages,secondListOfMessages);

    }

    @Test
    public void DynamicControls(){
        dynamicControlsPages.getConnection("DynamicControls");
        dynamicControlsPages.checkBoxChecking();
        dynamicControlsPages.checkEnabledButton();

    }

    @Test
    public void DynamicLoading(){
        dynamicLoadingPage.getConnection("DynamicLoading");
        dynamicLoadingPage.checkLoadingFunctionality();

    }

    @Test
    public void FileDownload() throws IOException {
        fileDownloadPage.getConnection("FileDownload");
        fileDownloadPage.downloadFile();
        int fileName =BrowserUtils.getFileName("some-file.txt");
        Assert.assertEquals(1, fileName);

    }

    @Test
    public void FileUpload(){
        fileUploadPage.getConnection("FileUpload");
        fileUploadPage.uploadFile();


    }
}
