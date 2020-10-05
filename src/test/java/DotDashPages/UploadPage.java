package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadPage {

    public WebDriver ldriver;

    public UploadPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //Capture the choose file
    @FindBy(css="#file-upload")
    public WebElement btnChoosefile;

    //Capture the upload button
    @FindBy(id="file-submit")
    WebElement btnUpload;

    //Capture the file upload message
    @FindBy(xpath="//div[@class=\"example\"]/h3")
    WebElement txtFileUpload;

    //Click on the Choose file button
    public void clkbtnChoosefile()
    {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(btnChoosefile));
        wait.until(ExpectedConditions.elementToBeClickable(btnChoosefile));
        btnChoosefile.click();
    }

    //Click on upload button
    public void clkbtnUpload()
    {
        btnUpload.click();
    }

    //Get the file upload message
    public String gettxtFileUpload() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(txtFileUpload));
        return txtFileUpload.getText();

    }

    public void setClipboardData(String string) {
        //StringSelection is a class that can be used for copy and paste operations.
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void upload(String fileLocation) {
        try {
            //Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}

