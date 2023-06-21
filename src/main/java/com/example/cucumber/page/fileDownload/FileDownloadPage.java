package com.example.cucumber.page.fileDownload;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static com.example.constants.Page.FILE_DOWNLOAD_PAGE;
import static com.example.constants.PageLinkText.FILE_DOWNLOAD;
import static com.example.constants.UtilConstants.DOWNLOAD_FILE_NAME;
import static com.example.constants.UtilConstants.DOWNLOAD_PATH;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileDownloadPage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();
    public FileDownloadPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By file_download_page_link = By.linkText(FILE_DOWNLOAD);


    public void the_user_clicks_on_file_download_page() {
        clckOnWebElement(file_download_page_link);
    }

    public void the_user_should_see_the_file_download_page() {
        assertEquals("File Download Page URL doesn't Match: ", FILE_DOWNLOAD_PAGE, driver.getCurrentUrl());
    }

    public void the_user_clicks_on_the_link_on_the_file_download_page(String fileName) {
        By fileNameXpath = By.xpath("//a[contains(text(),'" + fileName +"')]");
        clckOnWebElement(fileNameXpath);
    }

    public void the_user_should_see_the_file_is_downloaded_on_the_dynamic_loading_page() {
        String fileName = DOWNLOAD_FILE_NAME; // Replace with the expected file name
        String downloadPath = DOWNLOAD_PATH; // Replace with the actual download folder path
        String filePath = downloadPath + File.separator + fileName;
        File downloadedFile = new File(filePath);
        assertTrue("File is not downloaded", downloadedFile.exists());
    }
}
