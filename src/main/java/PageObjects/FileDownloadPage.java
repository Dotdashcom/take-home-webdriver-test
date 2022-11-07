package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

public class FileDownloadPage {
    public WebDriver driver;

    public FileDownloadPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "a")
    private List<WebElement>documents;






    public void downloadDocument(String file){
        Helpers.SelectElementByTextList(documents,file);

    }

    public boolean validateFileDownload(String path,String file) throws InterruptedException {
        Thread.sleep(2000);
       return Helpers.CheckDownloadedFile(path,file);
    }

}

