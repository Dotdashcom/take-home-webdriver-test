package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.FileDownloadPage;
import pages.utils;

import java.io.File;
import java.util.HashMap;


public class FileDownloadTest {
    FileDownloadPage fileDownloadPage;

    public FileDownloadTest() {
        fileDownloadPage = new FileDownloadPage();
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {

        String downloadPath = System.getProperty("user.dir");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        driver.get(utils.url + "/download");

        driver.findElement(fileDownloadPage.fileDownload()).click();

        Thread.sleep(2000);
        File f = new File(downloadPath + "/some-file.txt");

        if (f.exists()) {
            Assert.assertTrue(f.exists());
            System.out.println("passed");
            driver.quit();
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



