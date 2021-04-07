package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;

public class FileDownloadPage {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    public WebElement link_Download;

    public FileDownloadPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void verifyFileDownload() {
        try {
            if (link_Download.isDisplayed())
                link_Download.click();
            File dir = new File("/Users/Downloads");
            File[] dirContents = dir.listFiles();
            for (int i = 0; i < dirContents.length; i++) {
                if (dirContents[i].getName().equalsIgnoreCase("sample-file.txt")) {
                    break;
                } else {
                    Thread.sleep(2000);
                }
            }
        }catch(Exception e)
        {

        }
    }

}


