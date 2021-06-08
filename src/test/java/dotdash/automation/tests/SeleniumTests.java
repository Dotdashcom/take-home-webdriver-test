package dotdash.automation.tests;

import dotdash.automation.helpers.ConfigReader;
//import dotdash.automation.data.ContextObject;
import dotdash.automation.pageobjects.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTests {
    SecurePageObject securePageObject;
    WebDriver driver;

    @BeforeEach
    public void setup() {
        String driverType = System.getProperty("os.name").startsWith("Windiows")? "chromedriver.exe" : "chromedriver";
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/"+driverType);
        this.driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public void navigateTo(String url) {
        driver.navigate().to(new ConfigReader().getBaseUri() + url);
    }

    @Test
    public void loginSuccess() {
        String url = "/login";
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        navigateTo(url);
        securePageObject = new LoginPageObject(driver)
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        assertEquals("Welcome to the Secure Area. When you are done click logout below.", securePageObject.getSubHeader());
    }

    @Test
    public void loginFailure() {
        String url = "/login";
        String username = "user";
        String password = "password";
        navigateTo(url);
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.enterUsername(username)
                .enterPassword(password)
                .clickLogin();
        assertTrue(loginPageObject.getFlashMessage().contains("Your username is invalid!"));
    }

    @Test
    public void checkBox() {
        String url = "/checkboxes ";
        navigateTo(url);
        CheckBoxPageObject pageObject = new CheckBoxPageObject(driver);
        assertTrue(pageObject.clickBox1().isBox1Selected());
        assertFalse(pageObject.clickBox1().isBox1Selected());
        assertFalse(pageObject.clickBox2().isBox2Selected());
        assertTrue(pageObject.clickBox2().isBox2Selected());
    }

    @Test
    public void contextCheck() {
        String url = "/context_menu";
        navigateTo(url);
        assertEquals("You selected a context menu", new ContextCheckPageObject(driver).rightClickContext().getAlertText());
    }

    /**
     * Drag A to B
     */
    @Test
    public void dragNDropAtoB() throws InterruptedException {
        String url = "/drag_and_drop";
        navigateTo(url);
        DragNDropPageObject pageObject = new DragNDropPageObject(driver);
        String colAText = pageObject.getColAText();
        String colBText = pageObject.getColBText();
        pageObject.dragAtoB();
        String colATextAfterDrag = pageObject.getColAText();
        String colBTextAfterDrag = pageObject.getColBText();
        assertEquals(colAText, colBTextAfterDrag);
        assertEquals(colBText, colATextAfterDrag);
    }

    /**
     * Drag B to A
     */
    @Test
    void dragNDropBtoA() {
        String url = "/drag_and_drop";
        navigateTo(url);
        DragNDropPageObject pageObject = new DragNDropPageObject(driver);
        String colAText = pageObject.getColAText();
        String colBText = pageObject.getColBText();
        pageObject.dragBtoA();
        String colATextAfterDrag = pageObject.getColAText();
        String colBTextAfterDrag = pageObject.getColBText();
        assertEquals(colAText, colBTextAfterDrag);
        assertEquals(colBText, colATextAfterDrag);
    }

    @Test
    void dropDown() {
        String url = "/dropdown";
        navigateTo(url);
        DropDownPageObject pageObject = new DropDownPageObject(driver);
        pageObject.selectDropDown1();
        assertEquals(pageObject.option1Text(), pageObject.selectDropDown1());
        assertEquals(pageObject.option2Text(), pageObject.selectDropDown2());

    }

    @Test
    void dynamicContent() {
        String url = "/dynamic_content";
        navigateTo(url);
        DynamicContentPageObject pageObject = new DynamicContentPageObject(driver);
        int size = pageObject.listSize();
        List<String> firstList = pageObject.getDynamicText();
        pageObject.refreshPage();
        List<String> secondList = pageObject.getDynamicText();
        for (int i = 0; i < size; i++) {
            assertNotEquals(firstList.get(i), secondList.get(i), ": CONTENT IS NOT CHANGED");
        }
    }

    @Test
    void dynamicConrols() {
        String url = "/dynamic_controls";
        navigateTo(url);
        DynamicControlsPageObject pageObject = new DynamicControlsPageObject(driver);
        /**
         * remove checkBox
         */
        pageObject.clickRem();
        assertFalse(pageObject.isCheckBoxPresent());
        /**
         * Add Checkbox
         */
        pageObject.clickAdd();
        assertTrue(pageObject.isCheckBoxPresent());
        /**
         * Enable input
         */
        pageObject.clickEnable();
        assertTrue(pageObject.isInputEnabled());
        /**
         * Disable input
         */
        pageObject.clickDisable();
        assertFalse(pageObject.isInputEnabled());
    }

    @Test
    public void dynamicLoading() {
        String url = "/dynamic_loading/2";
        navigateTo(url);
        DynamicLoadingPageObject pageObject = new DynamicLoadingPageObject(driver);
        pageObject.clickStart();
        assertTrue(pageObject.isHelloDisplayed());
    }

    @Test
    public void downloadFile() throws IOException, InterruptedException, TimeoutException {
        String url = "/download";
        navigateTo(url);
        DownloadFilePageObject pageObject = new DownloadFilePageObject(driver);
        pageObject.downloadFile();
        pageObject.until(pageObject::isFileDownloaded);
        boolean b = pageObject.isFileDownloaded();
        assertTrue(b);
        pageObject.deleteTheFile();
    }

    @Test
    public void uploadFile() {
        String url = "/upload";
        navigateTo(url);
        UplaodFilePageObject pageObject = new UplaodFilePageObject(driver);
        pageObject.chooseFile().upload();
        assertEquals("sample-upload.txt", pageObject.getSuccessMessage());
    }

    @Test
    public void floatingMenu() {
        String url = "/floating_menu";
        navigateTo(url);
        FloatingPageObjects pageObject = new FloatingPageObjects(driver);
        pageObject.scrollDown();
        assertTrue(pageObject.isMenuVisible());
        pageObject.scrollUp();
        assertTrue(pageObject.isMenuVisible());
    }

    @Test
    public void iframe() {
        String url = "/iframe";
        navigateTo(url);
        String text = "Some Text";
        IFramePageObject pageObject = new IFramePageObject(driver);
        pageObject.enterText(text);
        assertEquals(text, pageObject.getBodyText());
    }

    @Test
    public void mouseHover() {
        String url = "/hovers";
        navigateTo(url);
        MouseHoverPageObject pageObject = new MouseHoverPageObject(driver);
        for (int i = 0; i < pageObject.noOfAvatars(); i++) {
            pageObject.mouseHover(pageObject.getAvatars().get(i));
            assertTrue(pageObject.getNames().get(i).isDisplayed());
            assertTrue(pageObject.getProfiles().get(i).isDisplayed());
        }
    }

    @Test
    public void javaScriptAlerts() {
        String url = "/javascript_alerts";
        navigateTo(url);
        JSAlertsPageObject pageObject = new JSAlertsPageObject(driver);
        /**
         * JS Alert
         */
       // pageObject.clickAlert();
        assertEquals("I am a JS Alert", pageObject.clickAlert().getAlertText());
        pageObject.acceptAlert();
        assertEquals("You successfuly clicked an alert", pageObject.getResultText());
        /**
         * JS Confirm
         */
        assertEquals("I am a JS Confirm", pageObject.clickConfirm().getAlertText());
        pageObject.acceptAlert();
        assertEquals("You clicked: Ok", pageObject.getResultText());
        /**
         * JS Prompt
         */
        assertEquals("I am a JS prompt", pageObject.clickPrompt().getAlertText());
        String enterAlertText = "Entered Text in Alert";
        pageObject.enterTextToAlert(enterAlertText);
        pageObject.acceptAlert();
        assertEquals("You entered: " + enterAlertText, pageObject.getResultText());
    }

    @Test
    public void jsError() {
        String url = "/javascript_error";
        navigateTo(url);
        JSErrorPageObject pageObject = new JSErrorPageObject(driver);
        assertTrue(pageObject.getErrList().toString().contains("Cannot read property 'xyz' of undefined"));
    }

    @Test
    public void newWindow() {
        String url = "/windows";
        navigateTo(url);
        WindowsPageObject pageObject = new WindowsPageObject(driver);
        NewWindowPageObject newWindowPageObject = pageObject.clickHere();
        assertEquals("New Window", newWindowPageObject.getText());
    }

    @Test
    public void notification() {
        String url = "/notification_message_rendered";
        navigateTo(url);
        NotificationMessagePageObject pageObject = new NotificationMessagePageObject(driver);
        List<String> messList = Arrays.asList("Action successful", "Action unsuccesful, please try again", "Action Unsuccessful");
        for (int mtimes = 5; mtimes > 0; mtimes--) {
            pageObject.clickHere();
            String flash = pageObject.clickHere().getMessage();
            String closeMess = pageObject.clickHere().getClosetext();
            String message = flash.replace(closeMess, "").trim();
            assertTrue(messList.stream().anyMatch(s -> s.equalsIgnoreCase(message)));
        }
    }
}
