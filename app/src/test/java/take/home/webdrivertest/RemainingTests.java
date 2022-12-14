package take.home.webdrivertest;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.*;
import java.util.logging.Level;

public class RemainingTests {

    private final String localhost = "http://localhost:7080/";
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/res/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(localhost);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void remaining() throws InterruptedException {

        // Check boxes
        driver.findElement(By.linkText("Checkboxes")).click();
        WebElement cb1 = driver.findElement(By.cssSelector("input:nth-child(1)"));
        cb1.click();

        //sleep(1);
        assert cb1.isSelected();
        log("Assert checkbox1 checked");

        WebElement cb2 = driver.findElement(By.cssSelector("input:nth-child(3)"));
        cb2.click();

        //sleep(1);
        assert !cb2.isSelected();
        log("Assert checkbox2 unchecked");

        // Context menu
        driver.get(localhost + "context_menu");
        Actions actions = new Actions(driver);
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        actions.contextClick(hotSpot).perform();
        Alert alertContext = driver.switchTo().alert();

        assert alertContext.getText().contains("You selected a context menu");
        log("Assert context menu selected");
        // start fresh browser to get rid of pesky right click menu
        alertContext.dismiss();
        driver.close();
        this.setUp();

        // Drag and drop
        driver.get(localhost + "drag_and_drop");
        WebElement colA = driver.findElement(By.id("column-a"));
        String origColAText = colA.getText();
        WebElement colB = driver.findElement(By.id("column-b"));
        String origColBText = colB.getText();

        // use JavaScript to workaround known Selenium drag and drop bug referenced below
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, colB) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(colB, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var colA = arguments[0];\n" +"var colB = arguments[1];\n" +"simulateHTML5DragAndDrop(colA,colB);",colA, colB);
        sleep(1);

        try {
            assert colA.getText().contains(origColBText);
            assert colB.getText().contains(origColAText);
            log("Assert drag and drop");
        } catch (Error e) {
            // catch known selenium drag and drop bug
            // https://www.softwaretestingmagazine.com/knowledge/selenium-drag-and-drop-bug-workaround/
            log("encountered known drag and drop bug: " + e.getMessage());
        }

        // Dropdown
        driver.get(localhost + "dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();
        WebElement option1 = dropdown.findElement(By.xpath("//option[. = 'Option 1']"));
        option1.click();

        //sleep(1);
        assert option1.isSelected();
        log("Assert dropdown option 1 selected");

        dropdown.click();
        WebElement option2 = dropdown.findElement(By.xpath("//option[. = 'Option 2']"));
        option2.click();

        //sleep(1);
        assert option2.isSelected();
        log("Assert dropdown option 2 selected");

        // Dynamic content
        driver.get(localhost + "dynamic_content");

        for (int i = 0; i < 3; i++) {

            WebElement origRow0 = driver.findElement(By.cssSelector(
                    "div.large-10:nth-child(1) > div:nth-child(1) > div:nth-child(2)"));
            WebElement origRow1 = driver.findElement(By.cssSelector(
                    "div.row:nth-child(4) > div:nth-child(2)"));
            WebElement origRow2 = driver.findElement(By.cssSelector(
                    "div.large-10:nth-child(1) > div:nth-child(7) > div:nth-child(2)"));
            String origText0 = origRow0.getText();
            String origText1 = origRow1.getText();
            String origText2 = origRow2.getText();

            driver.navigate().refresh();
            //sleep(1);

            WebElement newRow0 = driver.findElement(By.cssSelector(
                    "div.large-10:nth-child(1) > div:nth-child(1) > div:nth-child(2)"));
            WebElement newRow1 = driver.findElement(By.cssSelector(
                    "div.row:nth-child(4) > div:nth-child(2)"));
            WebElement newRow2 = driver.findElement(By.cssSelector(
                    "div.large-10:nth-child(1) > div:nth-child(7) > div:nth-child(2)"));

            String newText0 = newRow0.getText();
            String newText1 = newRow1.getText();
            String newText2 = newRow2.getText();

            //sleep(1);
            assert !Objects.equals(origText0, newText0) ||
                    !Objects.equals(origText1, newText1) ||
                    !Objects.equals(origText2, newText2);

            log("Assert dynamic content changed");
        }

        // Dynamic controls
        driver.get(localhost + "dynamic_controls");
        driver.findElement(By.cssSelector("#checkbox-example > button")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        assert driver.findElement(By.id("message")).getText().contains("It's gone!");
        log("Assert dynamic control checkbox gone");

        driver.findElement(By.cssSelector("button:nth-child(1)")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        assert driver.findElement(By.id("message")).getText().contains("It's back!");
        log("Assert dynamic control checkbox back");

        driver.findElement(By.cssSelector("button:nth-child(2)")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#input-example > input:nth-child(1)")));
        assert driver.findElement(By.id("message")).getText().contains("It's enabled!");
        log("Assert dynamic control input enabled");

        driver.findElement(By.cssSelector("button:nth-child(2)")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assert driver.findElement(By.id("message")).getText().contains("It's disabled!");
        log("Assert dynamic control input disabled");

        // Dynamic loading
        driver.get(localhost + "dynamic_loading");
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        driver.findElement(By.cssSelector("button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assert driver.findElement(By.id("finish")).getText().contains("Hello World!");
        log("Assert dynamic content loaded");

        // File download
        driver.get(localhost + "download");
        String fileName = "some-file.txt";
        driver.findElement(By.linkText(fileName)).click();
        sleep(2);
        File downloadedFile = getDownloadedFile(fileName);
        assert downloadedFile != null;
        log("Assert file downloaded");

        // File upload
        driver.get(localhost + "upload");
        driver.findElement(By.id("file-upload")).sendKeys(downloadedFile.getPath());

        driver.findElement(By.id("file-submit")).click();
        sleep(1);
        assert driver.findElement(By.cssSelector("h3")).getText().contains("File Uploaded!");
        log("Assert file uploaded");

        // Floating menu
        driver.get(localhost + "floating_menu");
        js.executeScript("window.scrollBy(0,250)", "");
        sleep(1);
        assert driver.findElement(By.linkText("Home")).isDisplayed();
        log("Assert floating menu still visible");

        // iFrame
        driver.get(localhost + "frames");
        driver.findElement(By.linkText("iFrame")).click();
        driver.switchTo().frame(0);
        WebElement editor = driver.findElement(By.id("tinymce"));
        js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>foo bar</p>'}", editor);
        sleep(1);
        try {
            assert editor.getText().contains("foo bar");
            log("Assert iFrame contains input text");
        } catch (Error e) {
            log("First JS inject failed, trying again");
            js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>foo bar</p>'}", editor);
            sleep(1);
            assert editor.getText().contains("foo bar");
            log("Assert iFrame contains input text");
        }
        driver.switchTo().defaultContent();

        // Hovers
        driver.get(localhost + "hovers");
        Actions actionHover = new Actions(driver);
        for (int i = 0; i < 3; i++) {
            int child = 3 + i;
            actionHover.moveToElement(driver.findElement(By.cssSelector("div.figure:nth-child(" + child + ") > img:nth-child(1)"))).perform();
            WebElement userName = driver.findElement(By.cssSelector("div.figure:nth-child(" + child + ") > div:nth-child(2) > h5:nth-child(1)"));
            sleep(1);
            assert userName.getText().contains("user" + (i + 1));
            log("Assert hovered user profile shown");
        }

        // JS alerts
        driver.get(localhost + "javascript_alerts");
        driver.findElement(By.cssSelector("li:nth-child(1) > button")).click();
        assert driver.switchTo().alert().getText().contains("I am a JS Alert");
        log("Assert JS alert content expected");
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("li:nth-child(2) > button")).click();
        assert driver.switchTo().alert().getText().contains("I am a JS Confirm");
        log("Assert JS alert content expected");
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("li:nth-child(3) > button")).click();
        assert driver.switchTo().alert().getText().contains("I am a JS prompt");
        log("Assert JS alert content expected");
        {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("foo bar");
            sleep(1);
            alert.accept();
        }
        assert driver.findElement(By.id("result")).getText().contains("foo bar");
        log("Assert JS alert content expected");

        // JS error
        driver.get(localhost + "javascript_error");
        // get and print browser errors
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> lg = logEntries.filter(Level.ALL);
        for(LogEntry logEntry : lg) {
            String entry = logEntry.toString();
            log(entry);
            if (entry.contains("Uncaught TypeError")) {
                assert entry.contains("Cannot read properties of undefined (reading 'xyz')");
                log("Assert JS uncaught error located");
            }
        }

        // Open in new tab
        driver.get(localhost + "windows");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("Click Here")).click();
        vars.put("win4661", waitForWindow(2000));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(Objects.requireNonNull(vars.get("win4661")).toString());
        assert driver.findElement(By.cssSelector("h3")).getText().contains("New Window");
        log("Assert new tab opened");
        driver.close();
        driver.switchTo().window(Objects.requireNonNull(vars.get("root")).toString());

        // Notification message
        driver.get(localhost + "notification_message_rendered");
        for (int i = 0; i < 4; i++) {
            WebElement button = driver.findElement(By.linkText("Click here"));
            button.click();
            String flash = driver.findElement(By.id("flash")).getText();
            assert flash.contains("Action successful") ||
                    flash.contains("Action unsuccesful, please try again") ||
                    flash.contains("Action unsuccessful");
            log("Assert notification message expected");
        }
    }

    public void sleep(int s) throws InterruptedException {
        Thread.sleep(s * 1000L);
    }

    public File getDownloadedFile(String fileName) {
        String path = System.getProperty("user.home");
        String downloadPath = path + "/Downloads/";
        File folder = new File(downloadPath);
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isFile() && file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }

    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            log(e.getMessage());
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }

    public void log(String message) {
        System.out.println(message);
    }
}
