package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPageModel extends PageObject {

    public static final String PAGE_URL = "/download";

    @FindBy(xpath = "//*[@id='content']/div/a[1]")
    private WebElement fileLink;

    public WebElement getFileLink() {
        return fileLink;
    }

    public FileDownloadPageModel(WebDriver driver) {
        super(driver);
    }
}
