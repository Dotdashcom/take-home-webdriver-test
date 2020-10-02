package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadRepository extends TestEngine {

    //parameterized constructor
    public FileDownloadRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(@href,'some-file.txt')]")
    public WebElement _fileDownload;

    public void ClickOnFileDownload() throws InterruptedException {
        _fileDownload.click();
        Thread.sleep(5000);
    }

    public boolean IsFileDownloadedInPath(){
      return  SeleniumCommonMethods.IsFileDownloaded(downloadPath,"some-file.txt");
    }
}
