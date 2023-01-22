package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_automation.utilities.Driver;

import java.io.File;

public class DownlaodFilePage  extends BasePage{

     private WebDriver driver = Driver.getDriver();
    @FindBy(xpath = "//a[text() = 'some-file.txt']")
    public WebElement file;


    public DownlaodFilePage(WebDriver driver) {
        super(driver);
    }

    public void downloadFile()throws  InterruptedException{

    }
//    public void deletePreviousDownFile(String path, String fileName){
//        File file1 = new File(path + "/" + fileName);
//        if(file1.exists()){
//            file1.delete();
//        }
//
//    }


}
