package com.ProjectName.test;

import com.ProjectName.Base.BaseTest;
import com.ProjectName.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest extends BaseTest {

    @BeforeTest
    public void setupTest(){
        driver.get(BrowserUtils.getBaseUrl() + "/download");
    }

    @Test
    public void downloadTest(){
        String localDirectory = ""; // your local machine download directory
       WebElement downloadFile = driver.findElement(By.xpath("//a[.='some-file.txt']"));
        downloadFile.click();
//        File file =new File("C:\\Users\\igork\\Downloads\\some-file.txt"); this work only on my local machine
        File file = new File(localDirectory + "some-file.txt");
        Assert.assertTrue(file.exists());

    }
}
