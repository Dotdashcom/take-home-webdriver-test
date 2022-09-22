package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;

public class FileDownloadPage extends BasePage {

    private final By fileLink = By.xpath("//*[@id='content']/div/a");

    public FileDownloadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("file_download__url"));
    }

    public void downloadFile() {
        String homePath=System.getProperty("user.home");
        File file=new File(homePath+"/Downloads/some-file.txt");
        findElement(fileLink).click();

        wait(2000);
        Assert.assertTrue(file.exists());
        Log.info("File downloaded Successfully");
    }
}
