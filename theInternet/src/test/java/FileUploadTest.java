import PageObjects.FileUploadPage;
import PageObjects.HomePage;
import library.BrowserFactory;
import library.Constants;
import library.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static library.Constants.FileUploadConstants.FILE_UPLOAD_STATUS;

public class FileUploadTest {

    String WORKING_DIR = System.getProperty("user.dir");
    String filePath = WORKING_DIR + "/src/resources/TestData/abc.jpg";
    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void validateFileUpload() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.FILE_UPLOAD_LINKTEXT);
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.uploadFile(filePath);
        Thread.sleep(3000);
        Assert.assertEquals(fileUploadPage.fileUploadStatusText(), FILE_UPLOAD_STATUS);
    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

