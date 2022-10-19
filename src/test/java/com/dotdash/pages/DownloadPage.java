package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadPage extends BasePage{

    @FindBy (linkText = "some-file.txt")
    public WebElement file;

}
