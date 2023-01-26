import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownload {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/download");
        driver.manage().window().maximize();
    }
    @Test
    public void fileDownload() throws InterruptedException {
        String downloadPath = FileUtils.getUserDirectoryPath();
        File downloadDirectory = new File(downloadPath,"Downloads");
        WebElement file = driver.findElement(By.xpath("//a[@href=\\\"download/some-file.txt\\\"]"));
        file.click();
        Thread.sleep(2000);
        File addfilename = new File(downloadDirectory, file.getText());//path with file name
        System.out.println(addfilename.getAbsolutePath());
        Assert.assertTrue(addfilename.exists());

        //Test clicks on the file
       // driver.findElement(By.xpath("//a[@href=\"download/some-file.txt\"]")).click();
        //Test asserts that the file is downloaded.
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
