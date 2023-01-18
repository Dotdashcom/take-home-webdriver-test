package com.qa.take_home_webdriver_test.tests;

import com.github.javafaker.Faker;
import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.listeners.RetryAnalyzer;
import com.qa.take_home_webdriver_test.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TakeHomeWebDriverTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User with valid credentials can log in successfully.")
    public void loginSuccessTest() {
        String userName = prop.getProperty("userName");
        String password = prop.getProperty("password");
        String loginSuccessUrl = prop.getProperty("loginSuccessUrl");
        String successLoginMessageTxt = prop.getProperty("successLoginMsg");

        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        loginSuccessPage.navigateToPage(loginSuccessUrl);
        loginSuccessPage.loginSuccess(userName, password);
        Assert.assertTrue(loginSuccessPage.successLoginMessage(successLoginMessageTxt));
    }

    @Test(priority = 2, groups = {"Smoke"}, description = "User with invalid credentials can't log in successfully.")
    public void loginFailureTest() {
        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        String userName = prop.getProperty("userName").toUpperCase();
        String password = prop.getProperty("password").toLowerCase();
        String loginSuccessUrl = prop.getProperty("loginSuccessUrl");
        String invalidPasswordMessageTxt = prop.getProperty("invalidPassword");

        loginSuccessPage.navigateToPage(loginSuccessUrl);
        loginSuccessPage.loginSuccess(userName, password);
        Assert.assertTrue(loginSuccessPage.invalidPasswordMessage(invalidPasswordMessageTxt));
    }

    @Test(priority = 3, groups = {"Smoke"}, description = "User checks/unchecks checkboxes.")
    public void checkBoxTest() {
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        String checkBoxUrl = prop.getProperty("checkBoxUrl");

        checkBoxesPage.navigateToPage(checkBoxUrl);
        Assert.assertTrue(checkBoxesPage.clickCheckBox1());
        Assert.assertTrue(checkBoxesPage.clickCheckBox2());
    }

    @Test(priority = 4, groups = {"Smoke"}, description = "User performs right-click and handles a javascript alert.")
    public void contextMenuTest() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        String contextMenuUrl = prop.getProperty("contextMenuUrl");

        contextMenuPage.navigateToPage(contextMenuUrl);
        contextMenuPage.performRightClick();
        String expAlertJSMessage = prop.getProperty("alertJSMessage");
        String actAlertJSMessage = contextMenuPage.handleJSAlert();
        Assert.assertEquals(expAlertJSMessage, actAlertJSMessage);

    }

    @Test(priority = 5, groups = {"Smoke"}, description = "User does drag and drop boxes .")
    public void dragAndDropTest() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        String dragAndDropUrl = prop.getProperty("dragAndDropUrl");
        String boxA_Txt = prop.getProperty("boxA_Txt");
        String boxB_Txt = prop.getProperty("boxB_Txt");

        dragAndDropPage.navigateToPage(dragAndDropUrl);
        dragAndDropPage.doDragAndDrop();
        Assert.assertTrue(dragAndDropPage.validateDragAndDrop(boxA_Txt, boxB_Txt));
    }

    @Test(priority = 6, groups = {"Smoke"}, description = "User selects options from drop down menu .")
    public void dropDownTest() {
        DropDownPage dropDownPage = new DropDownPage(driver);
        String dropDownUrl = prop.getProperty("dropDownUrl");
        String option1 = prop.getProperty("option1");
        String option2 = prop.getProperty("option2");

        dropDownPage.navigateToPage(dropDownUrl);
        dropDownPage.doDropDownSelect(option1);
        Assert.assertTrue(dropDownPage.getDropDownSelectedTxt(option1));

        dropDownPage.doDropDownSelect(option2);
        Assert.assertTrue(dropDownPage.getDropDownSelectedTxt(option2));
    }

    @Test(priority = 7, groups = {"Smoke"}, description = "User handles dynamic content. ", retryAnalyzer = RetryAnalyzer.class)
    public void dynamicContentTest() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        String dynamicContentUrl = prop.getProperty("dynamicContentUrl");
        dynamicContentPage.navigateToPage(dynamicContentUrl);

        List<String> imageListBeforeRefreshPage = dynamicContentPage.imagesList();
        List<String> contentListBeforeRefreshPage = dynamicContentPage.contentList();
        dynamicContentPage.refreshPage();

        List<String> imageListAfterRefreshPage = dynamicContentPage.imagesList();
        List<String> contentListAfterRefreshPage = dynamicContentPage.contentList();

        Assert.assertNotEquals(imageListBeforeRefreshPage, imageListAfterRefreshPage);
        Assert.assertNotEquals(contentListBeforeRefreshPage, contentListAfterRefreshPage);
    }

    @Test(priority = 8, groups = {"Smoke"}, description = "User handles dynamic controls. ")
    public void dynamicControlsTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        String dynamicControlsUrl = prop.getProperty("dynamicControlsUrl");
        String removeMsg = prop.getProperty("removeMsg");
        String addMsg = prop.getProperty("addMsg");
        String enabled = prop.getProperty("enabled");
        String disabled = prop.getProperty("disabled");

        dynamicControlsPage.navigateToPage(dynamicControlsUrl);
        dynamicControlsPage.doClickCheckBox();
        dynamicControlsPage.doRemoveAddCheckBox();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(removeMsg));

        dynamicControlsPage.doRemoveAddCheckBox();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(addMsg));

        dynamicControlsPage.doClickOnEnableDisable();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(enabled));

        dynamicControlsPage.doClickOnEnableDisable();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(disabled));
    }

    @Test(priority = 9, groups = {"Smoke"}, description = "User handles dynamic loading page .")
    public void dynamicLoadingTest() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        String dynamicLoadingUrl = prop.getProperty("dynamicLoadingUrl");
        String helloHeaderTxt = prop.getProperty("helloHeaderTxt");

        dynamicLoadingPage.navigateToPage(dynamicLoadingUrl);
        dynamicLoadingPage.doClickStartBtn();
        Assert.assertTrue(dynamicLoadingPage.isHelloHeaderDisplayed(helloHeaderTxt));
    }

    @Test(priority = 10, groups = {"Smoke"}, description = "User downloads the txt file. ")
    public void fileDownloadTest() throws InterruptedException {
        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
        String fileDownloadUrl = prop.getProperty("fileDownloadUrl");
        String fileName = prop.getProperty("fileName");

        fileDownloadPage.navigateToPage(fileDownloadUrl);
        fileDownloadPage.fileDownload(fileName);
        Assert.assertTrue(fileDownloadPage.isFileDownloaded(fileName));
    }

    @Test(priority = 11, groups = {"Smoke"}, description = "User uploads the txt file. ")
    public void fileUploadTest() {
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        String fileUploadUrl = prop.getProperty("fileUploadUrl");
        String uploadMsg = prop.getProperty("uploadMsg");

        fileUploadPage.navigateToPage(fileUploadUrl);
        fileUploadPage.fileUpload();
        Assert.assertTrue(fileUploadPage.isUploadedMsgDisplayed(uploadMsg));
    }

    @Test(priority = 12, groups = {"Smoke"}, description = "User handles floating menu. ")
    public void floatingMenuTest() {
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        String floatingMenuUrl = prop.getProperty("floatingMenuUrl");

        floatingMenuPage.navigateToPage(floatingMenuUrl);
        floatingMenuPage.scrollDownPage();
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());

        floatingMenuPage.scrollUpPage();
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());
    }

    @Test(priority = 13, groups = {"Smoke"}, description = "User handles iframe web element. ")
    public void iframeTest() {
        IframePage iframePage = new IframePage(driver);
        Faker faker = new Faker();
        String iFrameUrl = prop.getProperty("iFrameUrl");
        String existingTxt = prop.getProperty("existingTxt");
        String proposalTxt = faker.country().name();

        iframePage.navigateToPage(iFrameUrl);
        iframePage.closeAlert();
        iframePage.switchToFrame();
        iframePage.sendTxt(existingTxt, proposalTxt);
        Assert.assertEquals(iframePage.getInputBoxTxt(), proposalTxt);
    }

    @Test(priority = 14, groups = {"Smoke"}, description = "User handles mouse hover. ")
    public void mouseHoverTest() {
        MouseHoverPage mouseHoverPage = new MouseHoverPage(driver);
        String mouseHoverUrl = prop.getProperty("mouseHoverUrl");

        mouseHoverPage.navigateToPage(mouseHoverUrl);
        Assert.assertTrue(mouseHoverPage.areFiguresDisplayed());
    }

    @Test(priority = 15, groups = {"Smoke"}, description = "User handles JavaScript alerts. ")
    public void javaScriptAlertsTest() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        Faker faker = new Faker();
        String javaScriptAlertsUrl = prop.getProperty("javaScriptAlertsUrl");

        String jsAlertInside = prop.getProperty("jsAlertInsideMsg");
        String jsAlert = prop.getProperty("jsAlert");
        String jsConfirmInside = prop.getProperty("jsConfirmInsideMsg");
        String jsConfirm = prop.getProperty("jsConfirm");
        String JsPromptSendTxt = faker.company().name();
        String jsPromptInsideMsg = prop.getProperty("jsPrompt") + " " + JsPromptSendTxt;

        javaScriptAlertsPage.navigateToPage(javaScriptAlertsUrl);
        javaScriptAlertsPage.clickJSAlert();
        Assert.assertTrue(javaScriptAlertsPage.jsMessage(jsAlertInside) && javaScriptAlertsPage.getAlertMessage(jsAlert));

        javaScriptAlertsPage.clickJSJsConfirm();
        Assert.assertTrue(javaScriptAlertsPage.jsMessage(jsConfirmInside) && javaScriptAlertsPage.getAlertMessage(jsConfirm));

        javaScriptAlertsPage.clickJSPrompt();
        javaScriptAlertsPage.jsPromptSendText(JsPromptSendTxt);
        Assert.assertTrue(javaScriptAlertsPage.getAlertMessage(jsPromptInsideMsg));
    }

    @Test(priority = 16, groups = {"Smoke"}, description = "User handles JavaScript error. ")
    public void javaScriptErrorTest() {
        JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage(driver);
        String javaScriptErrorUrl = prop.getProperty("javaScriptErrorUrl");
        String errorMsg = prop.getProperty("errorMsg");

        javaScriptErrorPage.navigateToPage(javaScriptErrorUrl);
        Assert.assertTrue(javaScriptErrorPage.checkForErrorInLogs(errorMsg));
    }

    @Test(priority = 17, groups = {"Smoke"}, description = "User handles opening a new tab. ")
    public void openNewTabTest() {
        OpenNewTabPage openNewTabPage = new OpenNewTabPage(driver);
        String openNewTabUrl = prop.getProperty("openNewTabUrl");
        String pageTitle = prop.getProperty("pageTitle");

        openNewTabPage.navigateToPage(openNewTabUrl);
        openNewTabPage.clickOnTheLink();
        Assert.assertTrue(openNewTabPage.openNewTab(pageTitle));
    }

    @Test(priority = 18, groups = {"Smoke"}, description = "User handles notification messages. ")
    public void notificationMessageTest() {
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
        String notificationMessageUrl = prop.getProperty("notificationMessageUrl");
        String msg1 = prop.getProperty("msg1");
        String msg2 = prop.getProperty("msg2");
        String msg3 = prop.getProperty("msg3");
        String[] messagesList = {msg1, msg2, msg3};
        int times = Integer.parseInt(prop.getProperty("times"));

        notificationMessagePage.navigateToPage(notificationMessageUrl);
        notificationMessagePage.clickOnTheLink();
        Assert.assertTrue(notificationMessagePage.someMsgDisplayed(messagesList, times));
    }
}
