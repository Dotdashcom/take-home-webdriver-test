package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.nio.file.Paths;

public class FileUploadPage extends AbstractWebPage {

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
        uploadFileName = "Dotdash_logo.png";
        fileAbsPath = String.format("%s%s%s", uploadFileDir, pathSeparator, uploadFileName);
    }

    public void uploadSampleFile() {
        clickOnElementMKB("#file-upload");
        copyPasteRobot(fileAbsPath);
        sleepInSeconds(5);
        uploadButtonElm.click();
    }

    public String getUploadedFileName() {
        return uploadedFileNameElm.getText();
    }
}