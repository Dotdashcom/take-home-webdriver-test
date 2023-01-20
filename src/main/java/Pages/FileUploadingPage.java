package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FileUploadingPage {
    public WebDriver driver;
    public Helpers helpers;

    public FileUploadingPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    //REMOVE/ADD
    public By input_upload = By.id("file-upload");
    public By upload_button = By.id("file-submit");
    public By message_file_uploaded = By.id("uploaded-files");

    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToFileUploading() {

        driver.navigate().to(driver.getCurrentUrl() + "upload");
    }


    public void Upload_File() {
        helpers.sendText(input_upload,System.getProperty("user.dir") + "\\src\\test\\resources\\upload\\test_upload.tzt");
        helpers.Click(upload_button);

    }

    public void AssertFileWasUpload() {
        Assert.assertEquals(helpers.getText(message_file_uploaded), "test_upload.tzt", "File was uploaded with errors");


    }
}
