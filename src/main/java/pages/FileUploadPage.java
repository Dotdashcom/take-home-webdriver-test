package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Paths;

public class FileUploadPage extends AbstractWebPage {

    @FindBy(id = "file-upload")
    protected WebElement chooseFileButtonElm;

    @FindBy(id = "file-submit")
    protected WebElement uploadButtonElm;

    @FindBy(id = "uploaded-files")
    protected WebElement uploadedFileNameElm;

    protected String uploadFileDir;
    protected String uploadFileName;
    protected String fileAbsPath;

    public FileUploadPage(WebDriver driver) {
        super(driver);
        uploadFileDir = Paths.get("downloads").toAbsolutePath().toString();
        uploadFileName = "some-file.txt";
        fileAbsPath = String.format("%s\\%s", uploadFileDir, uploadFileName);
    }

    public void uploadSampleFile() {
        clickOnElementJS("#file-upload");
        chooseFileButtonElm.sendKeys("abc");
        System.out.println("Madhoo : " + fileAbsPath);
        copyPasteRobot(fileAbsPath);
        sleepInSeconds(1);
        uploadButtonElm.click();
    }

    public String getUploadedFileName() {
        return uploadedFileNameElm.getText();
    }
}