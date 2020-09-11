package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadPage extends BaseClass {

    public FileDownloadPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using =  "//a[contains(text(),'some-file.txt')]")
    public WebElement _fileDownloadButton;

    public void ClickOnFile(){
        _fileDownloadButton.click();
    }

}
