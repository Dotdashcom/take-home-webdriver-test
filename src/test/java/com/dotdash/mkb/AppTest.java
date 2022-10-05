package com.dotdash.mkb;

import com.dotdash.mkb.pageobjects.*;
import com.dotdash.mkb.utilities.BrowserUtils;
import com.dotdash.mkb.utilities.ConfigFileUtils;
import com.dotdash.mkb.utilities.OsUtils;
import com.dotdash.mkb.utilities.RoboUtils;
import org.testng.annotations.*;

import static org.testng.Assert.*;


public class AppTest {

    private String baseURL;
    private String targetBrowser;

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
        OsUtils.initOsUtils();
        RoboUtils.createRobot();
        ConfigFileUtils.readAllProperties();
        baseURL = ConfigFileUtils.getBrowserProperty("base.url");
        targetBrowser = ConfigFileUtils.getBrowserProperty("browser");
    }

    @BeforeMethod
    public void setUpBrowser() {
        BrowserUtils.instantiateDriver(targetBrowser);
    }

    @AfterMethod
    public void tearDownBrowser() {
        BrowserUtils.quitBrowser();
    }


    @Test
    public void loginSuccessTest() {
        loginPage = BrowserUtils.open( baseURL + "login", LoginPage.class);
        String username = ConfigFileUtils.getUserCredentialsProperty("username");
        String password = ConfigFileUtils.getUserCredentialsProperty("correctPassword");

        assertTrue( loginPage.successLogin(username, password).contains("You logged into a secure area!"));
    }

    @Test(priority = 1)
    public void loginFailTest() {
        loginPage = BrowserUtils.open( baseURL + "login", LoginPage.class);
        String username = ConfigFileUtils.getUserCredentialsProperty("username");
        String wrongPassword = ConfigFileUtils.getUserCredentialsProperty("wrongPassword");
        assertTrue( loginPage.failLogin(username, wrongPassword).contains("Your password is invalid!"));
    }

    @Test(priority = 2)
    public void checkBoxTest() {
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
        assertEquals(ctxtMenuPage.getMessageFromAlert(), "You selected a context menu");
    }

    @Test(priority = 4)
    public void dragDropTest() {
        dragdropPage = BrowserUtils.open(baseURL + "drag_and_drop", DragAndDropPage.class);
        assertEquals(dragdropPage.getFirstElementHeader(), "A");
        dragdropPage.dragAToB();
        assertEquals(dragdropPage.getFirstElementHeader(), "B");
    }

    @Test(priority = 5)
    public void dropdownTest() {
        ddPage = BrowserUtils.open( baseURL + "dropdown", DropdownPage.class);
        ddPage.select("Option 1");
        assertEquals( ddPage.getSelectedOption(), "Option 1");
        ddPage.select("Option 2");
        assertEquals( ddPage.getSelectedOption(), "Option 2");
    }

    @Test(priority = 6)
    public void dynamicContentTest() {
        dynContentPage = BrowserUtils.open(baseURL + "dynamic_content", DynamicContentPage.class);

        String beforeText = dynContentPage.getCurrentPara(0);
        BrowserUtils.refresh();
        String afterText = dynContentPage.getCurrentPara(0);
        assertNotEquals(beforeText, afterText);
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
        assertEquals(dynamicloadingPage.getLoadedText(), "Hello World!");
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
        assertEquals(uploadPage.getUploadedFileName(), "some-file.txt");
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
        assertEquals(iframePage.getIFrameInnerText(), "Hello there.");
        BrowserUtils.switchToDefault();
    }

    @Test(priority = 13)
    public void hoversTest() {
        hoversPage = BrowserUtils.open(baseURL + "hovers", HoversPage.class);

        for(int i = 0; i < 3; ++i) {
            hoversPage.hoverOnUser(i);
            assertEquals(hoversPage.getUserName(i), "name: user"+(i+1));
            assertEquals(hoversPage.getProfileLink(i), "http://localhost:7080/users/"+(i+1));
        }
    }

    @Test(priority = 14)
    public void alertTest() {
        alertsPage = BrowserUtils.open(baseURL + "javascript_alerts", AlertsPage.class);

        alertsPage.triggerAlert();
        assertEquals(alertsPage.geAlertText(), "I am a JS Alert");
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResult(), "You successfuly clicked an alert");

        alertsPage.triggerConfirm();
        assertEquals(alertsPage.geAlertText(), "I am a JS Confirm");
        alertsPage.dismissAlert();
        assertEquals(alertsPage.getResult(), "You clicked: Cancel");

        alertsPage.triggerPrompt();
        alertsPage.setInput("This is new text for prompt.");
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResult(), "You entered: This is new text for prompt.");
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
        assertEquals(windowsPage.getNewWindowText(), "New Window");
        windowsPage.switchToParentWindow();
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
