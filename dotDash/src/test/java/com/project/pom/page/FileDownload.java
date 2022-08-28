package com.project.pom.page;

import com.project.pom.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

public class FileDownload extends Base {

    By content = By.id("content");
    By file = By.xpath("//div[@class='example']/a");

    public FileDownload(WebDriver driver) {
        super(driver);
    }

    public void fileDownload() throws InterruptedException {
        if (isDisplayed(content)){
            click(file);
            Thread.sleep(2000);
            File file = new File("C:\\Users\\Cristian\\Downloads\\some-file.txt");
            Thread.sleep(2000);
            Assert.assertTrue(file.exists());
        }else {
           System.out.println("file download page was no found");
        }
    }

}
