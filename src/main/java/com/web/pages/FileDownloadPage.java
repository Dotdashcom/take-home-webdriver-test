package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;


public class FileDownloadPage extends TestBase {

    @FindBy(xpath="//div[@id='content']/div/a")
    WebElement linkText;

    public FileDownloadPage(){

        PageFactory.initElements(driver, this);
    }

    public void clickLinkText(){
         linkText.click();
    }

}
