package pageobject;

import base.EndPointPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, 'download/')]")
    private WebElement downloadLink;

    private final static int WAIT_TIME = 10;



    public DownloadPage(WebDriver driver) {
        super(driver, EndPointPath.DOWNLOAD);

    }

    public void downloadFileByUsingProfile(String filePath) {
        deleteWhenFileExisted(filePath);

        //Solution 1: Click and save directly because Chrome automation does not ask location and use default
        downloadLink.click();

        waitUntilFileDownloaded(filePath);


    }

    private void rightClickMouseAndSaveAs(int offsetPressKeyDown, String pathFile) {
        //Right click and save as
        Actions action = new Actions(driver);
        action.contextClick(downloadLink);
        action.build().perform();
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < offsetPressKeyDown; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //Delay for dialog display
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Paste pathFile and save
        setClipboardData(pathFile);
        //delete old default filePath
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //click save
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_ALT);

    }


    private void waitUntilFileDownloaded(String filePath) {
        //Wait until file downloaded
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until((WebDriver driver) -> isFileExisting(filePath));
    }

    private void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    private boolean isFileExisting(String path) {
        File file = new File(path);
        return file.exists();
    }

    private void deleteWhenFileExisted(String path) {
        File file = new File(path);
        if (isFileExisting(path))
            file.delete();
    }

    public void downloadFileByUsingRobotInteractDialog(String filePath) {
        deleteWhenFileExisted(filePath);

        //Solution 2: Interact save as in diaglog and paste filePath
        rightClickMouseAndSaveAs(4, filePath);

        waitUntilFileDownloaded(filePath);
    }
}
