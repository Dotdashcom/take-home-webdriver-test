package dotDash;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseClass;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class TC11_FileUpload extends BaseClass {

    @Test
    public void fileupload() throws InterruptedException {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "FileUpload");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Choose File and Upload
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\spanwar\\Downloads\\upload.txt");
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"upload.txt");
    }
}
