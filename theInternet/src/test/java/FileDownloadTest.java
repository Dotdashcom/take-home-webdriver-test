
import PageObjects.FileDownloadPage;
import PageObjects.HomePage;
import library.BrowserFactory;
import library.Constants;
import library.JavaLibrary;
import library.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileDownloadTest {

    String WORKING_DIR = System.getProperty("user.dir");
    String filePath = WORKING_DIR + "/src/resources/TestData/abc.jpg";
    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void validateFileUpload() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.FILE_DOWNLOAD_LINKTEXT);
      FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
        fileDownloadPage.downloadFile();
        Assert.assertTrue(new JavaLibrary().isFileDownloaded(System.getProperty("user.dir")));
    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

