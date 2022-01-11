package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    WebDriver driver;
    String fileUploadUrl =("http://localhost:7080/upload");
    By chooseFileId = By.id("file-upload");
    By uploadButtonId = By.id("file-submit");
    By dragAndDropId = By.id("drag-drop-upload");
    By uploadedFilesId = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(fileUploadUrl);
    }

    public void chooseFile(String filePath){
        driver.findElement(chooseFileId).sendKeys(filePath);
    }

    public void clickDragDrop(String filePath){
        driver.findElement(uploadButtonId).sendKeys(filePath);
    }

    public void clickUploadBution(){
        driver.findElement(uploadButtonId).click();
    }

    public boolean isUploaded(){
        return driver.findElements(uploadedFilesId).size()>0;
    }

}
