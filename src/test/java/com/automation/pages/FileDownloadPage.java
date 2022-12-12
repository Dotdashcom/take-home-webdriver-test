package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;

public class FileDownloadPage extends BasePage {

    @FindBy(xpath = "//a[@href='/download']")
    WebElement link;

    @FindBy(xpath = "//div[@class='example']//a")
    WebElement downloadLink;

    public void clickOnLink(){
        link.click();
    }

    public void download() {
        File fileLocation = new File("//C:\\Users\\Asus\\Downloads");
        File[] totalFiles = fileLocation.listFiles();
        for (File file : totalFiles) {
            if (file.getName().equals("some-file.txt")) {
                Assert.assertTrue(true);
                break;
            }
        }
    }
}