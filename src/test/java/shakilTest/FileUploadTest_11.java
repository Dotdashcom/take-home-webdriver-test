package shakilTest;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest_11 extends TestBase {

    @Test
    public void testFileUpload() throws InterruptedException {
        driver.get("http://localhost:7080/upload");

        // Select the file to upload
        WebElement fileUploadInput = driver.findElement(By.xpath("//input[@id='file-upload']"));
        File fileToUpload = new File("C:\\Users\\Shaki\\Downloads\\some-file.txt");
        fileUploadInput.sendKeys(fileToUpload.getAbsolutePath());

        // Click the upload button
        WebElement uploadButton = driver.findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();

        // Wait for the upload to complete
        Thread.sleep(200); 


        // Verify that the file is uploaded successfully
        String uploadedFileName = driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText();
        Assert.assertEquals(uploadedFileName, fileToUpload.getName(), "some-file.txt");
    }
}
