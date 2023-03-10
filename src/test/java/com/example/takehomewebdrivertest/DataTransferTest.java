package com.example.takehomewebdrivertest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataTransferTest {
    private WebDriver driver;
    private static final String BaseUrl = "http://localhost:7080/";
    private String filePath;
    //Downloaded file name
    private final String fileName = "some-file.txt";

    @BeforeEach
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        // Set the download path
        //Current path
        filePath = new java.io.File(".").getCanonicalPath();
        // Set the Chrome options to download the file in the specified location
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", filePath);
        options.setExperimentalOption("prefs", chromePrefs);
        // Start the Chrome driver with the options
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void fileDownload() throws InterruptedException {
        //Download file
        driver.get(BaseUrl + "download");
        driver.findElement(By.xpath("//*[@id='content']/div/a")).click();
        // Wait for the download to complete
        Thread.sleep(5000);
        // Check if the file is downloaded in the specified location
        File file = new File(filePath + "\\" + fileName);
        Assertions.assertTrue(file.exists());
        //Delete file
        file.delete();
    }
    @Test
    public void fileUpload() throws IOException, InterruptedException, AWTException {
        //Create file for test
        String fullPath = filePath + "\\test.txt";
        File testFile = new File(fullPath);
        testFile.createNewFile();
        //Upload file
        driver.get(BaseUrl + "upload");
        WebElement chooseFileField = driver.findElement(By.id("drag-drop-upload"));
        chooseFileField.click();
        //Write to popup window
        Actions action =new Actions(driver);
        action.sendKeys(fullPath).perform();
        //Upload
        driver.findElement(By.id("file-submit")).click();
        //Delete file
        testFile.delete();
        assert (driver.findElement(By.id("uploaded-files")).getText().equals("test.txt"));

    }
}
