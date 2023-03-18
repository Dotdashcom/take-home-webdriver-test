package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FileDownloadPage {
    public WebDriver driver;

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='example']/a")
    public WebElement file;

    public void downloadFileAndVerifyFileExists()  {

        file.click();
        File myObj = new File("\"C:\\Users\\ablik\\IdeaProjects\\bawudong\\some-file.txt\"");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
