package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.File;

public class FileDownloadPage extends BasePage {

    @FindBy(how = How.LINK_TEXT, using = "some-file.txt")
    private WebElement file;

    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    public FileDownloadPage goToFileDownloadPage() {
        driver.get(BASEURL + "/download");
        return this;
    }

    public FileDownloadPage clickDownloadFile() {
        waitForClickabilityOf(file).click();
        return this;
    }

    public boolean isFileDownloaded(File file) {
        return waitForCondition(file);
    }

}
