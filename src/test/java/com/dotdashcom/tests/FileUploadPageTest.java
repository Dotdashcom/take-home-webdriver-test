package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.FileUploadPageModel;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class FileUploadPageTest extends MainTest {

    public static final String TEST_FILE_NAME = "some-test-file.txt";
    FileUploadPageModel page;

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
        page = new FileUploadPageModel(driver);
        driver.get(BASE_URL + FileUploadPageModel.PAGE_URL);
    }

    @Test
    void WHEN_click_upload_button_THEN_file_uploaded() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(FileUploadPageModel.PAGE_URL));

        // First creating a test file that will be uploaded
        String filePath = System.getProperty("java.io.tmpdir") + TEST_FILE_NAME;
        Path path = Paths.get(filePath);
        try {
            Files.write(path, Arrays.asList("test", "test"), StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println(e);
        }
        Assert.assertTrue(new File(filePath).exists());

        page.getFileSelectElement().sendKeys(filePath);
        page.getUploadButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOf(page.getUploadedFilesDiv()));

        Assert.assertEquals(page.getUploadedFilesDiv().getText(), TEST_FILE_NAME);

        // Clean up, so the old file doesn't affect future tests
        Assert.assertTrue(new File(filePath).exists());
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            System.out.println(e);
        }
        Assert.assertFalse(new File(filePath).exists());
    }
}
