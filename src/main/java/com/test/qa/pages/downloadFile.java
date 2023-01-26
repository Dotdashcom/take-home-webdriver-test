package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;

public class downloadFile extends TestBase{



    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    WebElement clicks_on_the_file;

    public downloadFile() {
        PageFactory.initElements(driver, this);
    }

    public void fileDown() throws InterruptedException {

        clicks_on_the_file.click();

        String path = "/Users/hiralvaghela/Desktop/Selenium";
        File file = new File(path);
        Thread.sleep(3000);
        Boolean file_to_download = file.exists();
        Assert.assertTrue(file_to_download, "File not downloaded");


    }
}

