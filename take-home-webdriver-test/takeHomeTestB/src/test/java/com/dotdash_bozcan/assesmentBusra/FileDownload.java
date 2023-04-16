package com.dotdash_bozcan.assesmentBusra;
import com.dotdash_bozcan.utilities.ConfigurationReader;
import com.dotdash_bozcan.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileDownload {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/download");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);

    }
    //File Download: File Download.
    @Test
    public void fileDownloadTest(){
        WebElement fileToDownload = Driver.get().findElement(By.xpath("//a[@href='download/some-file.txt']"));
        fileToDownload.click();
        String fileName = fileToDownload.getText();
        System.out.println("fileName = " + fileName);
        String filePath ="/Users/busraoDownloads/some-file.txt";
        System.out.println("filePath = " + filePath);

    }

}
