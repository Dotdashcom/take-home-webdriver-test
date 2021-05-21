package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import javax.activation.CommandInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilePage {
    private WebDriver driver;
    //explicit wait
    WebDriverWait wait;
    //Download Page URL
    private static String DOWNLOAD_PAGE_URL = CommonUtils.getBaseUrl() + "download";
    //Upload Page URL
    private static String UPLOAD_PAGE_URL = CommonUtils.getBaseUrl() + "upload";
    //Download path
    private static String DOWNLOAD_PATH = CommonUtils.getDownloadDirectory();
    //Upload path
    private static String UPLOAD_PATH = CommonUtils.getUploadDirectory();

    //File link
    @FindBy(linkText = "some-file.txt")
    private WebElement fileLink;
    //Upload File button
    @FindBy(id = "file-upload")
    private WebElement fileUpload;
    //Upload File button
    @FindBy(id = "file-submit")
    private WebElement uploadButton;
    //Uploaded File Name
    @FindBy(id = "uploaded-files")
    private WebElement uploadedFile;
    //Page Heading
    @FindBy(tagName = "h3")
    private WebElement headerText;

    //Constructor
    public FilePage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Verify file download
    public void verifyFileDownload(String fileName) {
        driver.get(DOWNLOAD_PAGE_URL);
        fileLink.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File dir = new File(System.getProperty("user.dir") + DOWNLOAD_PATH);
        File[] dirContents = dir.listFiles();
        assertTrue(dirContents[0].getName().equals(fileName));
    }

    //Verify file download
    public void verifyFileUpload(String fileName) {
        driver.get(UPLOAD_PAGE_URL);
        fileUpload.sendKeys(System.getProperty("user.dir") + UPLOAD_PATH + "/" + fileName);
        uploadButton.click();
        wait.until(ExpectedConditions.visibilityOf(uploadedFile));
        assertEquals(uploadedFile.getText(), fileName);
    }

    //Delete the file
    public void deleteDownloadedFile() {
        File dir = new File(System.getProperty("user.dir") + DOWNLOAD_PATH+"/some-file.txt");
        dir.delete();
    }
}
