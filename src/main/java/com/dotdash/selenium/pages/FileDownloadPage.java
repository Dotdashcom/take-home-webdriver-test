package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPage extends BasePage {
    @FindBy(css="a[href*=\"download/some-file.txt\"]")
    WebElement downloadLink;

    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void clickDownloadLink(){
        downloadLink.click();
    }

}
