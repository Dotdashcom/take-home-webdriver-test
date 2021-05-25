package tests;

import utils.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.DDCommon;

public class Regression {

    protected DDCommon DDCommon;
    private static WebDriver driver;

    public Regression(){
    }

    @BeforeMethod
    public void setup(){
        DDCommon = BrowserUtil.initBrowser();
        driver = BrowserUtil.GetDriver();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    private void loadBrowser(String url){
        driver.get(BrowserUtil.BaseUrl + url);
        driver.manage().window().maximize();
    }

    @Test (testName = "1. Login Success")
    public void loginSuccess(){
        loadBrowser("login");
        DDCommon.login.verifyLoggedIntoApp("tomsmith", "SuperSecretPassword!");
    }

    @Test (testName = "2. Login Failure")
    public void loginFailure(){
        loadBrowser("login");
        DDCommon.login.verifyLoginFailed("invalid", "invalid");
    }

    @Test (testName = "3. Checkboxes")
    public void checkboxes(){
        loadBrowser("checkboxes");
        DDCommon.checkboxes.verifyCheckboxesStateAfterActions();
    }

    @Test (testName = "4. Context Menu")
    public void contextMenu(){
        loadBrowser("context_menu");
        DDCommon.contextMenu.clickAndAssertContextMenu();
    }

    //FAIL  despite trying few different ways, the drag/drop isn't working.
    @Test(enabled = false, testName = "5. Drag and Drop")
    public void dragAndDrop(){
        loadBrowser("drag_and_drop");
        DDCommon.dragAndDrop.dragDropVerify();
    }

    @Test (testName = "6. Dropdown")
    public void dropdown(){
        loadBrowser("dropdown");
        DDCommon.dropdown.selectVerifyOptions();
    }

    @Test (testName = "7. Dynamic Content")
    public void dynamicContent(){
        loadBrowser("dynamic_content");
        DDCommon.dynamicContent.refreshVerify();
    }

    @Test (testName = "8. Dynamic Controls")
    public void dynamicControls() {
        loadBrowser("dynamic_controls");
        DDCommon.dynamicControls.verifyDynamicControls();
    }

    @Test (testName = "9. Dynamic Loading")
    public void dynamicLoading() {
        loadBrowser("dynamic_loading/2");
        DDCommon.dynamicLoading.verifyDynamicLoading();
    }

    //Download directory needs to be set as per user, System property was not working consistently.
    @Test (testName = "10. File Download")
    public void fileDownload() {
        loadBrowser("download");
        DDCommon.filesOperations.verifyFileDownload();
    }

    @Test (testName = "11. File Upload")
    public void fileUpload() {
        loadBrowser("upload");
        DDCommon.filesOperations.verifyFileUpload();
    }

    @Test (testName = "12. Floating Menu")
    public void floatingMenu() {
        loadBrowser("floating_menu");
        DDCommon.floatingMenu.verifyFloatingMenu();
    }

    @Test (testName = "13. Iframe")
    public void iframe() {
        loadBrowser("iframe");
        DDCommon.iframe.verifyIframe();
    }

    @Test (testName = "14. Mouse Hover")
    public void mouseHover() {
        loadBrowser("hovers");
        DDCommon.mouseHover.verifyMouseHover();
    }

    @Test (testName = "15. JavaScript Alerts")
    public void javaScriptAlerts() {
        loadBrowser("javascript_alerts");
        DDCommon.javaScriptAlerts.verifyJavaScriptAlerts();
    }

    @Test (testName = "16. JavaScript Error")
    public void javaScriptError() {
        loadBrowser("javascript_error");
        DDCommon.javaScriptError.verifyJavaScriptError();
    }

    @Test (testName = "17. Open in New Tab")
    public void openInNewTab() {
        loadBrowser("windows");
        DDCommon.openInNewTab.verifyOpenInNewTab();
    }

    @Test (testName = "18. Notification Message")
    public void notificationMessage() {
        loadBrowser("notification_message_rendered");
        DDCommon.notificationMessage.verifyNotificationMessages();
    }
}
