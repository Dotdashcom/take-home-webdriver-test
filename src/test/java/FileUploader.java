import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.FileUploaderPage;

import static org.testng.AssertJUnit.assertTrue;

public class FileUploader {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/upload");
    }

    @Test(testName = "File Upload")
    public void uploadFile() {
        FileUploaderPage page = new FileUploaderPage(driver);
        String uploadFile = "/Users/virajgandhi/Downloads/12-Rules-to-Learn-to-Code-eBook-Updated-26.11.18.pdf";
        page.uploadFile(uploadFile);
        assertTrue("Unable to upload file", page.isUploaded());
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
