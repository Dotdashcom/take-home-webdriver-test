package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.FileDownloadPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileDownload {

    private WebDriver chrome_driver = null;

    @BeforeClass
    void init(){
        Webdriver driver = new Webdriver();
        chrome_driver = driver.get_chrome_driver();
        driver.open_page("download");
    }

    @Test
    void able_to_download_file(){
        FileDownloadPage file_download_page = new FileDownloadPage(chrome_driver);
        file_download_page.click_on_file_link_to_download(); // included verification
    }

    @AfterClass
    void tear_down(){
        chrome_driver.close();
        chrome_driver.quit();
    }
}
