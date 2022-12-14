package take.home.webdrivertest;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import android.widget.CheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.io.File;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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

        WebElement cb2 = driver.findElement(By.cssSelector("input:nth-child(3)"));
        cb2.click();

        //sleep(1);
        assert !cb2.isSelected();

        // Context menu
        driver.get(localhost + "context_menu");
        Actions actions = new Actions(driver);
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        actions.contextClick(hotSpot).perform();
        Alert alertContext = driver.switchTo().alert();

        //sleep(1);
        assert alertContext.getText().contains("You selected a context menu");

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        alertContext.dismiss();

        // Drag and drop
        driver.get(localhost + "drag_and_drop");
        WebElement colA = driver.findElement(By.id("column-a"));
        String origColAText = colA.getText();
        WebElement colB = driver.findElement(By.id("column-b"));
        String origColBText = colB.getText();
        Actions builder = new Actions(driver);
        builder.dragAndDrop(colA, colB).perform();

        //sleep(1);
        // TODO hangs until mouse moved into selenium and doesn't perform d+d?
        //assert colA.getText().contains(origColBText);
        //assert colB.getText().contains(origColAText);

        // Dropdown
        driver.get(localhost + "dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();
        WebElement option1 = dropdown.findElement(By.xpath("//option[. = 'Option 1']"));
        option1.click();

        //sleep(1);
        assert option1.isSelected();

        dropdown.click();
        WebElement option2 = dropdown.findElement(By.xpath("//option[. = 'Option 2']"));
        option2.click();

        //sleep(1);
        assert option2.isSelected();

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
        }

        // Dynamic controls
        driver.get(localhost + "dynamic_controls");
        driver.findElement(By.cssSelector("#checkbox-example > button")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        assert driver.findElement(By.id("message")).getText().contains("It's gone!");

        driver.findElement(By.cssSelector("button:nth-child(1)")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        assert driver.findElement(By.id("message")).getText().contains("It's back!");

        driver.findElement(By.cssSelector("button:nth-child(2)")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#input-example > input:nth-child(1)")));
        assert driver.findElement(By.id("message")).getText().contains("It's enabled!");

        driver.findElement(By.cssSelector("button:nth-child(2)")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assert driver.findElement(By.id("message")).getText().contains("It's disabled!");

        // Dynamic loading
        driver.get(localhost + "dynamic_loading");
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        driver.findElement(By.cssSelector("button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assert driver.findElement(By.id("finish")).getText().contains("Hello World!");

        // File download
        driver.get(localhost + "download");
        String fileName = "some-file.txt";
        driver.findElement(By.linkText(fileName)).click();
        sleep(2);
        File downloadedFile = getDownloadedFile(fileName);
        assert downloadedFile != null;

        // File upload
        driver.get(localhost + "upload");
        // TODO not finding file-upload button?
        driver.findElement(By.id("file-upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys(downloadedFile.getName());

        sleep(2);
        driver.findElement(By.id("file-submit")).click();
        assert driver.findElement(By.cssSelector("h3")).getText().contains("File Uploaded!");

        // Floating menu TODO
        driver.get(localhost + "floating_menu");
        driver.findElement(By.linkText("Home")).click();

        // iFrame TODO
        driver.get(localhost + "frames");
        driver.findElement(By.linkText("iFrame")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("html")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".tox-notification__dismiss path")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("p")).click();
        {
            WebElement element = driver.findElement(By.id("tinymce"));
            js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>foo bar</p>'}", element);
        }
        driver.findElement(By.cssSelector("html")).click();
        driver.switchTo().defaultContent();

        // Hovers TODO
        driver.get(localhost + "hovers");
        driver.findElement(By.linkText("View profile")).click();
        driver.findElement(By.linkText("View profile")).click();
        driver.findElement(By.linkText("View profile")).click();

        // JS alerts TODO
        driver.get(localhost + "javascript_alerts");
        driver.findElement(By.cssSelector("li:nth-child(1) > button")).click();
        assert driver.switchTo().alert().getText().contains("I am a JS Alert");
        driver.findElement(By.cssSelector("li:nth-child(2) > button")).click();
        assert driver.switchTo().alert().getText().contains("I am a JS Confirm");
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("li:nth-child(3) > button")).click();
        assert driver.switchTo().alert().getText().contains("I am a JS prompt");
        {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("foo bar");
            alert.accept();
        }
        driver.findElement(By.id("result")).click();

        // JS error TODO
        driver.get(localhost + "javascript_error");
        driver.findElement(By.cssSelector("p")).click();

        // Open in new tab TODO
        driver.get(localhost + "windows");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("Click Here")).click();
        vars.put("win4661", waitForWindow(2000));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win4661").toString());
        driver.findElement(By.cssSelector("h3")).click();
        driver.close();
        driver.switchTo().window(vars.get("root").toString());

        // Notification message TODO
        driver.get(localhost + "notification_message_rendered");
        driver.findElement(By.linkText("Click here")).click();
        driver.findElement(By.linkText("Click here")).click();
        driver.findElement(By.id("flash")).click();
        driver.findElement(By.linkText("Click here")).click();
        driver.findElement(By.id("flash")).click();
        driver.close();
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
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }
}
