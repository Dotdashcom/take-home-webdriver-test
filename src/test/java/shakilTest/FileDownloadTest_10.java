package shakilTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest_10 extends TestBase {

    @Test
    public void testFileDownload() {
        driver.get("http://localhost:7080/download");

        // Click the download button
        WebElement downloadButton = driver.findElement(By.xpath("//div[@id='content']//a[@href='download/some-file.txt']"));
        downloadButton.click();
        
        String downloadedFilePath = "C:\\Users\\Shaki\\Downloads\\some-file.txt";
        File downloadedFile = new File(downloadedFilePath);
        Assert.assertTrue(downloadedFile.exists(), "The file was not downloaded successfully");
    }
}
