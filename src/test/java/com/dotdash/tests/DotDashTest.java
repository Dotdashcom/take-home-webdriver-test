package com.dotdash.tests;

import com.dotdash.BaseAPI;
import org.testng.annotations.*;

import static com.dotdash.DotDashCheckboxes.*;
import static com.dotdash.DotDashContextMenu.*;
import static com.dotdash.DotDashDownloadFile.*;
import static com.dotdash.DotDashDragAndDrop.*;
import static com.dotdash.DotDashDynamicContent.*;
import static com.dotdash.DotDashDynamicControls.*;
import static com.dotdash.DotDashDynamicLoading.*;
import static com.dotdash.DotDashFloatingMenu.*;
import static com.dotdash.DotDashHomeLogIn.*;
import static com.dotdash.DotDashDropDown.*;
import static com.dotdash.DotDashIFrame.*;
import static com.dotdash.DotDashJavaScriptAlerts.*;
import static com.dotdash.DotDashJavaScriptErrors.*;
import static com.dotdash.DotDashMouseHover.*;
import static com.dotdash.DotDashNotificationMessage.*;
import static com.dotdash.DotDashUpload.*;
import static com.dotdash.DotDashWindows.*;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashTest extends BaseAPI {

    /**
     * Test Case 1:
     * Verify LogIn functionality using VALID UserName and Password
     */
    @Test(enabled = true, priority = 1)
    public void testLogInValid() {
        logInValid();
        assertURLContains("secure");
    }

    /**
     * Test Case 2:
     * Verify LogIn functionality using INVALID UserName and Password
     */
    @Test(enabled = true, priority = 2)
    public void testLogInInvalid() {
        logInInvalid();
        verifyInvalidLogIn();
    }

    /**
     * Test Case 3:
     * Verify CheckBoxes function properly
     */
    @Test(enabled = true, priority = 3)
    public void testCheckboxes() {
        navigateToCheckboxesPage();
        clickCheckBox1();
        clickCheckBox2();
    }

    /**
     * Test Case 4:
     * Test Notification Message is displayed as expected
     */
    @Test(enabled = true, priority = 4)
    public void testNotificationMessage() {
        navigateToNotficationMesagePage();
        triggerNotification();
        assertNotificationMessageIsDisplayed();
    }

    /**
     * Test Case 5:
     * Verify Drag and Drop functionality
     */
    @Test(enabled = true, priority = 5)
    public void testDragAndDrop() {
        navigateToDragNDrop();
        dragPointAToB();
    }

    /**
     * Test Case 6:
     * Verify Dropdown Menu is working as expected
     */
    @Test(enabled = true, priority = 6)
    public void testDropDownMenu() {
        navigateToDropDownPage();
        selectFromMenu("1");
        selectFromMenu("2");
    }

    /**
     * Test Case 7:
     * Verify New Content is loaded properly after the Page is refreshed
     */
    @Test(enabled = true, priority = 7)
    public void testDynamicContent() {
        navigateToDynamicContentPage();
        assertContentRefresh();
    }

    /**
     * Test Case 8:
     * Verify Dynamic Controls are working as expected
     */
    @Test(enabled = true, priority = 8)
    public void testDynamicControls() {
        navigateToDynamicControls();
        assertRemoveControl();
        assertTextBoxEnabled();
    }

    /**
     * Test Case 9:
     * Verify Dynamic Loading Page is working as expected
     */
    @Test(enabled = true, priority = 9)
    public void testDynamicLoadingPage() {
        navigateToDynamicLoading();
        clickStartButton();
        waitHelloWorldToBeDisplayed();
        assertPageLoadedSuccessfully();
    }

    /**
     * Test Case 10:
     * Verify Downloading Page is working as expected
     */
    @Test(enabled = true, priority = 10)
    public void testFileDownload() {
        navigateToDownloadPage();
        downloadFile();
        assertFileDownloaded();
    }

    /**
     * Test Case 11:
     * Verify Floating Menu is working as expected
     */
    @Test(enabled = true, priority = 11)
    public void testFloatingMenu() {
        navigateToFloatingMenuPage();
        scrollDownPage();
        clickNewsMenuButton();
        assertNewsMenuButton();
        clickContactMenuButton();
        assertContactMenuButton();
        clickAboutMenuButton();
        assertAboutMenuButton();
        clickHomeMenuButton();
        assertHomeMenuButton();
    }

    /**
     * Test Case 12:
     * Test iFrame Text Box
     */
    @Test(enabled = true, priority = 12)
    public void testIFrameSwitch() {
        navigateToIFramePage();
        switchToTinyMCEIFrame();
        enterText();
        switchToParent();
    }

    /**
     * Test Case 13:
     * Test Mouse Hover Page
     */
    @Test(enabled = true, priority = 13)
    public void testMouseHover() {
        navigateToMouseHoverPage();
        hoverOverUser1();
        assertUser1InfoDisplayed();
        hoverOverUser2();
        assertUser2InfoDisplayed();
        hoverOverUser3();
        assertUser3InfoDisplayed();
    }

    /**
     * Test Case 14:
     * Test Alerts Page
     */
    @Test(enabled = true, priority = 14)
    public void testAlertsPage() {
        navigateToJsAlertsPage();
        clickAlert();
        assertAlertMessage("I am a JS Alert");
        acceptAlert();
        clickConfirmAlert();
        assertAlertMessage("I am a JS Confirm");
        acceptAlert();
        clickPromptAlert();
        enterPrompt("Hello World!");
        acceptAlert();
        assertPromptMessage("Hello World!");
    }

    /**
     * Test Case 15:
     * Test Java Script Error
     */
    @Test(enabled = true, priority = 15)
    public void testJavaScriptError() {
        navigateToJsErrorPage();
        GetJSErrosLog();
        assertPageContainsErrors();
    }

    /**
     * Test Case 16:
     * Test New Tab opens as expected
     */
    @Test(enabled = true, priority = 16)
    public void testWindowTabOpen() {
        navigateToNewWindowTestPage();
        openNewTab();
        assertNewTabIsOpen();
    }

    /**
     * Test Case 17:
     * Verify Context Menu Alert is present when the Menu is right-clicked
     */
    @Test(enabled = true, priority = 17)
    public void testContextAlert() {
        navigateToContextMenuPage();
        rightClickMenu();
        switchToAlert();
        assertAlertContains("You selected a context menu");
    }

    /**
     * Test Case 18:
     * Verify Uploading Page is working as expected
     */
    @Test(enabled = true, priority = 18)
    public void testFileUpload() {
        navigateToUploadPage();
        uploadFIle();
        assertFileUploaded();
    }

}