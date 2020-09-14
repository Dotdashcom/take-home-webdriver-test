package testByGeorgKelava;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileUpload {
    public FileUpload() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "upload");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }


    @Test
    public void fileUploadTest() throws InterruptedException {
        String filePath = "/Users/user/Downloads/some-file.txt";
        WebElement squareArea = Driver.get().findElement(By.id("drag-drop-upload"));
        new Actions(Driver.get());
        Thread.sleep(7);
        DropFile(new File(filePath), squareArea, 0, 0);
        WebElement uploadedTextFile = Driver.get().findElement(By.cssSelector("div[class=\"dz-preview dz-file-preview dz-processing dz-success dz-complete\"]"));
        Assert.assertTrue(uploadedTextFile.isDisplayed());
    }


    public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
        if (!filePath.exists()) {
            throw new WebDriverException("File not found: " + filePath.toString());
        } else {
            WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            WebDriverWait wait = new WebDriverWait(driver, 30L);
            String JS_DROP_FILE = "var target = arguments[0],    offsetX = arguments[1],    offsetY = arguments[2],    document = target.ownerDocument || document,    window = document.defaultView || window;var input = document.createElement('INPUT');input.type = 'file';input.style.display = 'none';input.onchange = function () {  var rect = target.getBoundingClientRect(),      x = rect.left + (offsetX || (rect.width >> 1)),      y = rect.top + (offsetY || (rect.height >> 1)),      dataTransfer = { files: this.files };  ['dragenter', 'dragover', 'drop'].forEach(function (name) {    var evt = document.createEvent('MouseEvent');    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);    evt.dataTransfer = dataTransfer;    target.dispatchEvent(evt);  });  setTimeout(function () { document.body.removeChild(input); }, 25);};document.body.appendChild(input);return input;";
            WebElement input = (WebElement)jse.executeScript(JS_DROP_FILE, new Object[]{target, offsetX, offsetY});
            input.sendKeys(new CharSequence[]{filePath.getAbsoluteFile().toString()});
            wait.until(ExpectedConditions.stalenessOf(input));
        }
    }
}
