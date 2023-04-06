package com.homewebdriver.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class FileDownloadPage {
    static WebDriver driver;

    private static String FILE_DOWNLOAD_URL="http://localhost:7080/download";

    @FindBy(xpath = "//a[contains(text(),'some-file.txt')]")
    public WebElement fileDownloadLink;


    public FileDownloadPage(WebDriver driver){
        this.driver=driver;
        driver.get(FILE_DOWNLOAD_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void clickFileLinkToDownload() {
        fileDownloadLink.click();
    }


}
