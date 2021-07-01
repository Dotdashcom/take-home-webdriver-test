package webdriver.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.FileDownload;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class FileDownloadTest {


    private WebDriver driver;
    private FileDownload fileDownload;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        fileDownload = new FileDownload(driver);

    }

    @Test
    public void checkFileDownload() throws InterruptedException {

        fileDownload.clickDownloadLink();


        Thread.sleep(5000); // wait for File to download

        assertTrue(fileDownload.isFileDownloaded(System.getProperty("user.home") + File.separator + "Downloads", "some-file.txt"), "Failed to download File");

    }


    @AfterClass
    public void TearDown() {

        driver.quit();

    }


}
