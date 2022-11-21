package tests;

import configuration.BasePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class dotDashCom extends BasePage {

    LoginPage loginPage;
    LandingPage landingPage;
    CheckboxesPage checkboxesPage;
    ContextMenuPage contextMenuPage;
    DragAndDropPage dragAndDropPage;
    DropDownPage dropDownPage;
    DynamicPage dynamicPage;
    DynamicControlsPage dynamicControlsPage;
    DynamicLoadingPage dynamicLoadingPage;
    DownloadPage downloadPage;
    FramesPage framesPage;
    FloatingMenuPage floatingMenuPage;
    HoverPage hoverPage;
    NotificationMessagePage notificationMessagePage;

    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(driver);
        landingPage = new LandingPage(driver);
        checkboxesPage = new CheckboxesPage(driver);
        contextMenuPage = new ContextMenuPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        dropDownPage = new DropDownPage(driver);
        dynamicPage = new DynamicPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        downloadPage = new DownloadPage(driver);
        framesPage = new FramesPage(driver);
        floatingMenuPage = new FloatingMenuPage(driver);
        hoverPage = new HoverPage(driver);
        notificationMessagePage = new NotificationMessagePage(driver);
    }

    @Test
    public void successfulLogin() {
        String username = "admin";

        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Basic Auth");
        loginPage.authenticateAs(username, username);
        assertTitleIsDisplayed("Basic Auth");
    }

    @Test
    public void unSuccessfulLogin() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Basic Auth");
        loginPage.authenticateAs(username, password);
        assertTitleIsNotDisplayed("Basic Auth");
    }

    @Test
    public void checkBoxes() {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Checkboxes");
        assertTitleIsDisplayed("Checkboxes");
        checkboxesPage.checkAndUncheckCheckboxes();
    }

    @Test
    public void contextMenu() {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Context Menu");
        assertTitleIsDisplayed("Context Menu");
        contextMenuPage.rightClickOnBox();
        assertAlert("You selected a context menu");
        acceptAlert();
    }

    @Test
    public void dragAndDrop() {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Drag and Drop");
        assertTitleIsDisplayed("Drag and Drop");
        dragAndDropPage.dragDropAOnDropB();
    }

    @Test
    public void dropDown() {
        String option1 = "Option 1";
        String option2 = "Option 2";

        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Dropdown");
        assertTitleIsDisplayed("Dropdown List");
        dropDownPage.selectOnDropDownByText(option1);
        dropDownPage.assertOptionIsSelectedByText(option1);
        dropDownPage.selectOnDropDownByText(option2);
        dropDownPage.assertOptionIsSelectedByText(option2);
    }

    @Test
    public void dynamicContent() {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Dynamic Content");
        assertTitleIsDisplayed("Dynamic Content");
        dynamicPage.assertRowsHasChanged();
    }

    @Test
    public void dynamicControls() throws InterruptedException {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Dynamic Controls");
        assertTitleIsDisplayed("Dynamic Controls");
        clickOnButtonByText("Remove");
        dynamicControlsPage.waitLoadingIconToDisappear();
        dynamicControlsPage.assertCheckboxesAre("Not displayed");
        clickOnButtonByText("Add");
        dynamicControlsPage.waitLoadingIconToDisappear();
        dynamicControlsPage.assertCheckboxesAre("displayed");
        clickOnButtonByText("Enable");
        dynamicControlsPage.waitTextBoxToBeEnabled();
        clickOnButtonByText("Disable");
        dynamicControlsPage.waitTextBoxNotToBeEnabled();
    }

    @Test
    public void dynamicLoading() {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Dynamic Loading");
        assertTitleIsDisplayed("Dynamically Loaded Page Elements");
        dynamicLoadingPage.clickOnFirstExample();
        clickOnButtonByText("Start");
        dynamicLoadingPage.waitOnHelloWorld();
    }

    @Test
    public void downloadFile() throws InterruptedException {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("File Download");
        assertTitleIsDisplayed("File Downloader");
        downloadPage.clickOnDownloadFile();
        downloadPage.checkIfFileIsDownloaded("some-file.txt");
    }

    @Test
    public void uploadFile() throws InterruptedException {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("File Upload");
        assertTitleIsDisplayed("File Uploader");
    }

    @Test
    public void floatingMenu() {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Floating Menu");
        assertTitleIsDisplayed("Floating Menu");
        scrollToBottom();
        floatingMenuPage.assertMenuIsShowing();
    }

    @Test
    public void iFrame() {
        String message = "Automation text";
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Frames");
        assertTitleIsDisplayed("Frames");
        framesPage.clickOniFrames();
        assertTitleIsDisplayed("An iFrame containing the TinyMCE WYSIWYG Editor");
        framesPage.closeNotification();
        framesPage.typeOnFrame(message);
        framesPage.assertMessageOniFrameIs(message);
    }

    @Test
    public void hover() {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Hovers");
        assertTitleIsDisplayed("Hovers");
        hoverPage.hoverAllPicturesAndCheckMessage();
    }

    @Test
    public void jsAlerts() {
        String text = "Automation message";

        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("JavaScript Alerts");
        assertTitleIsDisplayed("JavaScript Alerts");
        clickOnButtonByText("Click for JS Alert");
        assertAlert("I am a JS Alert");
        acceptAlert();
        clickOnButtonByText("Click for JS Confirm");
        assertAlert("I am a JS Confirm");
        acceptAlert();
        clickOnButtonByText("Click for JS Prompt");
        assertAlert("I am a JS prompt");
        typeOnAlert(text);
        assertTextOnAlertIs(text);
    }

    @Test
    public void jsError() {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("JavaScript onload event error");
        assertTextDisplayed("This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");
    }

    @Test
    public void newWindow() {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Multiple Windows");
        assertTitleIsDisplayed("Opening a new window");
        selectOptionByText("Click Here");
        moveToWindow("New Window");
    }

    @Test
    public void notificationMessage() {
        landingPage.assertLandingPageIsDisplayed();
        selectOptionByText("Notification Messages");
        assertTitleIsDisplayed("Notification Message");
        notificationMessagePage.getNotificationMessages();
    }
}
