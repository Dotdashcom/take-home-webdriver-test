package webdriver.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.FileUpload;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class FileUploadTest {


    private WebDriver driver;
    private FileUpload fileUpload;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        fileUpload = new FileUpload(driver);

    }

    @Test
    public void checkFileUploaded() throws InterruptedException {


        String file = System.getProperty("user.home") + File.separator + "Downloads/some-file.txt";

        fileUpload.uploadFileAndClickButton(file);

        assertTrue(fileUpload.fileUploadedMessage.getText().contains("File Uploaded!"));


    }


    @AfterClass
    public void TearDown() {

        driver.quit();

    }


}
