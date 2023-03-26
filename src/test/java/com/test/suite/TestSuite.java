package com.test.suite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import com.test.tests.CheckboxesTest;
import com.test.tests.ContextMenuTest;
import com.test.tests.DragAndDropTest;
import com.test.tests.DropdownTest;
import com.test.tests.DynamicContentTest;
import com.test.tests.DynamicControlsTest;
import com.test.tests.DynamicLoadingTest;
import com.test.tests.FileDownloadTest;
import com.test.tests.FileUploadTest;
import com.test.tests.FloatingMenuTest;
import com.test.tests.IframeTest;
import com.test.tests.JavaScriptAlertsTest;
import com.test.tests.LoginFailureTest;
import com.test.tests.LoginSuccessTest;
import com.test.tests.JavaScriptErrorTest;
import com.test.tests.MouseHoverTest;
import com.test.tests.NotificationMessageTest;
import com.test.tests.OpenInNewTabTest;

@TestMethodOrder(OrderAnnotation.class)
@Tag("Suite")
@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Test Suite")
public class TestSuite {

    @Test
    @DisplayName("Checkboxes Test")
    @Tag("Checkbox")
    public void checkboxesTest(TestInfo testInfo, TestReporter testReporter) {
        CheckboxesTest checkboxesTest = new CheckboxesTest();
        checkboxesTest.setUp();
        checkboxesTest.testCheckboxes();
    }

    @Test
    @DisplayName("Login Failure Test")
    @Tag("Login")
    public void loginFailureTest(TestInfo testInfo, TestReporter testReporter) {
        LoginFailureTest loginFailureTest = new LoginFailureTest();
        loginFailureTest.setUp();
        loginFailureTest.testLoginFailure();
    }

    @Test
    @DisplayName("Login Success Test")
    @Tag("Login")
    public void loginSuccessTest(TestInfo testInfo, TestReporter testReporter) {
        LoginSuccessTest loginSuccessTest = new LoginSuccessTest();
        loginSuccessTest.setUp();
        loginSuccessTest.testLogin();
    }

    @Test
    @DisplayName("Context Menu Test")
    @Tag("ContextMenu")
    public void contextMenuTest(TestInfo testInfo, TestReporter testReporter) {
        ContextMenuTest contextMenuTest = new ContextMenuTest();
        contextMenuTest.setUp();
        contextMenuTest.testContextMenu();
    }

    @Test
    @DisplayName("Drag And Drop Test")
    @Tag("DragAndDrop")
    public void dragAndDropTest(TestInfo testInfo, TestReporter testReporter) {
        DragAndDropTest dragAndDropTest = new DragAndDropTest();
        dragAndDropTest.setUp();
        dragAndDropTest.testDragAndDrop();
    }

    @Test
    @DisplayName("Dropdown Test")
    @Tag("Dropdown")
    public void dropdownTest(TestInfo testInfo, TestReporter testReporter) {
        DropdownTest dropdownTest = new DropdownTest();
        dropdownTest.setUp();
        dropdownTest.testDropdown();
    }

    @Test
    @DisplayName("Dynamic Content Test")
    @Tag("DynamicContent")
    public void dynamicContentTest(TestInfo testInfo, TestReporter testReporter) {
        DynamicContentTest dynamicContentTest = new DynamicContentTest();
        dynamicContentTest.setUp();
        dynamicContentTest.testDynamicContent();
    }
    
    @Test
    @DisplayName("Dynamic Controls Test")
    @Tag("DynamicControls")
    public void dynamicControlsTest(TestInfo testInfo, TestReporter testReporter) {
        DynamicControlsTest dynamicControlsTest = new DynamicControlsTest();
        dynamicControlsTest.setUp();
        dynamicControlsTest.testRemoveAdd();
    }

    @Test
    @DisplayName("Dynamic Loading Test")
    @Tag("DynamicLoading")
    public void dynamicLoadingTest(TestInfo testInfo, TestReporter testReporter) {
        DynamicLoadingTest dynamicLoadingTest = new DynamicLoadingTest();
        dynamicLoadingTest.setUp();
        dynamicLoadingTest.testDynamicLoading();
    }

    @Test
    @DisplayName("File Download Test")
    @Tag("FileDownload")
    public void fileDownloadTest(TestInfo testInfo, TestReporter testReporter) {
        FileDownloadTest fileDownloadTest = new FileDownloadTest();
        fileDownloadTest.setUp();
        fileDownloadTest.testFileDownload();
    }

    @Test
    @DisplayName("File Upload Test")
    @Tag("FileUpload")
    public void fileUploadTest(TestInfo testInfo, TestReporter testReporter) {
        FileUploadTest fileUploadTest = new FileUploadTest();
        fileUploadTest.setUp();
        fileUploadTest.testFileUpload();
    }

    @Test
    @DisplayName("Floating Menu Test")
    @Tag("FloatingMenu")
    public void floatingMenuTest(TestInfo testInfo, TestReporter testReporter) {
        FloatingMenuTest floatingMenuTest = new FloatingMenuTest();
        floatingMenuTest.setUp();
        floatingMenuTest.testFloatingMenu();
    }

    @Test
    @DisplayName("Iframe Test")
    @Tag("Iframe")
    public void iframeTest(TestInfo testInfo, TestReporter testReporter) {
        IframeTest iframeTest = new IframeTest();
        iframeTest.setUp();
        iframeTest.testIframe();
    }

    @Test
    @DisplayName("JavaScript Alerts Test")
    @Tag("JavaScriptAlerts")
    public void javaScriptAlertsTest(TestInfo testInfo, TestReporter testReporter) {
        JavaScriptAlertsTest javaScriptAlertsTest = new JavaScriptAlertsTest();
        javaScriptAlertsTest.setUp();
        javaScriptAlertsTest.testJSAlert();
        javaScriptAlertsTest.testJSConfirm();
        javaScriptAlertsTest.testJSPrompt();
    }
    
    @Test
    @DisplayName("JavaScript Error Test")
    @Tag("JavaScriptError")
    public void javaScriptErrorTest(TestInfo testInfo, TestReporter testReporter) {
        JavaScriptErrorTest javaScriptErrorTest = new JavaScriptErrorTest();
        javaScriptErrorTest.setUp();
        javaScriptErrorTest.testJavaScriptError();
    }

    @Test
    @DisplayName("Mouse Hover Test")
    @Tag("MouseHover")
    public void mouseHoverTest(TestInfo testInfo, TestReporter testReporter) {
        MouseHoverTest mouseHoverTest = new MouseHoverTest();
        mouseHoverTest.setUp();
        mouseHoverTest.testMouseHover();
    }

    @Test
    @DisplayName("Notification Message Test")
    @Tag("NotificationMessage")
    public void notificationMessageTest(TestInfo testInfo, TestReporter testReporter) {
        NotificationMessageTest notificationMessageTest = new NotificationMessageTest();
        notificationMessageTest.setUp();
        notificationMessageTest.testNotificationMessage();
    }

    @Test
    @DisplayName("Open In New Tab Test")
    @Tag("OpenInNewTab")
    public void openInNewTabTest(TestInfo testInfo, TestReporter testReporter) {
        OpenInNewTabTest openInNewTabTest = new OpenInNewTabTest();
        openInNewTabTest.setUp();
        openInNewTabTest.testOpenInNewTab();
    }
}