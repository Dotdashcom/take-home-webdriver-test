package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageobject.DownloadPage;

public class DownloadTest {

    private WebDriver driver;
    private DownloadPage downloadPage;

    private final static String FILE_NAME = "some-file.txt";
    private String path = System.getProperty("user.dir");
    String separator = System.getProperty("file.separator");
    private String filePath = path + separator + FILE_NAME;

    @BeforeMethod
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser(path).getDriver();
        //driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.downloadPage = new DownloadPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void downloadTest1() {
        downloadPage.downloadFileByUsingProfile(filePath);
    }

    @Test
    public void downloadTest2() {
        downloadPage.downloadFileByUsingRobotInteractDialog(filePath);
    }


}
