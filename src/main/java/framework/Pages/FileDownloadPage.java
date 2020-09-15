package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.WebDriverWrapper;

import java.io.File;

public class FileDownloadPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='content']/div/a")
    WebElement downloadLink;

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void downloadFileFromLink(){
        downloadLink.click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File downloadedFile = new File(System.getProperty("user.home") + "/Downloads/some-file.txt");
        Assert.assertTrue(downloadedFile.exists());

    }
}
