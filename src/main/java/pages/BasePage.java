package pages;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public void waitForElementToBeClickable(String cssSelector) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
    }

    public void waitForElementToBeVisible(String cssSelector) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
    }

    public void waitForInvibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fileUploadRobotClass(){
        System.out.println("In FileUpload Class.");
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            System.out.println("AWT ExceptionFound in Robot FileUploading.");
        }
        String dirPath = Paths.get("upload-download").toAbsolutePath().toString();
        String fileName = "Upload-Sample.pdf";
        String fullPath = "";
        if(System.getProperty("os.name").toLowerCase().contains("windows")) {
            fullPath = String.format("%s%s%s", dirPath, "\\", fileName);
        } else if(System.getProperty("os.name").toLowerCase().contains("mac os")) {
            fullPath = String.format("%s%s%s", dirPath, "/", fileName);
        }

        StringSelection str = new StringSelection(fullPath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        pauseInSeconds(3);

        if(System.getProperty("os.name").toLowerCase().contains("windows")) {

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);

            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);

            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

        } else if(System.getProperty("os.name").toLowerCase().contains("mac os")) {
            // Cmd + Tab is needed since it launches a Java app and the browser looses focus
            rb.keyPress(KeyEvent.VK_META);
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_META);
            rb.keyRelease(KeyEvent.VK_TAB);
            rb.delay(500);
            //Open Goto window
            rb.keyPress(KeyEvent.VK_META);
            rb.keyPress(KeyEvent.VK_SHIFT);
            rb.keyPress(KeyEvent.VK_G);
            rb.keyRelease(KeyEvent.VK_META);
            rb.keyRelease(KeyEvent.VK_SHIFT);
            rb.keyRelease(KeyEvent.VK_G);
            //Paste the clipboard value
            rb.keyPress(KeyEvent.VK_META);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_META);
            rb.keyRelease(KeyEvent.VK_V);
            //Press Enter key to close the Goto window and Upload window
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            rb.delay(500);
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            rb.delay(500);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
        }
    }

    public <T> T getPageObject(String pageName, Class<T> pageClassToProxy){
        String landingURL = ConfigReader.getApplicationProperty("landingURL");
        String fullPageURL = landingURL + pageName;
        driver.get(fullPageURL);
        pauseInMilliSeconds(500);

        return PageFactory.initElements(driver, pageClassToProxy);
    }

    public void mouseActionsClickOnElement(String cssSelector) {
        WebElement targetElement = driver.findElement(By.cssSelector(cssSelector));
        Actions actions = new Actions(driver);
        actions.moveToElement(targetElement).click().build().perform();
    }

    public void pauseInSeconds(int seconds) {
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exceptions occurred.");
        }
    }

    public void pauseInMilliSeconds(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exceptions occurred.");
        }
    }

    public boolean isElementSelected(String cssSelector) {
        WebElement elm = driver.findElement(By.cssSelector(cssSelector));
        return elm.isSelected();
    }
}
