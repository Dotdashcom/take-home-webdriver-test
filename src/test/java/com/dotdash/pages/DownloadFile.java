package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

@Url("/download")
public class DownloadFile extends WebPage {

    @FindBy(css = ".example > a")
    private WebElement downloadLink;

    public DownloadFile downloadFile() {
        click(downloadLink);
        return this;
    }

    public String getDownloadFilename() {
        return getText(downloadLink);
    }
}
