package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/upload
public class FileDownloadPage {
    @FindBy(xpath = "//*[text() = 'some-file.txt']")
    public WebElement linkSomeFile;













    public FileDownloadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
