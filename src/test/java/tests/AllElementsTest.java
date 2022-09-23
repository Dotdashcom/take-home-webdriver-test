package tests;

import core.BasePageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;


public class AllElementsTest extends BasePageTest {

    protected CheckBoxPage checkBoxPage;
    protected ContextMenuPage contextMenuPage;
    protected DragAndDropPage dragAndDropPage;
    protected DropdownPage dropdownPage;
    protected DynamicContentPage dynamicContentPage;
    protected DynamicControlsPage dynamicControlsPage;
    protected DynamicLoadingPage dynamicLoadingPage;
    protected FileDownloadPage fileDownloadPage;
    protected FileUploadPage fileUploadPage;
    protected FloatingMenuPage floatingMenuPage;
    protected FramesPage framesPage;
    protected NestedFramesPage nestedFramesPage;
    protected IframesPage iframesPage;
    protected MouseHoverPage mouseHoverPage;
    protected JavaScriptAlertsPage jsAlertsPage;
    protected JavaScriptErrorPage jsErrorPage;
    protected MultipleTabsPage multipleTabsPage;
    protected NotificationsPage notificationsPage;


    @Test(priority = 3)
    public void checkBoxTests() {
        landingPage.navigateTo("checkboxes");
        checkBoxPage = PageFactory.initElements(driver, CheckBoxPage.class);

        // By default, first checkbox is unselected and second one is selected.

        SoftAssert softAssert = new SoftAssert();
        boolean currentStatus = checkBoxPage.isChecked(0);
        softAssert.assertTrue(!currentStatus);

        checkBoxPage.selectCheckbox(0);
        currentStatus = checkBoxPage.isChecked(0);
        softAssert.assertTrue(currentStatus);

        currentStatus = checkBoxPage.isChecked(1);
        softAssert.assertTrue(currentStatus);

        checkBoxPage.unSelectCheckbox(1);
        currentStatus = checkBoxPage.isChecked(1);
        softAssert.assertTrue(!currentStatus);

        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void contextMenuTests() {
        landingPage.navigateTo("context_menu");
        contextMenuPage = PageFactory.initElements(driver, ContextMenuPage.class);

        contextMenuPage.rightClickOnBox();
        Assert.assertEquals(contextMenuPage.getTextFromAlert(), "You selected a context menu");
    }

    @Test(priority = 5)
    public void dragAndDropTest() {
        landingPage.navigateTo("drag_and_drop");
        dragAndDropPage = PageFactory.initElements(driver, DragAndDropPage.class);

        String leftBoxHeaderBefore = dragAndDropPage.getLeftBoxHeader();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(leftBoxHeaderBefore, "A");
        dragAndDropPage.swapBoxes(dragAndDropPage.getLeftBoxElm(), dragAndDropPage.getRightBoxElm());
        String leftBoxHeaderAfter = dragAndDropPage.getLeftBoxHeader();
        softAssert.assertEquals(leftBoxHeaderAfter, "B");
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void dropdownTests() {
        landingPage.navigateTo("dropdown");
        dropdownPage = PageFactory.initElements(driver, DropdownPage.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dropdownPage.getSelectedOption(), "Please select an option");
        dropdownPage.selectOptionByVisibleText("Option 1");
        softAssert.assertEquals(dropdownPage.getSelectedOption(), "Option 1");
        dropdownPage.selectOptionByVisibleText("Option 2");
        softAssert.assertEquals(dropdownPage.getSelectedOption(), "Option 2");
        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void dynamicContentTests() {
        landingPage.navigateTo("dynamic_content");
        dynamicContentPage = PageFactory.initElements(driver, DynamicContentPage.class);

        SoftAssert softAssert = new SoftAssert();
        for(int i = 0; i < 5; i++) {
            String lastParaTextBefore = dynamicContentPage.getParagraphText(2);
            dynamicContentPage.generateDynamicContent();
            String lastParaTextAfter = dynamicContentPage.getParagraphText(2);
            softAssert.assertNotEquals(lastParaTextBefore, lastParaTextAfter);
        }
        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void dynamicControlsTests() {
        landingPage.navigateTo("dynamic_controls");
        dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);

        SoftAssert softAssert = new SoftAssert();

        dynamicControlsPage.removeCheckBox();
        softAssert.assertEquals(dynamicControlsPage.isElementPresent("#checkbox"), false);

        dynamicControlsPage.addCheckBox();
        softAssert.assertEquals(dynamicControlsPage.isElementPresent("#checkbox"), true);

        dynamicControlsPage.enableInputField();
        softAssert.assertEquals(dynamicControlsPage.isElementDisabled("#input-example > input"), false);

        dynamicControlsPage.disableInputField();
        softAssert.assertEquals(dynamicControlsPage.isElementDisabled("#input-example > input"), true);

        softAssert.assertAll();
    }

    @Test(priority = 9)
    public void dynamicLoadingTest() {
        landingPage.navigateTo("dynamic_loading");
        dynamicLoadingPage = PageFactory.initElements(driver, DynamicLoadingPage.class);

        SoftAssert softAssert = new SoftAssert();
        dynamicLoadingPage.gotoExampleOption(0);
        dynamicLoadingPage.startDynamicLoading();
        dynamicLoadingPage.waitUntilLoadFinish();
        softAssert.assertEquals(dynamicLoadingPage.isVisibleInViewport(driver.findElement(By.cssSelector("div#finish > h4"))), true);

        softAssert.assertAll();
    }

    @Test(priority = 10)
    public void fileDownloadTest() {
        landingPage.navigateTo("download");
        fileDownloadPage = PageFactory.initElements(driver, FileDownloadPage.class);

        fileDownloadPage.downloadFile();
        Assert.assertEquals(fileDownloadPage.isFileDownloaded(), true);
    }

    @Test(priority = 11)
    public void fileUploadTests() {
        landingPage.navigateTo("upload");
        fileUploadPage = PageFactory.initElements(driver, FileUploadPage.class);

        fileUploadPage.uploadSampleFile();
        Assert.assertTrue(fileUploadPage.getUploadedFileName().contains("Dotdash_logo.png"));
    }

    @Test(priority = 12)
    public void floatingMenuTest() {
        landingPage.navigateTo("floating_menu");
        floatingMenuPage = PageFactory.initElements(driver, FloatingMenuPage.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(floatingMenuPage.isVisibleInViewport(driver.findElement(By.id("menu"))), true);
        floatingMenuPage.scrollVerticleByOneScreen();
        softAssert.assertEquals(floatingMenuPage.isVisibleInViewport(driver.findElement(By.id("menu"))), true);
        softAssert.assertAll();
    }

    @Test(priority = 13)
    public void iFrameTests() {

        landingPage.navigateTo("frames");
        framesPage = PageFactory.initElements(driver, FramesPage.class);

        nestedFramesPage = framesPage.goToNestedFramesPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(nestedFramesPage.getTextFromLeftFrame().contains("LEFT"));
        softAssert.assertTrue(nestedFramesPage.getTextFromMiddleFrame().contains("MIDDLE"));
        softAssert.assertTrue(nestedFramesPage.getTextFromRightFrame().contains("RIGHT"));
        softAssert.assertTrue(nestedFramesPage.getTextFromBottomFrame().contains("BOTTOM"));

        landingPage.navigateTo("frames");
        framesPage = PageFactory.initElements(driver, FramesPage.class);
        iframesPage = framesPage.goToIframesPage();

        iframesPage = PageFactory.initElements(driver, IframesPage.class);
        softAssert.assertEquals(iframesPage.getTextFromInnerFrame(), "Your content goes here.");
        iframesPage.setTextInInnerFrame("DotDash-Test-Assessment");
        softAssert.assertEquals(iframesPage.getTextFromInnerFrame(), "DotDash-Test-Assessment");

        softAssert.assertAll();
    }

    @Test(priority = 14)
    public void mouseHoverTest() {
        landingPage.navigateTo("hovers");
        mouseHoverPage = PageFactory.initElements(driver, MouseHoverPage.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(0), false);
        mouseHoverPage.mouseHoverToProfile(0);
        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(0), true);

        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(1), false);
        mouseHoverPage.mouseHoverToProfile(1);
        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(1), true);

        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(2), false);
        mouseHoverPage.mouseHoverToProfile(2);
        softAssert.assertEquals(mouseHoverPage.isUserNameVisible(2), true);

        softAssert.assertAll();
    }

