package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class FileDownload {
    public FileDownload() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "download");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }



    @Test
    public void fileDownloadTest() {
        WebElement testFileForDownload = Driver.get().findElement(By.xpath("//a[@href='download/some-file.txt']"));
        testFileForDownload.click();
        String fileName = testFileForDownload.getText();
        System.out.println("fileName = " + fileName);
        String filePath = "/Users/user/Downloads/some-file.txt";
        System.out.println("filePath = " + filePath);
    }
}
