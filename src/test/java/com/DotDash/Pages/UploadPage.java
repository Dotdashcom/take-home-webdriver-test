package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UploadPage {

    public WebDriver ldriver;

    public UploadPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(css="#file-upload")
    public WebElement btnChoosefile;

    @FindBy(id="file-submit")
    WebElement btnUpload;

    @FindBy(xpath="//div[@class=\"example\"]/h3")
    WebElement txtFileUpload;


    public void clkbtnUpload()
    {
        btnUpload.click();
    }

    public String gettxtFileUpload() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(txtFileUpload));
        return txtFileUpload.getText();

    }

}
