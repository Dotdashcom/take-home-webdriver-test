package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    
    WebDriver webDriver;
    String fileUploadPageUrl = "http://localhost:7080/upload";
    String fileInputXpath = "//input[@id='file-upload']";
    String submitButtonXpath = "//*[@id='file-submit']";
    String uploadMessageXpath = "//h3[text()='File Uploaded!']";

    public FileUploadPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(fileUploadPageUrl);
    }

    public void upload(String path){
        webDriver.findElement(By.xpath(fileInputXpath)).sendKeys(path);
    }

    public void clickSubmitButton(){
        webDriver.findElement(By.xpath(submitButtonXpath)).click();
    }

    public boolean isUploaded(){
        return webDriver.findElements(By.xpath(uploadMessageXpath)).size()>0;
    }
}
