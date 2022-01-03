package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileDownloadPage {

    WebDriver webDriver;
    String fileDownloadPageUrl = "http://localhost:7080/download";
    String fileLinkXpath = "//a[@href='download/some-file.txt']";

    public FileDownloadPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(fileDownloadPageUrl);
    }

    public void clickDownloadFile(){
        webDriver.findElement(By.xpath(fileLinkXpath)).click();
    }

}
