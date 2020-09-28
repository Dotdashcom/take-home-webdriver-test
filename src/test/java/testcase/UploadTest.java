package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.DownloadPage;
import pageobject.UploadPage;

public class UploadTest {

    private WebDriver driver;
    private UploadPage uploadPage;

    private final static String FILE_NAME = "some-file.txt";
    private String path = System.getProperty("user.dir");
    String separator = System.getProperty("file.separator");
    private String filePath = path + separator + FILE_NAME;

    @BeforeMethod
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.uploadPage = new UploadPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void uploadTest() {
        uploadPage.uploadFile(filePath);
        Assert.assertTrue(uploadPage.verifyUploadSuccessfully());
    }




}
