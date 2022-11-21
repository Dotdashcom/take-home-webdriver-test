package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class FileDownloadPage extends BasePage{


    @FindBy(xpath = "(//a)[2]")
    private WebElement downloadFileInput;



    @BeforeClass
    public static void setUp(){
        DriverTest.getDriver().get("http://localhost:7080/download");
    }



    @Test
    public void clickOnTheFile(){
        waitForVisibilityOf(downloadFileInput);
        String fileToDownload = downloadFileInput.getText();
        downloadFileInput.click();
        String filePath = System.getProperty("user.dir") + "\\" + fileToDownload;
        Assume.assumeTrue("-> File path doesn't contains the downloaded file !!!",filePath.contains("some-file.txt"));
    }


//    @AfterClass
//    public static void tearDown(){
//        DriverTest.getDriver().close();
//    }
}
