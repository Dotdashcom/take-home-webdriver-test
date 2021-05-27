package com.dotdash.stepDeffinition;


import com.dotdash.utillities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class DownLoadFileTest {

    WebDriver driver;
    File folder;

    @Before
    public void setup() {



        folder = new File(UUID.randomUUID().toString());
        folder.mkdir(); // mk is makeDirectory

        WebDriverManager.chromedriver().setup();
        ChromeOptions chOpt = new ChromeOptions();


        //creating a map here and I put preferences here key and value format.
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups",0);
        prefs.put("download.default_directory",folder.getAbsolutePath());

        chOpt.setExperimentalOption("prefs",prefs);
        DesiredCapabilities desCap = DesiredCapabilities.chrome();

        desCap.setCapability(ChromeOptions.CAPABILITY, chOpt);


        driver = new ChromeDriver(desCap);

       driver.get("http://localhost:7080/download");



    }

    @After
    public void teardown() {

        driver.quit();

        //downloaded file deleted here
        for (File file : folder.listFiles()) {
            file.delete();
        }
        //emptied folder here
        folder.delete();
    }

    @Test
    public void downLoadFile(){

        WebElement download = driver.findElement(By.linkText("some-file.txt"));
        download.click();

        //We have to wait a few seconds for downloading file.
        try {
          Thread.sleep(2000);
       } catch (InterruptedException e) {
            e.printStackTrace();
       }


        // created array here for file/files
        File listOfFile[] = folder.listFiles();

        //We have to make sure directory is not empty
        Assert.assertTrue(listOfFile.length > 0);

        for (File file : listOfFile) {
            Assert.assertTrue(file.length() > 0);

        }

    }

}