    @Test(priority = 15)
    public void javaScriptAlertTests() {
        landingPage.navigateTo("javascript_alerts");
        jsAlertsPage = PageFactory.initElements(driver, JavaScriptAlertsPage.class);

        SoftAssert softAssert = new SoftAssert();
        jsAlertsPage.clickOnJSAlertButton();
        softAssert.assertEquals(jsAlertsPage.getJSAlertText(), "I am a JS Alert");

        jsAlertsPage.clickOnJSConfirmButton();
        softAssert.assertEquals(jsAlertsPage.getJSAlertText(), "I am a JS Confirm");

        jsAlertsPage.clickOnJSPromptButton();
        jsAlertsPage.setMessageOnJSPrompt("DotDash-Test-Assessment");
        softAssert.assertEquals(jsAlertsPage.getResultMessage(), "You entered: DotDash-Test-Assessment");

        softAssert.assertAll();
    }

    @Test(priority = 16)
    public void javaScriptErrorTest() {
        landingPage.navigateTo("javascript_error");
        jsErrorPage = PageFactory.initElements(driver, JavaScriptErrorPage.class);

        Assert.assertTrue(jsErrorPage.doesPageErrorContains("Cannot read properties of undefined (reading 'xyz')"));
    }

    @Test(priority = 17)
    public void newTabTest() {
        landingPage.navigateTo("windows");
        multipleTabsPage = PageFactory.initElements(driver, MultipleTabsPage.class);

        multipleTabsPage.createATab();
        multipleTabsPage.switchToTab("child");
        Assert.assertEquals(multipleTabsPage.getWindowTitle(), "New Window");
    }

    @Test(priority = 18)
    public void notificationMessageTest() {
        landingPage.navigateTo("notification_message_rendered");
        notificationsPage = PageFactory.initElements(driver, NotificationsPage.class);

        SoftAssert softAssert = new SoftAssert();
        for(int i = 0; i < 5; i++) {
            String message = notificationsPage.clickAndGetNotificationMessage();

            softAssert.assertTrue(message.contains("Action successful") ||
                    message.contains("Action unsuccesful, please try again") ||
                    message.contains("Action unsuccessful"));
        }
        softAssert.assertAll();
    }
}
