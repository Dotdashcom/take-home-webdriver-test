package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class FileDownload {
    WebDriver driver;
    File downloaded;

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", new HashMap<>() {{
            put("download.default_directory", "~/Downloads"); // macos path
        }});

        driver = new ChromeDriver(options);
        driver.get("http://localhost:7080/download");

        String home = System.getProperty("user.home");
        downloaded = new File(home + "/Downloads/some-file.txt");
    }

    public void destroy() {
        driver.close();
    }

    public void clickDownload() {

        WebElement btnDownload = driver.findElement(By.cssSelector("a[href*=\"some-file.txt\"]"));
        btnDownload.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until((d) -> isExist());
    }

    public boolean isExist(){
        return downloaded.exists();
    }
}
