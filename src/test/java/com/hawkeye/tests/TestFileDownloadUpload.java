package com.hawkeye.tests;

import com.hawkeye.pages.FileDownloadUploadPage;
import com.hawkeye.utilities.Driver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestFileDownloadUpload {

    FileDownloadUploadPage file= new FileDownloadUploadPage();
    private static String downloadPath = "D:\\some-file.txt";

    @Test
    public void Download () throws InterruptedException {

        ChromeOptions option =new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.some-file.txt",false);
        option.setExperimentalOption("prefs",prefs);


        Driver.getDriver().get("http://localhost:7080/download");

        Driver.getDriver().manage().window().maximize();

        file.TextFile.click();

        Thread.sleep(15000);


        Driver.closeDriver();

    }

    @Test
    public void upload() throws InterruptedException {

        Driver.getDriver().get("http://localhost:7080/upload");

        Driver.getDriver().manage().window().maximize();

        String filePath="/Users/nesibesabanci/Desktop/Screen Shot 2022-09-11 at 2.27.09 PM.png";

        file.chooseFileButton.sendKeys(filePath);

        file.UploadButton.click();

        Thread.sleep(4000);

        Assert.assertEquals(file.fileUploadedText.getText(),"File Uploaded!");


    }






}
