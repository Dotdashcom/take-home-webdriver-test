package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.LoginPage;
import pages.SecureAreaPage;

import java.io.File;

public class Test10FileDownload {
    WebDriver driver;

    @BeforeSuite
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void Test10FileDownload() throws InterruptedException {
        String url = "http://localhost:7080/download";
        driver.get(url);

        By fileLinkXpath = By.xpath("//div[@class='example']/a");
        WebElement fileLink = driver.findElement(fileLinkXpath);
        fileLink.click();

        String filePath = "/Users/" + System.getProperty("user.name") + "/Downloads/some-file.txt";
        File downloadedFile = new File(filePath);
        //slight wait to make sure temporary file type crdownload goes away
        //there are more robust implementations for waiting for a file to show up in a directory
        //but figured that's overkill for this
        Thread.sleep(2000);
        Assert.assertTrue(downloadedFile.exists());

    }

    @AfterMethod
    public void  tearDown() {
        driver.close();
    }
}