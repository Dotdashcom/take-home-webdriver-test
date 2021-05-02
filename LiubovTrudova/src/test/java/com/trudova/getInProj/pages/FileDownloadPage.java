package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadPage extends BasePage{
    public FileDownloadPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(linkText = "some-file.txt")
    public WebElement fileToDownload;
}
