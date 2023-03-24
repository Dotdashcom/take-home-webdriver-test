package org.example;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // just to keep alphabetical execution order
public class SpecificRubricsTests {

    private static WebDriver driver;
    String BASE_URL = "http://localhost:7080";

    @Before
    public void setup() {
        // to work on both Windows and Unix-based hosts
        if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
        }

        // to avoid "Java.io.IOException: Invalid Status code=403 text=Forbidden". The fix is taken from post
        // https://stackoverflow.com/questions/75678572/java-io-ioexception-invalid-status-code-403-text-forbidden/75679117#75679117
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
    }

    @Test
    public void t01_loginPage_enterValidCredentials() {
        driver.get(BASE_URL + "/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("tomsmith", "SuperSecretPassword!");
        assertTrue(loginPage.isLoggedIn());
    }

    @Test
    public void t02_loginPage_enterInvalidCredentials() {
        driver.get(BASE_URL + "/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalidUser", "invalidPassword");
        Assert.assertEquals("Your username is invalid!\n×", loginPage.getErrorMessage());

        loginPage.login("tomsmith", "invalidPassword");
        Assert.assertEquals("Your password is invalid!\n×", loginPage.getErrorMessage());
    }

    @Test
    public void t03_checkboxes_CheckAndUncheck() {
        driver.get(BASE_URL + "/checkboxes");

        By checkboxesLocator = By.xpath("//form[@id='checkboxes']/input");
        WebElement checkbox1 = driver.findElements(checkboxesLocator).get(0);
        SelectCheckBox(checkbox1, true);
        assertTrue(checkbox1.isSelected());
        SelectCheckBox(checkbox1, false);
        assertFalse(checkbox1.isSelected());

        WebElement checkbox2 = driver.findElements(checkboxesLocator).get(1);
        SelectCheckBox(checkbox2, true);
        assertTrue(checkbox2.isSelected());
        SelectCheckBox(checkbox2, false);
        assertFalse(checkbox2.isSelected());
    }

    @Test
    public void t04_contextMenu_rightClick() {
        driver.get(BASE_URL + "/context_menu");
        Actions actions = new Actions(driver);
        WebElement contextMenuArea = driver.findElement(By.id("hot-spot"));
        actions.contextClick(contextMenuArea).perform();
        assertEquals("You selected a context menu", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void t05_dragAndDrop_switchElements() {
        driver.get(BASE_URL + "/drag_and_drop");
        WebElement elementFrom = driver.findElement(By.id("column-a"));
        WebElement elementTo = driver.findElement(By.id("column-b"));

        // as regular Selenium's actions.dragAndDrop() still does not work with webdriver in Chrome - let's use
        // JavaScript for drag and drop. The JS code is taken from https://stackoverflow.com/a/53930565
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", elementFrom, elementTo);

        assertTrue(elementFrom.getText().equals("B") && elementTo.getText().equals("A"));
    }

    @Test
    public void t06_Dropdown_selectOptions() {
        driver.get(BASE_URL + "/dropdown");
        String option1Text = "Option 1";
        String option2Text = "Option 2";

        Select dropdownList = new Select(driver.findElement(By.id("dropdown")));

        dropdownList.selectByVisibleText(option1Text);
        assertEquals(option1Text, dropdownList.getFirstSelectedOption().getText());

        dropdownList.selectByVisibleText(option2Text);
        assertEquals(option2Text, dropdownList.getFirstSelectedOption().getText());
    }

    @Test
    public void t07_DynamicContent_contentRefresh() {
        driver.get(BASE_URL + "/dynamic_content");

        // Assumption: as avatar icons not always changed after page refresh - it will be excluded it from comparison,
        // so only text change (for each row) will be checked
        for (int i = 1; i <= 4; i++) {
            List<String> beforeRefreshList = getRowTextList(driver);
            driver.navigate().refresh();
            List<String> afterRefreshList = getRowTextList(driver);
            for (int j = 0; j < beforeRefreshList.size(); j++) {
                assertNotEquals(beforeRefreshList.get(j), afterRefreshList.get(j));
            }
        }
    }

    @Test
    public void t08_dynamicControls_addRemoveEnableDisable() {
        driver.get(BASE_URL + "/dynamic_controls");

        By checkboxSelector = By.xpath("//*[@id='checkbox']");

        driver.findElement(getLocatorByButtonText("Remove")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfElementsToBe(checkboxSelector, 0));
        assertEquals(0, driver.findElements(checkboxSelector).size());

        driver.findElement(getLocatorByButtonText("Add")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfElementsToBe(checkboxSelector, 1));
        assertEquals(1, driver.findElements(checkboxSelector).size());

        By textBoxSelector = By.xpath("//*[@id='input-example']/input");

        driver.findElement(getLocatorByButtonText("Enable")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(textBoxSelector));
        assertTrue(driver.findElement(textBoxSelector).isEnabled());

        driver.findElement(By.xpath("//*[@id='input-example']/button[text()='Disable']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(textBoxSelector), "disabled"));
        assertFalse(driver.findElement(textBoxSelector).isEnabled());
    }

    @Test
    public void t09_dynamicLoading_elementRenderedAfterAWhile() {
        driver.get(BASE_URL + "/dynamic_loading/2");
        driver.findElement(getLocatorByButtonText("Start")).click();

        By finiTextLocator = By.id("finish");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(finiTextLocator));
        assertEquals("Hello World!", driver.findElement(finiTextLocator).getText());
    }

    @Test
    public void t10_fileUpload_uploadLocalFile() throws IOException {
        driver.get(BASE_URL + "/upload");

        // create a temp file
        String toWrite = "it is just a test file";
        File tmpFile = File.createTempFile("testFileToUpload_", ".tmp");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(toWrite);
        writer.close();

        driver.findElement(By.id("file-upload")).sendKeys(tmpFile.getPath());
        driver.findElement(By.id("file-submit")).click();
        assertEquals("File Uploaded!", driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText());
        assertEquals(tmpFile.getName(), driver.findElement(By.id("uploaded-files")).getText());
    }

    @Test
    public void t11_fileDownload_downloadFile() throws InterruptedException {
        // assumptions:
        // 1) the web browser has default profile, where after clicking on a filename to download - the file
        // just downloaded to a default dir (i.e. no system dialog to choose a dir to save file etc. appears)
        // 2) after downloading, only file presence on disk is checked. File content check is out of the test scope

        driver.get(BASE_URL + "/download");
        By fileSelector = By.xpath("//a[@href='download/some-file.txt']");
        String fileNameToDownload = driver.findElement(fileSelector).getText();

        // to allow run test several times and prevent creation of file with suffix(like "some-file (1).txt"),
        // the existing file(if any) will be deleted
        String home = System.getProperty("user.home");
        File file = Paths.get(home, "Downloads", fileNameToDownload).toFile();
        file.delete();

        driver.findElement(fileSelector).click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(fileExists(file));
        assertTrue(file.exists());
    }

    @Test
    public void t12_floatingMenu_checkMenuVisibilityAfterScrolling() {
        driver.get(BASE_URL + "/floating_menu");
        assertTrue(driver.findElement(By.id("menu")).isDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)"); // scroll to the middle of the page
        assertTrue(driver.findElement(By.id("menu")).isDisplayed());

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // scroll to the bottom of the page
        assertTrue(driver.findElement(By.id("menu")).isDisplayed());
    }

    @Test
    public void t13_iframe_enterTextToIFrame() throws InterruptedException {
        driver.get(BASE_URL + "/iframe");
        String textToEnter = "12345678QWERTY";

        By textField = By.id("tinymce");

        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(textField).sendKeys(textToEnter);
        assertTrue(driver.findElement(textField).getText().contains(textToEnter));
    }

    @Test
    public void t14_mouseHover_checkElementsCaptions() {
        driver.get(BASE_URL + "/hovers");
        Actions actions = new Actions(driver);
        List<WebElement> imageList = driver.findElements(By.xpath("//*[@class='figure']"));
        for (WebElement image : imageList) {
            actions.moveToElement(image).perform();
            WebElement additionalInfo = image.findElement(By.xpath("*[@class='figcaption']"));
            assertTrue(additionalInfo.isDisplayed());
            assertTrue(additionalInfo.getText().length() > 0);
        }
    }

    @Test
    public void t15_javaScriptAlerts_checkAlerts() {
        driver.get(BASE_URL + "/javascript_alerts");

        driver.findElement(getLocatorByButtonText("Click for JS Alert")).click();
        assertEquals("I am a JS Alert", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(getLocatorByButtonText("Click for JS Confirm")).click();
        assertEquals("I am a JS Confirm", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(getLocatorByButtonText("Click for JS Prompt")).click();
        String textToEnter = "a text to enter";
        driver.switchTo().alert().sendKeys(textToEnter);
        driver.switchTo().alert().accept();
        assertTrue(driver.findElement(By.id("result")).getText().contains(textToEnter));
    }

    @Test
    public void t16_javaScriptError_checkJSErrors() {
        driver.get(BASE_URL + "/javascript_error");
        assertTrue(driver.findElement(By.xpath("//body[@onload='loadError()']")).getText().contains("JavaScript error"));
        assertTrue(driver.manage().logs().get(LogType.BROWSER).getAll().toString().contains("TypeError: Cannot read properties of undefined (reading 'xyz')"));
    }

    @Test
    public void t17_openInNewTab_checkNewTab() {
        driver.get(BASE_URL + "/windows");
        driver.findElement(getLocatorByLinkText("Click Here")).click();

        // get tab list and switch to the second tab
        List<String> tabList = new ArrayList<String>(driver.getWindowHandles());
        assertEquals("New tab was not opened:", 2, tabList.size());
        driver.switchTo().window(tabList.get(1));
        assertEquals("New Window", driver.findElement(By.xpath("//body")).getText());
    }

    @Test
    public void t18_notificationMessage_checkMessagesMatch() {
        driver.get(BASE_URL + "/notification_message_rendered");

        List<String> expectedMessages = Arrays.asList("Action Successful", "Action unsuccessful, please try again", "Action Unsuccessful");
        int maxAttempts = 15;
        for (int i = 1; i <= maxAttempts; i++) {
            driver.findElement(getLocatorByLinkText("Click here")).click();
            String currentMessage = driver.findElement(By.id("flash-messages")).getText().replace("\n×", "");
            if (!expectedMessages.contains(currentMessage)) {
                fail("Attempt #" + i + " of " + maxAttempts + ": Shown message '" + currentMessage +
                        "' does not match to one of expected messages: " + expectedMessages);
            }
        }
    }

    private void SelectCheckBox(WebElement checkBox, Boolean isSelected) {
        if (isSelected && !checkBox.isSelected()) {
            checkBox.click();
        } else if (!isSelected && checkBox.isSelected()) {
            checkBox.click();
        }
    }

    private List<String> getRowTextList(WebDriver driver) {
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='content']/div[@class='row']"));
        List<String> rowTextList = new ArrayList<>();
        for (WebElement textRow : rows) {
            rowTextList.add(textRow.getText());
        }
        return rowTextList;
    }

    private ExpectedCondition<Boolean> fileExists(File file) {
        return new ExpectedCondition<>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return file.exists();
            }
        };
    }

    private By getLocatorByButtonText(String text) {
        return By.xpath(String.format("//button[text()= '%s']", text));
    }

    private By getLocatorByLinkText(String text) {
        return By.xpath(String.format("//*[@href][text()= '%s']", text));
    }

    @After
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
