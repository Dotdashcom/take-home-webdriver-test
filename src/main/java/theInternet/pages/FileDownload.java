package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;

public class FileDownload {

    public FileDownload(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "File Download")
    WebElement download;

    @FindBy(linkText = "some-file.txt")
    WebElement someFileDownload;

    public void downloadFile(String downloadPath){
        download.click();
        someFileDownload.click();
        File someFile = new File(downloadPath);
        File[] files = someFile.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
            if (file.getName().equals("some-file.txt")){
                Assert.assertTrue(file.getName().equals("some-file.txt"));
            }

        }

    }
}
