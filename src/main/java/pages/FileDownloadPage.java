package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class FileDownloadPage {
    WebDriver driver;
    String fileDownloadUrl =("http://localhost:7080/download");
    String fileXpath = "//a[@href='download/some-file.txt']";
    String HomePath = System.getProperty("user.home");

    public FileDownloadPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(fileDownloadUrl);
    }

    public void clickFile(){
        driver.findElement(By.xpath(fileXpath)).click();
    }

    public boolean isFileDownloaded(String fileName){
        File file = new File(HomePath + "/Downloads/" + fileName);
        return file.exists();
    }
}
