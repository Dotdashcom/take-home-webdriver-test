package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class fileDownloadPage extends basePage{

    @FindBy(partialLinkText = "file")
    public WebElement file;

}
