package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class iframePage extends basePage {

    @FindBy(id = "tinymce")
    public WebElement iframe;

    @FindBy(id = "tinymce")
    public WebElement textField;

}
