package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.awaitility.pollinterval.FibonacciPollInterval.fibonacci;

public class DownloadFilePageObject extends BasePageObject {
    @FindBy(css = "div[id='content'] a")
    WebElement file;

    public DownloadFilePageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DownloadFilePageObject downloadFile() {
        file.click();
        return this;
    }

    public String fileName() {
        return file.getText();
    }

    public boolean isFileDownloaded() {
        String downloadPath = System.getProperty("user.home") + "/Downloads";
        String fileName = fileName();
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (File dirContent : dirContents) {
            if (dirContent.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public void until(Callable<Boolean> validation) throws TimeoutException {
        try {
            Awaitility.with()
                    .pollInterval(fibonacci())
                    .await()
                    .atMost(5000, TimeUnit.MILLISECONDS)
                    .until(validation);
        } catch (ConditionTimeoutException exc) {
            throw new TimeoutException();
        }
    }

    public void deleteTheFile() {
        String downloadPath = System.getProperty("user.home") + "/Downloads";
        String fileName = fileName();
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (File dirContent : dirContents) {
            if (dirContent.getName().equals(fileName)) {
                dirContent.delete();
            }
        }
    }
}
