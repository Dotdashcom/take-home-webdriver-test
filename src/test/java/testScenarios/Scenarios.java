package testScenarios;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.Base;
import pageObjects.*;

public class Scenarios extends Base {

    @BeforeMethod
    public void setUp() {
        driver = initializeChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void loginSuccess() {
        driver.get(readValue("pages.loginURL"));
        LoginPage LP = new LoginPage(driver);
        //Test is able to login successfully
        LP.validLogin();
        //Test uses an assertion to make sure User has logged in
        Assert.assertTrue(LP.dataAlert().contains("You logged into a secure area!"));
    }

    @Test(priority = 2)
    public void loginFailure() {
        driver.get(readValue("pages.loginURL"));
        LoginPage LP = new LoginPage(driver);
        //Test is not able to login with wrong credentials
        LP.failedLogin();
        //Test uses assertions to check Login failed for incorrect user and password
        Assert.assertTrue(LP.dataAlert().contains("Your password is invalid!"));
    }

    @Test(priority = 3)
    public void checkboxes() {
        driver.get(readValue("pages.checkboxURL"));
        CheckboxesPage CBP = new CheckboxesPage(driver);
        //Test checks and unchecks checkboxes
        //Test uses assertions to make sure boxes were properly checked and unchecked
        //01
        Assert.assertFalse(CBP.isBoxOneChecked());
        Assert.assertTrue(CBP.isBoxTwoChecked());
        //10
        CBP.clickBoxOne();
        CBP.clickBoxTwo();
        Assert.assertTrue(CBP.isBoxOneChecked());
        Assert.assertFalse(CBP.isBoxTwoChecked());
        //00
        CBP.clickBoxOne();
        Assert.assertFalse(CBP.isBoxOneChecked());
        Assert.assertFalse(CBP.isBoxTwoChecked());
        //11
        CBP.clickBoxOne();
        CBP.clickBoxTwo();
        Assert.assertTrue(CBP.isBoxOneChecked());
        Assert.assertTrue(CBP.isBoxTwoChecked());
    }

    @Test(priority = 4)
    public void contextMenu() {
        driver.get(readValue("pages.contextURL"));
        ContextPage CP = new ContextPage(driver);
        //Test right clicks on the context menu
        CP.rightClickBox();
        //Test asserts the alert menu text
        Assert.assertEquals(CP.getTextAlert(), "You selected a context menu");
    }

    @Test(priority = 5)
    public void dragAndDrop() {
        driver.get(readValue("pages.dragAndDropURL"));
        DragAndDropPage DD = new DragAndDropPage(driver);
        //Test drags element A to element B
        DD.dragAndDrop();
        //Test asserts that the text on element A and B are switched
        Assert.assertEquals(DD.getTextBoxA(), "B");
        Assert.assertEquals(DD.getTextBoxB(), "A");
    }

    @Test(priority = 6)
    public void dropdown() {
        driver.get(readValue("pages.dropDownURL"));
        DropDownPage DDP = new DropDownPage(driver);
        String opt1 = "Option 1", opt2 = "Option 2";
        //Test selects Option 1 and Option 2 from the drop down menu
        //Test asserts Option 1 and Option 2 are selected
        DDP.selectOption(opt1);
        Assert.assertEquals(DDP.getTextDropDown(), opt1);
        DDP.selectOption(opt2);
        Assert.assertEquals(DDP.getTextDropDown(), opt2);
    }

    @Test(priority = 7)
    public void dynamicContent() {
        driver.get(readValue("pages.dynamicContentURL"));
        DynamicContentPage DC = new DynamicContentPage(driver);
        //Test refreshes the page a couple of times
        driver.navigate().refresh();
        String[] refreshOneImg = DC.imageArray();
        String[] refreshOneTxt = DC.textArray();
        driver.navigate().refresh();
        String[] refreshTwoImg = DC.imageArray();
        String[] refreshTwoTxt = DC.textArray();
        //Test asserts that the content changes on each refresh
        Assert.assertNotEquals(refreshOneImg, refreshTwoImg);
        Assert.assertNotEquals(refreshOneTxt, refreshTwoTxt);
    }

    @Test(priority = 8)
    public void dynamicControls() {
        driver.get(readValue("pages.dynamicControlsURL"));
        DynamicControlsPage DCP = new DynamicControlsPage(driver);
        //Test clicks on the Remove Button and uses explicit wait
        DCP.clickRemoveButton();
        //Test asserts that the checkbox is gone
        Assert.assertFalse(DCP.isCheckboxDisplayed());
        //Test clicks on Add Button and uses explicit wait
        DCP.clickAddButton();
        //Test asserts that the checkbox is present
        Assert.assertTrue(DCP.isCheckboxDisplayed());
        //Test clicks on the Enable Button and uses explicit wait
        DCP.clickEnableButton();
        //Test asserts that the text box is enabled
        Assert.assertTrue(DCP.isInputFieldEnabled());
        //Test clicks on the Disable Button and uses explicit wait
        DCP.clickDisableButton();
        //Test asserts that the text box is disabled
        Assert.assertFalse(DCP.isInputFieldEnabled());
    }

    @Test(priority = 9)
    public void dynamicLoading() {
        driver.get(readValue("pages.dynamicLoadingURL"));
        DynamicLoadingPage DL = new DynamicLoadingPage(driver);
        //Test clicks the start button and uses explicit wait
        DL.clickStartButton();
        //Test asserts that “Hello World!” text is displayed
        Assert.assertEquals(DL.getTextHelloHeader(), "Hello World!");
    }

    @Test(priority = 10)
    public void fileDownload() throws InterruptedException {
        driver.get(readValue("pages.downloadURL"));
        DownloadPage DP = new DownloadPage(driver);
        //Test clicks on the file
        DP.downloadFile();
        //Test asserts that the file is downloaded
        Assert.assertTrue(DP.isFileDownloaded());
    }

    @Test(priority = 11)
    public void fileUpload() {
        driver.get(readValue("pages.uploadURL"));
        UploadPage UP = new UploadPage(driver);
        String fileToUpload = "some-file.txt";
        //Test uses Upload Button or Drag and Drop to upload a file
        UP.uploadFile(fileToUpload);
        UP.clickUploadButton();
        //Test asserts that the file is uploaded
        Assert.assertTrue(UP.isFileUploaded(fileToUpload));
    }

    @Test(priority = 12)
    public void floatingMenu() {
        driver.get(readValue("pages.floatingMenuURL"));
        FloatingMenuPage FM = new FloatingMenuPage(driver);
        //Test scrolls the page
        FM.scrollDown();
        //Test asserts that the floating menu is still displayed
        Assert.assertTrue(FM.isFloatingMenuDisplayed());
        //Scroll down again
        FM.scrollDown();
        Assert.assertTrue(FM.isFloatingMenuDisplayed());
    }

    @Test(priority = 13)
    public void iframe() {
        driver.get(readValue("pages.iframeURL"));
        IframePage IP = new IframePage(driver);
        String textTest = "Test to send text on iframe";
        //Test switches to Iframe and types some text
        IP.sendText(textTest);
        //Test asserts that the typed text is as expected
        Assert.assertEquals(IP.getTextBox(), textTest);
    }

    @Test(priority = 14)
    public void mouseHover() {
        driver.get(readValue("pages.hoversURL"));
        HoversPage HP = new HoversPage(driver);
        //Test does a mouse hover on each image
        //Test asserts that additional information is displayed for each image
        Assert.assertTrue(HP.areCaptionsDisplayed());
    }

    @Test(priority = 15)
    public void javaScriptAlerts() {
        driver.get(readValue("pages.jsAlertsURL"));
        String textTest = "Test to send text on iframe";
        JSAlertsPage AP = new JSAlertsPage(driver);
        //Test Clicks on JS Alert Button
        AP.clickAlertButton();
        //Test asserts alert message
        Assert.assertEquals(AP.jsMessage(), "I am a JS Alert");
        //Test clicks on JS confirm Button and clicks ok on alert
        AP.clickConfirmButton();
        //Test asserts alert message
        Assert.assertEquals(AP.jsMessage(), "I am a JS Confirm");
        //Test clicks on JS Prompt Button and types a message on Prompt
        AP.clickPromptButton();
        AP.jsPromptSendText(textTest);
        //Test asserts that the alert message contains the typed message
        Assert.assertTrue(AP.resultContainsText(textTest));
    }

    @Test(priority = 16)
    public void javaScriptError() {
        driver.get(readValue("pages.jsErrorURL"));
        JSErrorPage EP = new JSErrorPage(driver);
        //Test finds the JavaScript error on the page
        //Test asserts that the page contains error: Cannot read property 'xyz' of undefined
        Assert.assertTrue(EP.checkForErrorInLogs("Cannot read properties of undefined (reading 'xyz')"));
    }

    @Test(priority = 17)
    public void openInNewTab() {
        driver.get(readValue("pages.windowsURL"));
        WindowsPage WP = new WindowsPage(driver);
        //Test clicks on the Click Here link
        WP.clickHereLink();
        //Test asserts that a new tab is opened with text New Window
        Assert.assertEquals(WP.isNewTabOpened(), "New Window");
    }

    @Test(priority = 18)
    public void notificationMessage() {
        driver.get(readValue("pages.notificationURL"));
        NotificationPage NP = new NotificationPage(driver);
        String[] messages = {"Action successful", "Action unsuccesful, please try again", "Action Unsuccessful"};
        //Test clicks on the Click Here link a multiple times
        //Test asserts that one of the “Action Successful”,
        //“Action unsuccessful, please try again” and “Action Unsuccessful” messages show on click
        NP.clickHereLink();
        Assert.assertTrue(NP.isAnyMessageDisplayed(messages));
    }
}