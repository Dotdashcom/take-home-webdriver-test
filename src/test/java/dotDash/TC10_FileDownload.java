package dotDash;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseClass;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TC10_FileDownload extends BaseClass {

    @Test
    public void fileDownload() throws InterruptedException {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "FileDownload");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Download File
        driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]")).click();
        Thread.sleep(5000);
        //Check file downloaded successfully at given path
        Path path = Paths.get(System.getProperty("user.home") + "\\Downloads\\some-file.txt");
        Assert.assertTrue(path.toFile().exists());
    }
}
