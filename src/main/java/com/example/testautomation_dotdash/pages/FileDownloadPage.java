package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class FileDownloadPage extends BasePage {

    public FileDownloadPage(WebDriver driver){
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/download");
    }


    @FindBy(css = "div[class='example'] a[href='download/some-file.txt']")
    private WebElement someFileHyperlink;


    public void clickSomeFileHyperlink() throws InterruptedException{
        someFileHyperlink.click();
        Thread.sleep(1000);
    }


}
