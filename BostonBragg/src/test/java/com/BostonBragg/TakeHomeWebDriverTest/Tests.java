package com.BostonBragg.TakeHomeWebDriverTest;


import com.BostonBragg.TakeHomeWebDriverTest.pom.*;
import com.BostonBragg.TakeHomeWebDriverTest.utils.DriverUtils;
import com.BostonBragg.TakeHomeWebDriverTest.utils.MiscUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tests {
    WebDriver driver;

    @Test
    public void loginSuccess() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/login");
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();
        assert loginPage.successMessageIsVisible();
    }

    @Test
    public void loginFailure() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/login");
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.enterUsername("foo");
        loginPage.enterPassword("bar");
        loginPage.clickLoginButton();
        assert loginPage.errorMessageIsVisible();
    }

    @Test
    public void checkBoxes() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/checkboxes");
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(this.driver);
        boolean defaultCheckbox1IsChecked = checkBoxesPage.checkbox1IsChecked();
        boolean defaultCheckbox2IsChecked = checkBoxesPage.checkbox2IsChecked();

        checkBoxesPage.clickCheckbox1();
        assert checkBoxesPage.checkbox1IsChecked() != defaultCheckbox1IsChecked;

        checkBoxesPage.clickCheckbox1();
        assert checkBoxesPage.checkbox1IsChecked() == defaultCheckbox1IsChecked;

        checkBoxesPage.clickCheckbox2();
        assert checkBoxesPage.checkbox2IsChecked() != defaultCheckbox2IsChecked;

        checkBoxesPage.clickCheckbox2();
        assert checkBoxesPage.checkbox2IsChecked() == defaultCheckbox2IsChecked;
    }

    @Test
    public void contextMenu() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/context_menu");
        Actions actions = new Actions(this.driver);
        WebElement hotSpot = DriverUtils.findElementWithWait(this.driver, By.id("hot-spot"));
        actions.contextClick(hotSpot).perform();
        Alert alert = DriverUtils.findAlertWithWait(this.driver);
        String alertText = alert.getText().trim();
        assert alertText.equals("You selected a context menu");
        alert.accept();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        DriverUtils.openPage(this.driver, "http://localhost:7080/drag_and_drop");
        WebElement columnA = DriverUtils.findElementWithWait(this.driver, By.id("column-a"));
        WebElement columnB = DriverUtils.findElementWithWait(this.driver, By.id("column-b"));

        //Actions actions = new Actions(this.driver);
        //actions.dragAndDrop(columnA, columnB);
        // the two lines above do not work for dragging and dropping due to an issue with ChromeDriver, so the JS below is a workaround
        final String jsWorkaround =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";
        ((JavascriptExecutor)this.driver).executeScript(jsWorkaround, columnA, columnB);

        String firstColumnText = DriverUtils.findElementWithWait(this.driver, By.xpath("//*[@id=\"column-a\"]/header")).getText();
        assert firstColumnText.equals("B");
    }

    @Test
    public void dropdown() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/dropdown");
        Select select = new Select(DriverUtils.findElementWithWait(this.driver, By.id("dropdown")));
        select.selectByValue("1");
        assert select.getFirstSelectedOption().getText().equals("Option 1");

        select.selectByValue("2");
        assert select.getFirstSelectedOption().getText().equals("Option 2");
    }

    @Test
    public void dynamicContent() {
        ArrayList<String> contentList = new ArrayList<>();
        // since there's more than one element with id "content" on the page, I wrote this xpath to grab the one I want
        String xpath = "//div/div/div[@id=\"content\"]";

        DriverUtils.openPage(this.driver, "http://localhost:7080/dynamic_content");

        int numOfTimesToCheck = 3;
        WebElement contentTable = DriverUtils.findElementWithWait(this.driver, By.xpath(xpath));
        contentList.add(contentTable.getText());

        for(int i = 0; i < numOfTimesToCheck - 1; i++) {
            this.driver.navigate().refresh();
            WebElement contentTableInLoop = DriverUtils.findElementWithWait(this.driver, By.xpath(xpath));
            contentList.add(contentTableInLoop.getText());
        }
        assert !MiscUtils.checkIfAnyElementsInListAreTheSame(contentList);
    }

    @Test
    public void dynamicControls() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/dynamic_controls");
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(this.driver);

        dynamicControlsPage.clickCheckboxButton();
        dynamicControlsPage.waitUntilCheckboxLoadingIsDone();
        assert !dynamicControlsPage.checkIfCheckboxIsPresent();

        dynamicControlsPage.clickCheckboxButton();
        dynamicControlsPage.waitUntilCheckboxLoadingIsDone();
        assert dynamicControlsPage.checkIfCheckboxIsPresent();

        dynamicControlsPage.clickInputButton();
        dynamicControlsPage.waitUntilInputLoadingIsDone();
        assert dynamicControlsPage.checkIfInputIsEnabled();

        dynamicControlsPage.clickInputButton();
        dynamicControlsPage.waitUntilInputLoadingIsDone();
        assert !dynamicControlsPage.checkIfInputIsEnabled();
    }

    @Test
    public void dynamicLoading() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/dynamic_loading/2");
        DriverUtils.findElementWithWait(this.driver, By.xpath("//div[@id=\"start\"]/button")).click();
        WebElement finish = DriverUtils.findElementWithWait(this.driver, By.id("finish"));
        assert finish.findElement(By.tagName("h4")).getText().equals("Hello World!");
    }

    @Test
    public void fileDownload() throws InterruptedException {
        DriverUtils.openPage(this.driver, "http://localhost:7080/download");
        DriverUtils.findElementWithWait(this.driver, By.xpath("//div[@id=\"content\"]/div/a")).click();
        Thread.sleep(3000);
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File file = null;
        for (int i = 0; i < Objects.requireNonNull(listOfFiles).length && !found; i++) {
            File listOfFile = listOfFiles[i];
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches("some-file.txt")) {
                    file = new File(fileName);
                    found = true;
                }
            }
        }
        assert found;
        file.deleteOnExit();
    }

    @Test
    public void fileUpload() throws IOException {
        DriverUtils.openPage(this.driver, "http://localhost:7080/upload");
        File file = new File(System.getProperty("user.dir") + "\\test.txt");
        file.createNewFile();
        DriverUtils.findElementWithWait(this.driver, By.id("file-upload")).sendKeys(file.getPath());
        DriverUtils.findElementWithWait(this.driver, By.id("file-submit")).click();
        assert DriverUtils.findElementWithWait(this.driver, By.xpath("//div[@id=\"content\"]/div/h3")).getText().equals("File Uploaded!");
        assert DriverUtils.findElementWithWait(this.driver, By.id("uploaded-files")).getText().equals(file.getName());
        file.deleteOnExit();
    }

    @Test
    public void floatingMenu() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/floating_menu");
        DriverUtils.findElementWithWait(this.driver, By.id("menu"));
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        assert DriverUtils.findElementWithWait(this.driver, By.id("menu")).isDisplayed();
    }

    @Test
    public void iframe() {
        String textToType = "This is a test using Selenium";

        DriverUtils.openPage(this.driver, "http://localhost:7080/iframe");
        try {
            DriverUtils.findElementWithWait(this.driver, By.xpath("//div[@role=\"alert\"]/button")).click();
        } catch(NoSuchElementException | TimeoutException ignored) {}

        WebElement iframe = DriverUtils.findElementWithWait(this.driver, By.id("mce_0_ifr"));
        this.driver.switchTo().frame(iframe);
        WebElement textArea = DriverUtils.findElementWithWait(this.driver, By.id("tinymce"));
        textArea.clear();
        textArea.sendKeys(textToType);
        assert textArea.findElement(By.tagName("p")).getText().equals(textToType);
    }

    @Test
    public void mouseHover() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/hovers");
        MouseHoversPage mouseHoversPage = new MouseHoversPage(this.driver);
        for(int i = 1; i <= 3; i++) {
            mouseHoversPage.hoverOverImage(i);
            assert mouseHoversPage.addInfoIsVisible(i);
        }
    }

    @Test
    public void javaScriptAlerts() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/javascript_alerts");
        JavaScriptAlertsPage page = new JavaScriptAlertsPage(this.driver);
        Alert alert;

        page.clickButton("alert");
        alert = DriverUtils.findAlertWithWait(this.driver);
        assert alert.getText().trim().equals("I am a JS Alert");
        alert.accept();

        page.clickButton("confirm");
        alert = DriverUtils.findAlertWithWait(this.driver);
        assert alert.getText().trim().equals("I am a JS Confirm");
        alert.accept();

        String message = "This is a Selenium test";
        page.clickButton("prompt");
        alert = DriverUtils.findAlertWithWait(this.driver);
        alert.sendKeys(message);
        alert.accept();
        assert DriverUtils.findElementWithWait(this.driver, By.id("result")).getText().contains(message);
    }

    @Test
    public void javaScriptError() {
        boolean errorFound = false;
        String errorToFind = "Cannot read properties of undefined";
        DriverUtils.openPage(this.driver, "http://localhost:7080/javascript_error");
        LogEntries logEntries = this.driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> log = logEntries.getAll();
        for(LogEntry logEntry : log) {
            if(logEntry.toString().contains(errorToFind)) {
                errorFound = true;
            }
        }
        assert errorFound;
    }

    @Test
    public void openInNewTab() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/windows");
        DriverUtils.findElementWithWait(this.driver, By.xpath("//*[@id=\"content\"]/div/a")).click();
        List<String> browserTabs = new ArrayList<>(this.driver.getWindowHandles());
        this.driver.switchTo().window(browserTabs.get(1));
        assert this.driver.getTitle().trim().contains("New Window");
    }

    @Test
    public void notificationMessages() {
        DriverUtils.openPage(this.driver, "http://localhost:7080/notification_message_rendered");
        for(int i = 0; i < 5; i++) {
            DriverUtils.findElementWithWait(this.driver, By.xpath("//*[@id=\"content\"]/div/p/a")).click();
        }
        ArrayList<String> possibleMessages = new ArrayList<>();
        possibleMessages.add("action successful");
        possibleMessages.add("action unsuccesful");
        possibleMessages.add("action unsuccessful");
        boolean messagesIsCorrect = false;
        String actualText = DriverUtils.findElementWithWait(this.driver, By.id("flash")).getText().toLowerCase();

        for(String message : possibleMessages) {
            if (actualText.contains(message)) {
                messagesIsCorrect = true;
                break;
            }
        }
        assert messagesIsCorrect;
    }

    @BeforeEach
    public void startup() throws Exception {
        this.driver = DriverUtils.initializeDriver();
    }

    @AfterEach
    public void teardown() {
        DriverUtils.teardownDriver(this.driver);
    }
}
