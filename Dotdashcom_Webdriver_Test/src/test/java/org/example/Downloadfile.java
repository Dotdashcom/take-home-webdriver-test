package org.example;

import Resources.driverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DownloadFile;
import pageObjects.DynamicContent;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Downloadfile extends driverConfig
{

    public WebDriver driver;

    @BeforeTest
    void startdriver() throws IOException
    {
        driver=invokedriver();
        driver.get(baseUrl+"download");
    }


    @Test
    public void Download() throws InterruptedException {

        DownloadFile dl = new DownloadFile(driver);
        Actions a=new Actions(driver);
        Thread.sleep(5000);


        File f=new File("F:\\IDM\\Documents\\some-file.txt");
        a.click(dl.download());

    }

    @AfterTest
    void close()
    {
        driver.close();
    }


}
