package com.dotdash.pageobject;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class FileDownloadPage extends BasePageObject {
    private final int WAIT_TIME = 10;
    private By file_hyperlink = By.xpath("//*[@id='content']/div/a");
    private final String FILE_NAME = "some-file.txt";
    private String path = System.getProperty("user.dir");
    private String file_path = path + "/downloads/" + FILE_NAME;

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
        open_page("download");
    }

    public FileDownloadPage click_on_file_link_to_download() {
        delete_if_file_existing(file_path);
        driver.findElement(file_hyperlink).click();

        // Wait until file is downloaded
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return is_file_existing(file_path);
            }
        });
        return this;
    }

    private boolean is_file_existing(String path) {
        File file = new File(path);
        return file.exists();
    }

    private void delete_if_file_existing(String path) {
        File file = new File(path);
        if (is_file_existing(path)) file.delete();
    }

    public void verify_file_is_downloaded() {
        delete_if_file_existing(path);
    }
}
