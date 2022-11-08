package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilePage {
    WebDriver driver;

    @FindBy(linkText="some-file.txt")
    WebElement file;

    @FindBy(xpath="//INPUT[@id='file-upload']")
    WebElement fileUpload;

    @FindBy(xpath="//*[@id=\"file-submit\"]")
    WebElement button;

    //Initializing the page Objects
    public FilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void FileDownloaded(){
        driver.get("http://localhost:7080/download");
        file.click();
    }

    public String FileUploaded(){
        driver.get("http://localhost:7080/upload");
        fileUpload.sendKeys("C:\\Users\\user\\Downloads\\chromedriver_win32.zip");
        button.click();
        String message  = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
     return message;
    }



}
