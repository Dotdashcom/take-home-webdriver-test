package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class FileUpload {
    WebDriver driver;

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", new HashMap<>() {{
            put("download.default_directory", "~/Downloads"); // macos path
        }});

        driver = new ChromeDriver(options);
    }

    public void destroy() {
        driver.close();
    }

    public void clickUpload() {
        driver.get("http://localhost:7080/upload");

        WebElement btnUpload = driver.findElement(By.id("file-upload"));
        btnUpload.sendKeys(System.getProperty("user.home") + "/Downloads/some-file.txt");

        driver.findElement(By.id("file-submit")).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("uploaded-files")));
    }

    public boolean isUploaded(){
        WebElement btnUpload = driver.findElement(By.id("uploaded-files"));
        return btnUpload.isDisplayed();
    }
}
