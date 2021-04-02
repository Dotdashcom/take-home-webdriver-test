package dotDash;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.utilities.BaseClass;

import java.util.HashMap;

public class TC110_FileUpload extends BaseClass {

    @Test
    public void fileUpload() throws InterruptedException {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "FileUpload");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Choose File and Upload
        driver.findElement(By.id("file-upload")).sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\uploadDownloadFiles\\upload.txt");
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"upload.txt");
    }
}