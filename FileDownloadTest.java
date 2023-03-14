package testPackages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class FileDownloadTest extends BaseTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFileDownload() {
        driver.get("http://localhost:7080/download");
        WebElement downloadLink = driver.findElement(By.linkText("some-file.txt"));
        downloadLink.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // replace path with as per requirement
        File downloadedFile = new File("path");
        Assert.assertTrue(downloadedFile.exists());
    }
}
