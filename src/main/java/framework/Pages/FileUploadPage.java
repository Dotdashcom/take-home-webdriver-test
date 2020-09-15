package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class FileUploadPage {
    WebDriver driver;
    WebDriverWait wait;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "file-upload")
    WebElement chooseFileButton;

    @FindBy(id = "file-submit")
    WebElement uploadButton;

    @FindBy(id = "uploaded-files")
    List<WebElement> uploadedFiles;

    public void uploadFile() {
        chooseFileButton.sendKeys("/Users/syedrashid/take-home-webdriver-test/src/main/resources/upload.txt");
        uploadButton.click();
        for (WebElement element : uploadedFiles) {
            if (element.getText().equals("upload.txt")) {
                break;
            } else
                Assert.fail("file not found");
        }
    }

}
