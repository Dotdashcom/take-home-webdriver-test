package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UploadPage extends Base {
    WebDriver driver;

    By chooseFileButton = By.xpath(readValue("uploadPage.chooseFileButtonXp"));
    By uploadButton = By.xpath(readValue("uploadPage.uploadButtonXp"));
    By uploadedFile = By.xpath(readValue("uploadPage.uploadedFileXp"));

    public void uploadFile(String fileToUpload) {
        String home = System.getProperty(("user.home"));
        String pathFile = home + "\\Downloads\\" + fileToUpload;
        driver.findElement(chooseFileButton).sendKeys(pathFile);
    }

    public void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }

    public boolean isFileUploaded(String fileToVerify) {
        String file = driver.findElement(uploadedFile).getText();
        return file.equals(fileToVerify);
    }

    public UploadPage(WebDriver driver) {
        this.driver = driver;
    }
}
