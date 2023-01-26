import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileUpload {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/upload");
        driver.manage().window().maximize();
    }
    @Test
    public void fileUpload() throws InterruptedException {
        String downloadPath = FileUtils.getUserDirectoryPath();
        File downloadDirectory = new File(downloadPath,"Downloads");
        String fileName = "some-file.txt";
        File fileUpload = new File(downloadDirectory,fileName);
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys(fileUpload.getAbsolutePath());
        Thread.sleep(5000);
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        Thread.sleep(5000);
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(uploadedFile.isDisplayed());
    }

}
