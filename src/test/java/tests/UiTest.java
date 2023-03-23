package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.*;
import utils.SetupAndTeardown;
import utils.Utils;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.*;

public class UiTest extends SetupAndTeardown {

    Utils utils = new Utils();

    @Severity(SeverityLevel.MINOR)
    @Description("1. Login Successful (valid credentials).")
    @Story("Login")
    @Test(enabled = true, description = "Test Login successfully.")
    void loginWithValidCredentials() throws FileNotFoundException {

        open(Configuration.baseUrl+"/login");
        new LoginSteps().signIn(utils.getDataFromConfig("USER_NAME"),
                utils.getDataFromConfig("USER_PASSWORD"),
                utils.getDataFromConfig("LOGIN_SUCCESSFUL_MESSAGE"));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("2. Login Failure (wrong credentials).")
    @Story("Login")
    @Test(enabled = true, description = "Test Login failed for incorrect user and password.")
    void loginWithInvalidCredentials() throws FileNotFoundException {

        open(Configuration.baseUrl+"/login");
        new LoginSteps().signIn(utils.getDataFromConfig("INVALID_USER_NAME"),
                                                    utils.getDataFromConfig("INVALID_USER_PASSWORD"),
                                                    utils.getDataFromConfig("LOGIN_ERROR_MESSAGE"));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("3. Checkboxes: checks and unchecks.")
    @Story("Checkboxes")
    @Test(enabled = true, description = "Test checkboxes are properly checked and unchecked")
    void checkboxesChecks() {

        open(Configuration.baseUrl+"/checkboxes");

        CheckboxesSteps checkboxesSteps = new CheckboxesSteps();
        checkboxesSteps.checksCheckbox1();
        checkboxesSteps.checksСheckbox2();
    }

    @Severity(SeverityLevel.MINOR)
    @Description("4. Context menu.")
    @Story("Context menu")
    @Test(enabled = true, description = "Test to check the alert menu text")
    void checkAlertMenuText() throws FileNotFoundException {

        open(Configuration.baseUrl+"/context_menu");

        ContextMenuSteps contextMenuSteps = new ContextMenuSteps();
        contextMenuSteps.rightClickToHotSpot();
        contextMenuSteps.checkAlertText(Utils.getDataFromConfig("CONTEXT_MENU_ALERT_TEXT"));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("5. Drag and Drop.")
    @Story("Drag and Drop")
    @Test(enabled = true, description = "Test drags element A to element B")
    void checkDragAndDrop() {

        open(Configuration.baseUrl+"/drag_and_drop");

        DragAndDropStep dragAndDropStep = new DragAndDropStep();
        dragAndDropStep.switchElements();
        dragAndDropStep.checkElementsText();
    }

    @Severity(SeverityLevel.MINOR)
    @Description("6. Dropdown.")
    @Story("Dropdown")
    @Test(enabled = true, description = "Test to check selected options in drop down menu")
    void checkDropdown() {

        open(Configuration.baseUrl+"/dropdown");

        DropdownSteps dropdawnSteps = new DropdownSteps();
        dropdawnSteps.selectOption("Option 1");
        dropdawnSteps.checkSelectedOption("Option 1");
        dropdawnSteps.selectOption("Option 2");
        dropdawnSteps.checkSelectedOption("Option 2");
    }

    @Severity(SeverityLevel.MINOR)
    @Description("7. Dynamic Content.")
    @Story("Dynamic Content")
    @Test(enabled = true, description = "Test content changes on each refresh")
    void checkDynamicContent() {

        open(Configuration.baseUrl+"/dynamic_content");
        new DynamicContentSteps().checkDynamicContent();

    }

    @Severity(SeverityLevel.MINOR)
    @Description("8. Dynamic Controls.")
    @Story("Dynamic Controls")
    @Test(enabled = true, description = "Test of dynamic controls")
    void dynamicControls() {

        open(Configuration.baseUrl+"/dynamic_controls");
        DynamicControlsSteps dynamicControlsSteps = new DynamicControlsSteps();
        dynamicControlsSteps.checkDisplayDynamicCheckbox();
        dynamicControlsSteps.checkDisplayDynamicInput();
    }


    @Severity(SeverityLevel.MINOR)
    @Description("9. Dynamic Loading.")
    @Story("Dynamic Loading")
    @Test(enabled = true, description = "Test dynamic loading text is displayed")
    void dynamicallyLoadedElements() throws FileNotFoundException {

        open(Configuration.baseUrl+"/dynamic_loading/2");
        new DynamicallyLoadedSteps().checkDisplayTextOnLoadedPage(Utils.getDataFromConfig("DYNAMIC_LOADING_TEXT"));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("10. File Download.")
    @Story("File Download")
    @Test(enabled = true, description = "Test file is downloaded")
    void fileDownloader() throws FileNotFoundException {

        open(Configuration.baseUrl+"/download");
        new DownloadSteps().checkDownloadFile();

    }

    @Severity(SeverityLevel.MINOR)
    @Description("11. File Upload.")
    @Story("File Upload")
    @Test(enabled = true, description = "Test file is uploaded")
    void fileUploader() throws FileNotFoundException {

        open(Configuration.baseUrl+"/upload");
        new UploadSteps().uploadFile(Utils.getDataFromConfig("FILE_UPLOAD_PATH"), Utils.getDataFromConfig("FILE_UPLOAD_NAME"));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("12. Floating menu.")
    @Story("Floating menu")
    @Test(enabled = true, description = "Test floating menu is displayed after scroll")
    void floatingMenu() {

        open(Configuration.baseUrl+"/floating_menu");
        new FloatingMenuSteps().checkMenuAfterScroll();
    }

    @Severity(SeverityLevel.MINOR)
    @Description("13. Iframe.")
    @Story("Iframe")
    @Test(enabled = true, description = "Test typed text is as expected in iframe")
    void iFrame() throws FileNotFoundException {

        open(Configuration.baseUrl+"/iframe");
        IframeSteps iframeSteps = new IframeSteps();

        iframeSteps.typeTextInIframe(utils.getDataFromConfig("IFRAME_TEXT"));
        iframeSteps.checkText(utils.getDataFromConfig("IFRAME_TEXT"));

    }

    @Severity(SeverityLevel.MINOR)
    @Description("14. Mouse Hover.")
    @Story("Mouse Hover")
    @Test(enabled = true, description = "Test additional information is displayed for each image")
    void mouseHover() {

        open(Configuration.baseUrl+"/hovers");

        MouseHoverSteps mouseHoverSteps = new MouseHoverSteps();
        mouseHoverSteps.getUserInfo(1);
        mouseHoverSteps.getUserInfo(2);
        mouseHoverSteps.getUserInfo(3);
    }

    @Severity(SeverityLevel.MINOR)
    @Description("15. JavaScript Alerts.")
    @Story("JavaScript Alerts")
    @Test(enabled = true, description = "Test alerts messages")
    void javaScriptAlerts() throws FileNotFoundException {

        open(Configuration.baseUrl+"/javascript_alerts");
        JavaScriptAlertsSteps javaScriptAlertsSteps = new JavaScriptAlertsSteps();

        javaScriptAlertsSteps.checkJsAlert(Utils.getDataFromConfig("JS_ALERT_TEXT"), Utils.getDataFromConfig("JS_ALERT_RESULT"));
        javaScriptAlertsSteps.checkJsConfirm(Utils.getDataFromConfig("JS_COONFIRM_RESULT"));
        javaScriptAlertsSteps.checkJsPrompt(utils.getDataFromConfig("IFRAME_TEXT"), "You entered: "+utils.getDataFromConfig("IFRAME_TEXT"));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("16. JavaScript Error.")
    @Story("JavaScript Error")
    @Test(enabled = true, description = "Test page contains JavaScript error")
    void javaScriptError() throws FileNotFoundException {

        open(Configuration.baseUrl+"/javascript_error");

        JavascriptErrorSteps javascriptErrorSteps = new JavascriptErrorSteps();
        Assert.assertTrue(javascriptErrorSteps.isTextExistInError(Utils.getDataFromConfig("JAVASCRIPT_PAGE_ERROR")), "Error not found");

       }

    @Severity(SeverityLevel.MINOR)
    @Description("17. Open in New Tab.")
    @Story("Open in New Tab")
    @Test(enabled = true, description = "Test new tab is opened with defined text")
    void OpenInNewTab() throws FileNotFoundException {

        open(Configuration.baseUrl+"/windows");
        new WindowsSteps().checkOpenedNewTabWithText(Utils.getDataFromConfig("NEW_TAB_TEXT"));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("18. Notification Message.")
    @Story("Notification Message")
    @Test(enabled = true, description = "Test notification message is displayed")
    void NotificationMessage() throws FileNotFoundException {

        String[] msgs = {"Action Successful", "Action unsuccessful, please try again", "Action Unsuccessful"};


        open(Configuration.baseUrl+"/notification_message_rendered");
        NotificationMessageSteps notificationMessageSteps = new NotificationMessageSteps();

        notificationMessageSteps.multipleTimesClick(4);
        notificationMessageSteps.checkNotificationMessage(msgs);

    }

}
