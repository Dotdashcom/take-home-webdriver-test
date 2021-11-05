import constants.CheckBoxStatus;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Setup {
    WebDriver driver;
    LoginPage objLoginPage;
    CheckboxPage objCheckboxPage;
    ContextMenuPage objContextMenuPage;
    DragDropPage objDragDropPage;
    DropdownPage objDropdownPage;
    DynamicContentPage objDynamicContentPage;
    DynamicControlsPage objDynamicControlsPage;
    DynamicLoadingPage obgDynamicLoadingPage;
    FileDownloadPage objFileDownloadPage;
    FileUploadPage objFileUploadPage;
    FloatingMenuPage objFloatingMenuPage;
    IframePage objIframePage;
    MouseHoverPage objMouseHoverPage;
    JavaScriptAlertsPage objJavaScriptAlertsPage;
    JavaScriptErrorPage objJavaScriptErrorPage;
    OpenNewTabPage objOpenNewTabPage;
    NotificationMessagePage objNotificationMessagePage;
    public static final String downloadPath = "/Users/baixiaofei528/Downloads";

    @BeforeTest
    public void setup() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get("http://localhost:7080");
    }

    @Test
    public void test_login_success() {
        this.objLoginPage = new LoginPage(this.driver);
        this.objLoginPage.enterUsername("tomsmith");
        this.objLoginPage.enterPassword("SuperSecretPassword!");
        this.objLoginPage.clickOnLoginButton();
        this.objLoginPage.wait(1);
        this.objLoginPage.softAssertLoginResult(false);
    }

    @Test
    public void test_login_failure() {
        this.objLoginPage = new LoginPage(this.driver);
        this.objLoginPage.enterUsername("tomsmitH");
        this.objLoginPage.enterPassword("supersecretpassword!");
        this.objLoginPage.clickOnLoginButton();
        this.objLoginPage.wait(1);
        this.objLoginPage.softAssertLoginResult(true);
    }

    @Test
    public void test_check_checkbox() {
        this.objCheckboxPage = new CheckboxPage(this.driver);
        this.objCheckboxPage.findCheckBox(1);
        this.objCheckboxPage.resetCheckBoxTo(1, CheckBoxStatus.UNCHECKED);
        this.objCheckboxPage.clickCheckBox(1);
        this.objCheckboxPage.wait(1);
        this.objCheckboxPage.assertCheckboxResult(1, CheckBoxStatus.CHECKED);
    }

    @Test
    public void test_uncheck_checkbox() {
        this.objCheckboxPage = new CheckboxPage(this.driver);
        this.objCheckboxPage.findCheckBox(2);
        this.objCheckboxPage.resetCheckBoxTo(2, CheckBoxStatus.CHECKED);
        this.objCheckboxPage.clickCheckBox(2);
        this.objCheckboxPage.wait(2);
        this.objCheckboxPage.assertCheckboxResult(2, CheckBoxStatus.UNCHECKED);
    }

    @Test
    public void test_right_click_context_menu() {
        this.objContextMenuPage = new ContextMenuPage(this.driver);
        this.objContextMenuPage.wait(1);
        this.objContextMenuPage.rightClickContextMenu();
        this.objContextMenuPage.assertAlertText("You selected a context menu");
    }

    @Test
    public void test_drag_drop() {
        this.objDragDropPage = new DragDropPage(this.driver);
        this.objDragDropPage.dragDropElement();
        this.objDragDropPage.wait(1);
        this.objDragDropPage.assertSwitchText();
    }

    @Test
    public void test_dropdown() {
        this.objDropdownPage = new DropdownPage(this.driver);
        List<WebElement> options = this.objDropdownPage.getOptions();
        for (WebElement option : options) {
            this.objDropdownPage.clickDropdownElement(option.getText());
            this.objDropdownPage.assertSelectStatus(option);
        }
    }

    @Test
    public void test_dynamic_content() {
        this.objDynamicContentPage = new DynamicContentPage(this.driver);
        int times = 5;
        for (int i=0; i < times; i++) {
            this.objDynamicContentPage.assertContents();
        }
    }

    @Test
    public void test_dynamic_controls() {
        this.objDynamicControlsPage = new DynamicControlsPage(this.driver);
        this.objDynamicControlsPage.clickRemove();
        this.objDynamicControlsPage.assertCheckBox(true);
        this.objDynamicControlsPage.clickAdd();
        this.objDynamicControlsPage.assertCheckBox(false);
        this.objDynamicControlsPage.clickEnable();
        this.objDynamicControlsPage.assertInputBox(true);
        this.objDynamicControlsPage.clickDisable();
        this.objDynamicControlsPage.assertInputBox(false);
    }

    @Test
    public void test_dynamic_loading() {
        this.obgDynamicLoadingPage = new DynamicLoadingPage(this.driver);
        this.obgDynamicLoadingPage.testHiddenElement("/1");
        this.obgDynamicLoadingPage.testNewElement("/2");
    }

    @Test
    public void test_file_download() {
        this.objFileDownloadPage = new FileDownloadPage(this.driver, downloadPath);
        this.objFileDownloadPage.clickFileDownloadLink();
        this.objFileDownloadPage.assertFileDownloadStatus("some-file.txt");
    }

    @Test
    public void test_file_upload() {
        this.objFileUploadPage = new FileUploadPage(this.driver);
        this.objFileUploadPage.uploadByButton();
        this.objFileUploadPage.assertFileUploadStatus();
    }

    @Test
    public void test_floating_menu() {
        this.objFloatingMenuPage = new FloatingMenuPage(this.driver);
        this.objFloatingMenuPage.scrollDown();
        this.objFloatingMenuPage.assertFloatingMenu();
    }

    @Test
    public void test_iframe() {
        this.objIframePage = new IframePage(this.driver);
        this.objIframePage.switchIframe();
        this.objIframePage.assertTextContent();
    }

    @Test
    public void test_mouse_hover() {
        for(int i=1; i<4; i++) {
            this.objMouseHoverPage = new MouseHoverPage(this.driver);
            this.objMouseHoverPage.hoverImage(i);
            this.objMouseHoverPage.assertDisplayContent(i);
        }
    }

    @Test
    public void test_js_alerts() {
        this.objJavaScriptAlertsPage = new JavaScriptAlertsPage(this.driver);
        this.objJavaScriptAlertsPage.testJSAlert();
        this.objJavaScriptAlertsPage.assertAlertContent("I am a JS Alert");
        this.objJavaScriptAlertsPage.testJSConfirm();
        this.objJavaScriptAlertsPage.assertAlertResultContent("You clicked: Ok");
        this.objJavaScriptAlertsPage.testJSPrompt("Hello World!");
        this.objJavaScriptAlertsPage.assertResultContainContent("Hello World!");
    }

    @Test
    public void test_js_error() {
        this.objJavaScriptErrorPage = new JavaScriptErrorPage(this.driver);
        this.objJavaScriptErrorPage.assertJSError("Cannot read properties of undefined (reading 'xyz')");
    }

    @Test
    public void test_open_new_tab() {
        this.objOpenNewTabPage = new OpenNewTabPage(this.driver);
        this.objOpenNewTabPage.clickNewTabLink();
        this.objOpenNewTabPage.assertNewTabOpenedContent();
    }

    @Test
    public void test_notification_test() {
        this.objNotificationMessagePage = new NotificationMessagePage(this.driver);
        for(int i=0; i<5; i++) {
            this.objNotificationMessagePage.clickNotificationLink();
            this.objNotificationMessagePage.assertNotificationContent();
        }
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
