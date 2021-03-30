package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iframePage {

    public WebDriver ldriver;
    @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
    public WebElement txtcontentbox;

    public iframePage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }



    public void setTxtcontentbox(String content) {
        txtcontentbox.sendKeys(content);
    }

    public String getenteredtxt() {
        return txtcontentbox.getText();
    }
}
