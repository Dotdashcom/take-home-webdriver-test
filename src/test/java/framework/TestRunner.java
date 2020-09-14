package framework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestRunner {

    private static WebDriver driver = null;
    private static String url = "http://localhost:7080/";
    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";
    private String wrongUsername = "nottomsmith";
    private String wrongPassword = "NotSuperSecretPassword!";

    @Test
    public void loginSuccess () {
        getUrl("login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLoginInfo(driver, username, password);
        Assert.assertTrue(loginPage.isLoginSuccess(driver));
    }

    @Test
    public void loginFailure () {
        getUrl("login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterIncorrectLoginInfo(driver, wrongUsername, wrongPassword);
        Assert.assertTrue(loginPage.isLoginFailed(driver));
    }

    @Test
    public void checkBoxes () {
        getUrl("checkboxes");
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.selectCheckboxes(driver);
        Assert.assertTrue(checkboxesPage.isChecked(driver));
        Assert.assertTrue(checkboxesPage.isUnchecked(driver));
    }

    @Test
    public void contextMenu() {
        getUrl("context_menu");
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.contextMenuActions(driver);
        Assert.assertEquals(contextMenuPage.contextMenuActions(driver), "You selected a context menu");
    }

    @Test
    public void dragAndDrop() {
        getUrl("drag_and_drop");
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.dragAndDropAction(driver);
        Assert.assertEquals(dragAndDropPage.getTextFromColumnA(driver), "B");
        Assert.assertEquals(dragAndDropPage.getTextFromColumnB(driver), "A");
    }

    @Test
    public void dropdown() {
        getUrl("dropdown");
        DropdownPage dropdown = new DropdownPage(driver);
        dropdown.selectFromDropdown(driver, "1");
        Assert.assertEquals(dropdown.getSelectedOption(driver), "Option 1");
        dropdown.selectFromDropdown(driver, "2");
        Assert.assertEquals(dropdown.getSelectedOption(driver), "Option 2");
    }

    @Test
    public void dynamicContent() {
        getUrl("dynamic_content");
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        Assert.assertFalse(dynamicContentPage.checkDynamicContent(driver, 3));
    }

    @Test
    public void dynamicControls() {
        getUrl("dynamic_controls");
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        Assert.assertTrue(dynamicControlsPage.checkRemoveButton(driver));
        Assert.assertTrue(dynamicControlsPage.checkAddButton(driver));
        Assert.assertTrue(dynamicControlsPage.checkEnableButton(driver));
        Assert.assertTrue(dynamicControlsPage.checkDisableButton(driver));
    }

    @Test
    public void dynamicLoading() {
        getUrl("dynamic_loading/2");
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        Assert.assertTrue(dynamicLoadingPage.testDynamicLoading(driver));
    }

    @Test
    public void fileDownload() {
        getUrl("download");
        FileDownloaderPage fileDownloaderPage = new FileDownloaderPage(driver);
        fileDownloaderPage.testFileDownloader(driver);
        Assert.assertTrue(fileDownloaderPage.isFileDownloaded("/Users/Technosoft/Downloads", "some-file.txt"));
    }

    @Test
    public void fileUpload() {
        getUrl("upload");
        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver);
        fileUploaderPage.testFileUploader(driver, "/Users/Technosoft/Downloads/some-file.txt");
        Assert.assertTrue(fileUploaderPage.isUploadSuccess(driver));
    }

    @Test
    public void floatingMenu() {
        getUrl("floating_menu");
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        Assert.assertTrue(floatingMenuPage.testFloatingMenu(driver));
    }

    @Test
    public void iFrame() {
        getUrl("iframe");
        IFramePage iFramePage = new IFramePage(driver);
        Assert.assertTrue(iFramePage.testIframe(driver, "Some text here"));
    }

    @Test
    public void mouseHover() {
        getUrl("hovers");
        MouseHoverPage mouseHoverPage = new MouseHoverPage(driver);
        Assert.assertTrue(mouseHoverPage.testMouseHover(driver));
    }

    @Test
    public void javaScriptAlerts() {
        getUrl("javascript_alerts");
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        Assert.assertTrue(javaScriptAlertsPage.testJsAlertButton(driver));
        Assert.assertTrue(javaScriptAlertsPage.testJsConfirmButton(driver));
        Assert.assertTrue(javaScriptAlertsPage.testJsPromptButton(driver, "Hello World!"));
    }

    @Test
    public void javaScriptError() {
        getUrl("javascript_error");
        JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage(driver);
        Assert.assertTrue(javaScriptErrorPage.testJavaScriptError(driver));
    }

    @Test
    public void openInNewTab() {
        getUrl("windows");
        OpenInNewTabPage openInNewTabPage = new OpenInNewTabPage(driver);
        Assert.assertTrue(openInNewTabPage.testOpeningNewPage(driver));
    }

    @Test
    public void notificationMessage() {
        getUrl("notification_message_rendered");
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
        Assert.assertTrue(notificationMessagePage.testNotificationMessage(driver));
    }


    @After
    public void after() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    public void getUrl (String ending) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String finalUrl = url + ending;
        driver.get(finalUrl);
        System.out.println("URL is: " + finalUrl );
        driver.manage().window().maximize();
    }

}
