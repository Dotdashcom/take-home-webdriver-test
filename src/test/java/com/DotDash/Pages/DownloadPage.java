package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class DownloadPage {

    public WebDriver ldriver;
    @FindBy(xpath = "//div[@class=\"example\"]/a")
    WebElement txtfile;

    public DownloadPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    public static boolean isFileExists(String path) {
        File file = new File(path);
        return file.exists();

    }

    public void clktxtfile() {
        txtfile.click();
    }
}
