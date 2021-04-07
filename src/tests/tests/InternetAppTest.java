package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InternetAppTest {
    private WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/yyakeshwara/Downloads/chromedriver 7");
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void testLoginForValidCredentials(){
        driver.get("http://localhost:7080/login");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.verifyLoginFunctioniality("tomsmith","SuperSecretPassword!"),"Login is not successful with valid credentials");
        Reporter.log("Verified login functionality with valid credentials.");
    }

    @Test(priority = 2)
    public void testLoginForInValidCredentials(){
        driver.get("http://localhost:7080/login");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertFalse(loginPage.verifyLoginFunctioniality("tomsmith","xyz"),"Login is  successful with Invalid credentials");
        Reporter.log("Verified login functionality with Invalid credentials.");
    }

    @Test(priority = 3)
     public void testChecksAndUncheckBoxes(){
        driver.get("http://localhost:7080/checkboxes");
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.verifyCheckBoxesSelection();
    }

    @Test ( priority = 4)
    public void testContextMenuAlert(){
        driver.get("http://localhost:7080/context_menu");
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.verifyContextMenuAlert();
    }

    @Test(priority = 5)
    public void testDragAndDrop(){
        driver.get("http://localhost:7080/drag_and_drop");
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.verifyDragAndDropFun();
    }

    @Test(priority = 6)
    public void testOptionSelection(){
        driver.get("http://localhost:7080/dropdown");
        OptionSelectPage optionSelectPage = new OptionSelectPage(driver);
        optionSelectPage.verifyOptionsSelection();
    }

    @Test(priority = 7)
    public void testDynamicContentOnRefresh(){
        driver.get(" http://localhost:7080/dynamic_content");
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        dynamicContentPage.verifyDynamicContentOnRefresh();
    }

    @Test(priority = 8)
    public void testDynamicControls(){
        driver.get("http://localhost:7080/dynamic_controls");
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.verifyDynamicControls();
    }

    @Test(priority = 9)
    public void testDynamicLoadWithExplicitWait(){
        driver.get("http://localhost:7080/dynamic_loading/2");
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        dynamicContentPage.verifyDynamicTextWithExplicitWait();
    }

      @Test(priority = 10)
    public void testFileDownload(){
        driver.get("http://localhost:7080/download");
        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
        fileDownloadPage.verifyFileDownload();
    }

    @Test(priority = 11)
    public void testFileUpload(){
        driver.get(" http://localhost:7080/upload");
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.verifyFileUpload();
    }

    @Test(priority = 12)
    public void testFloatingMenu(){
        driver.get("http://localhost:7080/floating_menu");
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        floatingMenuPage.verifyFloatingMenuDisplay();
    }

    @Test(priority = 13)
    public void testIframeSwitch(){
        driver.get("http://localhost:7080/iframe");
        IframeSwitchPage iframeSwitchPage = new IframeSwitchPage(driver);
        iframeSwitchPage.verifyIframeText();
    }

    @Test(priority = 14)
    public void testMouseHovers(){
        driver.get("http://localhost:7080/hovers");
        MouseHoversPage mouseHoversPage = new MouseHoversPage(driver);
        mouseHoversPage.verifyMousehoberText();
    }


    @Test(priority = 15)
    public void testJSAlerts(){
        driver.get("http://localhost:7080/javascript_alerts");
        JSAlertsPage jsAlertsPage = new JSAlertsPage(driver);
        jsAlertsPage.verifyJSAlertMessages();
    }
    @Test(priority = 16)
    public void testJSErrors(){
        driver.get("http://localhost:7080/javascript_error");
        Object errorTextJS = ((JavascriptExecutor) driver).executeScript("return window.javascript_errors ");
        Assert.assertTrue(errorTextJS.toString().contains("This page has a JavaScript error"), "No java script error on page");
    }

    @Test(priority = 17)
    public void testNewTab(){
        driver.get("http://localhost:7080/windows");
        NewTabPage newTabPage = new NewTabPage(driver);
        newTabPage.verifyNewTabDisplay();
    }

    @Test(priority = 18)
    public void testNotificationMessages(){
        driver.get("http://localhost:7080/notification_message_rendered");
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
        notificationMessagePage.verifyNewTabDisplay();
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
