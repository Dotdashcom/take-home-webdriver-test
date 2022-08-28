package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUpload extends Base {

    By content = By.id("content");
    By chooseFile = By.xpath("//input[@id='file-upload']");
    By upload = By.xpath("//input[@class=\"button\"]");
    By uploadFile = By.xpath("//div[@id=\"uploaded-files\"]");

    public FileUpload(WebDriver driver) {
        super(driver);
    }

    public void fileUpload() throws InterruptedException {
        if (isDisplayed(content)){
            sendKeys("C:\\Users\\Cristian\\Downloads\\some-file.txt", chooseFile);
            Thread.sleep(2000);
            click(upload);
            Thread.sleep(2000);
        }else {
            System.out.println("file upload page was no found");
        }
    }

    public String fileUploadSuccess(){
        System.out.println("hola"+ getText(uploadFile));
        return getText(uploadFile);
    }
}
