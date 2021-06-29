package com.new_york_remote.pages;

import com.new_york_remote.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloaderPage {
    public FileDownloaderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a)[2]")
    public WebElement downloadButton;
}
