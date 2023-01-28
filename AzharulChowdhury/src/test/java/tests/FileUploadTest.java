package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FileUploadTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/upload");
    }

    @Test
    public void fileUpload() {
        WebElement fileInput = Driver.getDriver().findElement(By.id("file-upload"));
        fileInput.sendKeys("path/to/file.txt");
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement uploadedFile = Driver.getDriver().findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFile.getText(), "file.txt");
    }


    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
