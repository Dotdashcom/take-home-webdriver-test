package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.DynamicLoading;
import webdrivertestpages.FileDownloader;

/*
 * For FileDownloader what I basically did was I have located the element using xpath and
 * then i just invoked the click() method to click on the file to download.
 * */

public class FileDownloaderTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/download");
    }

    @Test
    public void fileDownloadTest(){
        FileDownloader fl = new FileDownloader(driver);
        fl.fileDownloader();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
