package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.FilePage;
import utils.CommonUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DotDashFileTest {
    WebDriver driver;
    ChromeOptions options;
    FilePage filePage;
    private static String DOWNLOAD_FILE_NAME = "some-file.txt";
    private static String UPLOAD_FILE_NAME = "sample-file.txt";

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        Map<String, Object> driverPrefs = new HashMap<String, Object>();
        driverPrefs.put("download.default_directory", System.getProperty("user.dir") + CommonUtils.getDownloadDirectory());
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", driverPrefs);
        driver = new ChromeDriver(options);
        filePage = new FilePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testFileDownload() {
        filePage.verifyFileDownload(DOWNLOAD_FILE_NAME);
        filePage.deleteDownloadedFile();
    }

    @Test
    public void testFileUpload() {
        filePage.verifyFileUpload(UPLOAD_FILE_NAME);
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
