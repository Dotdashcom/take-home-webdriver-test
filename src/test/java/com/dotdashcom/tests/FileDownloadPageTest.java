package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.FileDownloadPageModel;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class FileDownloadPageTest extends MainTest {

    FileDownloadPageModel page;

    @Override
    @BeforeMethod
    public void setupDriver() {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("java.io.tmpdir"));
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
    }

    private void init() {
        page = new FileDownloadPageModel(driver);
        driver.get(BASE_URL + FileDownloadPageModel.PAGE_URL);
    }

    @Test
    void WHEN_click_file_link_THEN_file_downloaded() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(FileDownloadPageModel.PAGE_URL));

        page.getFileLink().click();

        File file = new File(System.getProperty("java.io.tmpdir") + page.getFileLink().getText());

        // We might want to clean up any old file with this name for the test to assert properly
        // But need to be careful not ot delete non-test files, so commenting this out for now
//        if (file.exists()) {
//            file.delete();
//        }

        // Wait for up to 60 seconds for the file to be downloaded, check every second
        int count = 0;
        while (count < 60 && !file.exists()) {
            count++;
            try {
                sleep(1_000L);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        Assert.assertTrue(file.exists());
        // Clean up, so the old file doesn't affect future tests
        if (file.exists()) {
            file.delete();
        }
    }
}
