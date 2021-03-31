package com.webdrivertest.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivertest.utils.ElementUtil;

public class FileDownloadPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public FileDownloadPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
    By fileHyperLink = By.xpath("//*[@id='content']/div/a");
    private final String FILE_NAME = "some-file.txt";
    private String path = System.getProperty("user.dir");
    private String filePath = path + "/downloads/" + FILE_NAME;

    public FileDownloadPage clcikOnDownloadFile() {
        deleteFileIfExist(filePath);
        driver.findElement(fileHyperLink).click();
		return this;
    }
    
    public boolean isFileDownloaded() throws Exception {
        final int SLEEP_TIME_MILLIS = 1000;
        File file = new File(path);
        final int timeout = 60* SLEEP_TIME_MILLIS;
        int timeElapsed = 0;
        while (timeElapsed<timeout){
            if (file.exists()) {
                System.out.println(FILE_NAME + " is present");
                return true;
            } else {
                timeElapsed +=SLEEP_TIME_MILLIS;
                Thread.sleep(SLEEP_TIME_MILLIS);
            }
        }
        return false;
    }

    private boolean isFileExist(String path) {
        File file = new File(path);
        return file.exists();
    }

    private void deleteFileIfExist(String path) {
        File file = new File(path);
        if (isFileExist(path)) file.delete();
    }

}
