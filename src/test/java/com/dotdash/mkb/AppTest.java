package com.dotdash.mkb;

import com.dotdash.mkb.pageobjects.*;
import com.dotdash.mkb.utilities.BrowserUtils;
import com.dotdash.mkb.utilities.ConfigFileUtils;
import com.dotdash.mkb.utilities.RoboUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class AppTest {

    private String baseURL;

    private LoginPage loginPage;
    private CheckboxesPage chxBoxPage;
    private ContextMenuPage ctxtMenuPage;
    private DragAndDropPage dragdropPage;
    private DropdownPage ddPage;
    private DynamicContentPage dynContentPage;
    private DynamicControlsPage dynControlsPage;
    private DynamicLoading dynamicloadingPage;
    private DownloadPage downloadPage;
    private FileUploadPage uploadPage;
    private FloatingMenuPage fltMenuPage;
    private IFramesPage iframePage;
    private HoversPage hoversPage;
    private AlertsPage alertsPage;
    private JavascriptErrorPage jsErrorPage;
    private WindowsPage windowsPage;
    private NotificationsPage notificationsPage;


    @BeforeClass
    public void setupClass() {
        ConfigFileUtils.readProperties();
        baseURL = ConfigFileUtils.getProperty("base.url");
        BrowserUtils.createChromeDriver();
        RoboUtils.createRobot();
    }

    @AfterClass
    public void closeClassRun() {
        BrowserUtils.quitBrowser();
    }


    @Test(priority = 0)
    public void loginSuccessTest() {
        loginPage = BrowserUtils.open( baseURL + "login", LoginPage.class);
        assertTrue( loginPage.successLogin().contains("You logged into a secure area!"));
    }

    @Test(priority = 1)
    public void loginFailTest() {
        loginPage = BrowserUtils.open( baseURL + "login", LoginPage.class);
        assertTrue( loginPage.failLogin().contains("Your password is invalid!"));
    }

    @Test(priority = 2)
    public void checkBoxTest() throws InterruptedException {
        chxBoxPage = BrowserUtils.open( baseURL + "checkboxes", CheckboxesPage.class);
        chxBoxPage.selectCheckBoxOne();
        assertTrue(chxBoxPage.isCheckboxOneSelected());
        chxBoxPage.selectCheckBoxTwo();
        assertFalse(chxBoxPage.isCheckboxTwoSelected());
    }

    @Test(priority = 3)
    public void contextMenuTest() {
        ctxtMenuPage = BrowserUtils.open(baseURL + "context_menu", ContextMenuPage.class);

        ctxtMenuPage.contextClickOnHotSpotBox();
        assertTrue(ctxtMenuPage.getMessageFromAlert().equals("You selected a context menu"));
    }

    @Test(priority = 4)
    public void dragDropTest() {
        dragdropPage = BrowserUtils.open(baseURL + "drag_and_drop", DragAndDropPage.class);
        assertTrue(dragdropPage.getFirstElementHeader().equals("A"));
        dragdropPage.dragAToB();
        assertTrue(dragdropPage.getFirstElementHeader().equals("B"));
    }

    @Test(priority = 5)
    public void dropdownTest() {
        ddPage = BrowserUtils.open( baseURL + "dropdown", DropdownPage.class);
        ddPage.select("Option 1");
        assertTrue( ddPage.getSelectedOption().equals("Option 1") );
        ddPage.select("Option 2");
        assertTrue( ddPage.getSelectedOption().equals("Option 2") );
    }

    @Test(priority = 6)
    public void dynamicContentTest() {
        dynContentPage = BrowserUtils.open(baseURL + "dynamic_content", DynamicContentPage.class);

        String beforeText = dynContentPage.getCurrentPara(0);
        BrowserUtils.refresh();
        String afterText = dynContentPage.getCurrentPara(0);
        assertFalse(beforeText.equals(afterText));
    }

    @Test(priority = 7)
    public void dynamicControlsTest() {
        dynControlsPage = BrowserUtils.open(baseURL + "dynamic_controls", DynamicControlsPage.class);

        dynControlsPage.clickAddRemoveButtonAndWaitUntilFinish();
        assertFalse(dynControlsPage.isCheckBoxPresent());

        dynControlsPage.clickAddRemoveButtonAndWaitUntilFinish();
        assertTrue(dynControlsPage.isCheckBoxPresent());
        BrowserUtils.refresh();

        dynControlsPage.clickEnableDisableButtonAndWaitUntilFinish();
        assertTrue(dynControlsPage.isFieldEnabled());
        dynControlsPage.clickEnableDisableButtonAndWaitUntilFinish();
        assertFalse(dynControlsPage.isFieldEnabled());
    }

    @Test(priority = 8)
    public void dynamicLoadingTest() {
        dynamicloadingPage = BrowserUtils.open(baseURL + "dynamic_loading/1", DynamicLoading.class);

        dynamicloadingPage.clickStartButtonAndWaitUntilLoadFinish();
        assertTrue(dynamicloadingPage.getLoadedText().equals("Hello World!"));
    }

    @Test(priority = 9)
    public void downloadTest() {
        downloadPage = BrowserUtils.open(baseURL + "download", DownloadPage.class);

        downloadPage.downloadFile();
        assertTrue(downloadPage.isDownloadedFileLocated());
    }

    @Test(priority = 10, dependsOnMethods = "downloadTest")
    public void uploadTest() {
        uploadPage = BrowserUtils.open(baseURL + "upload", FileUploadPage.class);
        uploadPage.uploadFile("some-file.txt");
        assertTrue(uploadPage.getUploadedFileName().equals("some-file.txt"));
    }

    @Test(priority = 11)
    public void floatingMenuTest() {
        fltMenuPage = BrowserUtils.open(baseURL + "floating_menu", FloatingMenuPage.class);

        assertTrue(fltMenuPage.isMenuDisplayed());
        BrowserUtils.scrollByPage();
        assertTrue(fltMenuPage.isMenuDisplayed());
    }

    @Test(priority = 12)
    public void iframesTest() {
        iframePage = BrowserUtils.open(baseURL + "iframe", IFramesPage.class);

        iframePage.closeToxNotification();
        BrowserUtils.switchToIframe("mce_0_ifr");
        iframePage.setIframeInnerText("Hello there.");
        assertTrue(iframePage.getIFrameInnerText().equals("Hello there."));
        BrowserUtils.switchToDefault();
    }

    @Test(priority = 13)
    public void hoversTest() {
        hoversPage = BrowserUtils.open(baseURL + "hovers", HoversPage.class);

        for(int i = 0; i < 3; ++i) {
            hoversPage.hoverOnUser(i);
            assertTrue(hoversPage.getUserName(i).equals("name: user"+(i+1)));
            assertTrue(hoversPage.getProfileLink(i).equals("http://localhost:7080/users/"+(i+1)));
        }
    }

    @Test(priority = 14)
    public void alertTest() {
        alertsPage = BrowserUtils.open(baseURL + "javascript_alerts", AlertsPage.class);

        alertsPage.triggerAlert();
        assertTrue(alertsPage.geAlertText().equals("I am a JS Alert"));
        alertsPage.acceptAlert();
        assertTrue(alertsPage.getResult().equals("You successfuly clicked an alert"));

        alertsPage.triggerConfirm();
        assertTrue(alertsPage.geAlertText().equals("I am a JS Confirm"));
        alertsPage.dismissAlert();
        assertTrue(alertsPage.getResult().equals("You clicked: Cancel"));

        alertsPage.triggerPrompt();
        alertsPage.setInput("This is new text for prompt.");
        alertsPage.acceptAlert();
        assertTrue(alertsPage.getResult().equals("You entered: This is new text for prompt."));
    }

    @Test(priority = 15)
    public void javascriptErrorTest() {
        jsErrorPage = BrowserUtils.open(baseURL + "javascript_error", JavascriptErrorPage.class);
        assertTrue(jsErrorPage.isErrorPresent("Cannot read properties of undefined (reading 'xyz')"));
    }

    @Test(priority = 16)
    public void newTabTest() {
        windowsPage = BrowserUtils.open(baseURL + "windows", WindowsPage.class);
        windowsPage.openNewWindow();
        windowsPage.switchToNewWindow();
        assertTrue(windowsPage.getNewWindowText().equals("New Window"));
    }

    @Test(priority = 17)
    public void notificationMessageTest() {
        notificationsPage = BrowserUtils.open(baseURL + "notification_message_rendered", NotificationsPage.class);

        for (int i = 0; i < 3; ++i) {
            notificationsPage.loadNewMessage();
            assertTrue(notificationsPage.isFlashMessageExpected());
        }
    }
}
