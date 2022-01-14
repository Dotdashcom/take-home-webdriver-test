package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage extends PageGeneral{

    public FileUploadPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebElement chooseFileComponent() {
        return this.driver.findElement(By.id("file-upload"));
    }

    public WebElement uploadComponent() {
        return this.driver.findElement(By.id("file-submit"));
    }

    public WebElement uploadedFilesComponent() {
        return this.driver.findElement(By.id("uploaded-files"));
    }

}
