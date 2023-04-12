package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;

import java.io.File;

public class FileUpload extends DriverUtilities {

    @Before
    public void setUp(){
        createDriver();
        getDriver().navigate().to("http://localhost:7080/upload");
    }
    @Test
    public void fileUploadTest(){
        WebDriver driver = getDriver();
        WebElement fileUploadInput = driver.findElement(By.xpath("//input[@id='file-upload']"));
        File fileToUpload = new File("/Users/andrii/Downloads/some-file.txt");
        fileUploadInput.sendKeys(fileToUpload.getAbsolutePath());
        WebElement uploadButton = driver.findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();
        String uploadedFileName = driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText();
        Assert.assertEquals(uploadedFileName, fileToUpload.getName(), "some-file.txt");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }

}
