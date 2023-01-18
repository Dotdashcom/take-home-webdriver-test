package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import com.qa.take_home_webdriver_test.constants.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class FileDownloadPage extends BasePage {

    // PAGE INITIALIZATION:
    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By FILE_LINK = By.cssSelector("div[id='content'] div a");

    // WEB ELEMENTS:
    private List<WebElement> getFileLink() {
        wait.until(ExpectedConditions.elementToBeClickable(FILE_LINK));
        return driver.findElements(FILE_LINK);
    }

    // METHODS:
    private void clickLink(String fileName) {
        List<WebElement> listOfFiles = getFileLink();
        for (WebElement s : listOfFiles) {
            log.info("User is searching the '" + fileName + "' list of file links. ");
            if (s.getText().equals(fileName)) {
                log.info("User clicks on the file link for downloading file. ");
                s.click();
                break;
            }
        }
    }

    public void fileDownload(String fileName) throws InterruptedException {
        clickLink(fileName);
        log.info("User is waiting while file downloads. ");
        Thread.sleep(2000); // We can create a custom waiter here, but for saving time purpose we will leave like that
    }

    //    We could to do the same with Chrome Options, but it is more simple solution:
    public boolean isFileDownloaded(String fileName) {
        File downloadPath = new File(Paths.DOWNLOAD_PATH);
        File[] list = downloadPath.listFiles();
        assert list != null;
        for (File s : list) {
            if (s.getName().contains(fileName)) {
                System.out.println(" =====> The downloaded file name is '" + fileName + "' <===== ");
                return true;
            }
        }
        return false;
    }

}


